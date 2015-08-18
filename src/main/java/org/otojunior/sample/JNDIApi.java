package org.otojunior.sample;

import java.util.Properties;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
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
public class JNDIApi {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(JNDIApi.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		Properties env = new Properties();
        env.put(DirContext.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(DirContext.PROVIDER_URL, "ldap://localhost:10389");
        
        try {
        	DirContext dc = new InitialDirContext(env);
        	
        	/* 
        	 * Above we mentioned the filter and base. Another important part of the search criteria 
        	 * is the scope. There are three scopes: base (this entry only), onelevel (the direct 
        	 * children of this entry), and subtree (this entry and all of its decendents in the tree). 
        	 * In JNDI, OBJECT_SCOPE indicates a base search.
        	 */
        	SearchControls sc = new SearchControls();
        	sc.setSearchScope(SearchControls.ONELEVEL_SCOPE);
        	
        	/*
        	 * Search by uid        	
        	 */
        	NamingEnumeration<?> ne = dc.search(
        		"ou=users,dc=acme,dc=com", 
        		"(&(uid=otojunior)(objectClass=person))", 
        		sc);
        	
        	while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                LOG.info("[Name] " + sr.getNameInNamespace());

                NamingEnumeration<? extends Attribute> attributes = sr.getAttributes().getAll();
                while (attributes.hasMore()) {
                	Attribute attribute = attributes.next();
					NamingEnumeration<?> values = attribute.getAll();
                	while (values.hasMore()) {
                		Object value = values.next();
                		LOG.info("[Attribute] " + attribute.getID() + ": " + value);
                	}
                }
            }
            
        	/*
        	 * Search roles (groups) by uid.
        	 */
        	sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        	ne = dc.search(
	    		"ou=groups,dc=acme,dc=com",
	    		"(&(objectClass=groupOfNames)(member=uid=otojunior*))", 
	    		sc);
        	
        	while (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                LOG.info("[Name] " + sr.getNameInNamespace());
                
                // Extracting role name.
                Attribute attribute = sr.getAttributes().get("cn");
                LOG.info(attribute.get().toString());
            }
        	
            dc.close();
        	
        } catch (NamingException e) {
        	LOG.error("Erro de pesquisa LDAP", e);
        }
	}
}
