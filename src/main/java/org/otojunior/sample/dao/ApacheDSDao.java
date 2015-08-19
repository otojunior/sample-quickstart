/**
 * 
 */
package org.otojunior.sample.dao;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oto Junior (otojunior@gmail.com)
 *
 */
public class ApacheDSDao implements IDao {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(ApacheDSDao.class);

	/**
	 * @return
	 * @throws IOException
	 */
	private Properties loadProperties() throws IOException {
		Properties env = new Properties();
		env.load(getClass().getClassLoader().getResourceAsStream("environment.properties"));
		return env;
	}
	
	public static void main(String[] args) {
		new ApacheDSDao().findRolesByUid("otojunior");
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] findUserByUid(String uid) {
		String[] result = null;
		try {
			Properties env = loadProperties();
			
			LdapConnection connection = new LdapNetworkConnection("localhost", 10389);
			connection.bind();
			
			String dn = env.getProperty("users.dn");
        	String filter = String.format("(&(uid=%s)(objectClass=person))", uid);
        	
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("dn: " + dn);
        		LOG.debug("filter: " + filter);
        	}
			
			EntryCursor cursor = connection.search(dn, filter, SearchScope.ONELEVEL, "*");
			if (cursor.next()) {
			    Entry entry = cursor.get();
			    
			    Value<?> valueUid = entry.get("uid").get();
			    Value<?> valuePassword = entry.get("userPassword").get();
			    
			    result = new String[2];
			    result[0] = valueUid.getString();
			    result[1] = new String(valuePassword.getBytes());
			    
			    if (LOG.isDebugEnabled()) {
			    	LOG.debug("uid: " + result[0]);
			    	LOG.debug("userPassword: " + result[1]);
			    }
			}
			connection.unBind();
			connection.close();
		} catch (LdapException e) {
			LOG.error("LDAP error", e);
		} catch (IOException e) {
			LOG.error("I/O error", e);
		} catch (CursorException e) {
			LOG.error("Cursor error", e);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] findRolesByUid(String uid) {
		String[] result = null;
		try {
			Properties env = loadProperties();
			
			LdapConnection connection = new LdapNetworkConnection("localhost", 10389);
			connection.bind();
			
			String dn = env.getProperty("roles.dn");
        	String filter = String.format("(&(member=uid=%s*)(objectClass=groupOfNames))", uid);
        	
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("dn: " + dn);
        		LOG.debug("filter: " + filter);
        	}
			
			Set<String> roles = new TreeSet<>();
        	EntryCursor cursor = connection.search(dn, filter, SearchScope.SUBTREE, "*");
			while (cursor.next()) {
			    Entry entry = cursor.get();
			    Value<?> valueCn = entry.get("cn").get();
			    
			    if (LOG.isDebugEnabled()) {
			    	LOG.debug("valueCn: " + valueCn.getString());
			    }
			    
			    roles.add(valueCn.getString());
			    result = roles.toArray(new String[0]);
			}
			connection.unBind();
			connection.close();
		} catch (LdapException e) {
			LOG.error("LDAP error", e);
		} catch (IOException e) {
			LOG.error("I/O error", e);
		} catch (CursorException e) {
			LOG.error("Cursor error", e);
		}
		return result;
	}

}
