package org.otojunior.sample.dao;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

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
 * JNDI Dao implemented.
 * @author Oto Junior (otojunior@gmail.com)
 */
public class JNDIDao implements IDao {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(JNDIDao.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] findRolesByUid(String uid) {
		try {
			Properties env = loadProperties();
			DirContext dc = new InitialDirContext(env);
			
			SearchControls sc = new SearchControls();
        	sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
			
        	String dn = env.getProperty("roles.dn");
        	String filter = String.format("(&(member=uid=%s*)(objectClass=groupOfNames))", uid);
        	
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("dn: " + dn);
        		LOG.debug("filter: " + filter);
        	}
        	
        	Set<String> roles = new TreeSet<String>();
        	NamingEnumeration<?> ne = dc.search(dn, filter, sc);
        	while (ne.hasMore()) {
        		SearchResult sr = (SearchResult) ne.next();
                Attribute attribute = sr.getAttributes().get("cn");
                String role = attribute.get().toString(); 
                if (LOG.isDebugEnabled())
                	LOG.debug("Role: " + role);
                roles.add(role);
        	}
        	return roles.toArray(new String[0]);
		} catch (IOException e) {
			LOG.error("I/O Error", e);
		} catch (NamingException e) {
			LOG.error("Naming Error", e);
		}
		return null;
	}

	/**
	 * @return
	 * @throws IOException
	 */
	private Properties loadProperties() throws IOException {
		Properties env = new Properties();
		env.load(getClass().getClassLoader().getResourceAsStream("environment.properties"));
		return env;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] findUserByUid(String uid) {
		try {
			Properties env = loadProperties();
			DirContext dc = new InitialDirContext(env);
        	
        	/* 
        	 * Above we mentioned the filter and base. Another important part of the search criteria 
        	 * is the scope. There are three scopes: base (this entry only), onelevel (the direct 
        	 * children of this entry), and subtree (this entry and all of its decendents in the tree). 
        	 * In JNDI, OBJECT_SCOPE indicates a base search.
        	 */
        	SearchControls sc = new SearchControls();
        	sc.setSearchScope(SearchControls.ONELEVEL_SCOPE);
        	
        	String dn = env.getProperty("users.dn");
        	String filter = String.format("(&(uid=%s)(objectClass=person))", uid);
        	
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("dn: " + dn);
        		LOG.debug("filter: " + filter);
        	}
        	
        	String[] result = new String[2];
        	NamingEnumeration<?> ne = dc.search(dn, filter, sc);
        	if (ne.hasMore()) {
                SearchResult sr = (SearchResult) ne.next();
                result[0] = getValue(sr.getAttributes(), "uid");
                result[1] = getValue(sr.getAttributes(), "userPassword");
            }
        	
        	return result;
        	
		} catch (IOException e) {
			LOG.error("I/O Error", e);
		} catch (NamingException e) {
			LOG.error("Naming Error", e);
		}
		return null;
	}
	
	/**
	 * Get the value of an attribute.
	 * @param attributes List of attributes.
	 * @param attributeId attribute ID.
	 * @return Value of an attribute.
	 */
	private String getValue(Attributes attributes, String attributeId) {
		String value = null;
		try {
			Attribute att = attributes.get(attributeId);
			if (att != null) {
				Object rawvalue = att.get();
				
				// Handles uid (String) or password (byte[])
				value = String.class.equals(rawvalue.getClass()) ?
					rawvalue.toString() :
					new String((byte[])rawvalue);
				
				if (LOG.isDebugEnabled()) 
					LOG.debug(attributeId + ": " + value);
			}
		} catch (NamingException e) {
			LOG.error("Naming error", e);
		}
		return value;
	}
}
