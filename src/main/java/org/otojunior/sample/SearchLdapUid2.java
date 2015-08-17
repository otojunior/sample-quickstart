package org.otojunior.sample;

import java.util.Properties;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Main Class.
 * @author [Author name]
 */
public class SearchLdapUid2 {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SearchLdapUid2.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		String base = "ou=users,ou=supde,o=acme,c=br,dc=example,dc=com";
		String filter = "(&(uid=otojunior)(objectClass=person))";
		
		Properties env = new Properties();
        env.put(DirContext.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(DirContext.PROVIDER_URL, "ldap://localhost:10389");
        
        try {
        	DirContext dc = new InitialDirContext(env);
        	
        	/* 
        	 * Above we mentioned the filter and base. 
        	 * Another important part of the search criteria 
        	 * is the scope. There are three scopes: 
        	 * base (this entry only), 
        	 * onelevel (the direct children of this entry), and 
        	 * subtree (this entry and all of its decendents in the tree). 
        	 * In JNDI, OBJECT_SCOPE indicates a base search.
        	 */
        	SearchControls sc = new SearchControls();
        	sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        	sc.setReturningAttributes(null);
        	
        	NamingEnumeration<?> ne = dc.search(base, filter, sc);
        	
        	while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                LOG.info("Name: " + sr.getName());
                LOG.info("NameInNamespace: " + sr.getNameInNamespace());

                Attributes attrs = sr.getAttributes();
                NamingEnumeration<? extends Attribute> enumAttrs = attrs.getAll();
                while (enumAttrs.hasMore()) {
                	Attribute att = enumAttrs.next();
                	NamingEnumeration<?> all = att.getAll();
                	while (all.hasMore()) {
                		Object value = all.next();
                		LOG.info("[Attribute] " + att.getID() + ": " + value);
                	}
                }
            }
            
            dc.close();
        	
        } catch (NamingException e) {
        	LOG.error("Erro de pesquisa LDAP", e);
        }
	}
}
