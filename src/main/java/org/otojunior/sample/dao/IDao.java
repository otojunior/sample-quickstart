package org.otojunior.sample.dao;

import java.io.Serializable;

/**
 * DAO Interface.
 * @author Oto Junior (otojunior@gmail.com)
 *
 */
public interface IDao extends Serializable {
	public String[] findUserByUid(String uid);
	public String[] findRolesByUid(String uid);
}
