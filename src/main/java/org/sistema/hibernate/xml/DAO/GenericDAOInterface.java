package org.sistema.hibernate.xml.DAO;


import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;

/**
 * interface for GenericDAO
 */
public interface GenericDAOInterface<T> {
	
	public T find(Serializable id, Class<T> entityClass) throws HibernateException;
	public List<T> get (Class<T> entity) throws HibernateException;
	public void saveOrUpdate (T entity) throws HibernateException;
	public void delete (T entity) throws HibernateException;
	

}
