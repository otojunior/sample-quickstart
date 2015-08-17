package org.otojunior.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
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
public class SearchLdapUidPass {
	/**
	 * SLF4J Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SearchLdapUidPass.class);
	
	/**
	 * Application main method.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		String base = "";
		String filter = "(uid=otojunior)";
		
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

                Attributes attrs = sr.getAttributes();
                Attribute attPasswd = attrs.get("userPassword");
                String attValue = new String((byte[])attPasswd.get());
                LOG.info("Value: " + attValue);
                
                LOG.info("Passwords Match? " + attValue.equals(md5AndBase64("teste123")));
            }
            
            dc.close();
        	
        } catch (NamingException e) {
        	LOG.error("Erro de pesquisa LDAP", e);
        } 
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	private static String md5AndBase64(String input) {
		try {
			MessageDigest digester = MessageDigest.getInstance("MD5");
			Encoder encoder = Base64.getEncoder();
			byte[] md5 = digester.digest(input.getBytes());
			String output = encoder.encodeToString(md5);
			return "{md5}"+output;
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Erro de digest", e);
			return null;
		}
	}
}
