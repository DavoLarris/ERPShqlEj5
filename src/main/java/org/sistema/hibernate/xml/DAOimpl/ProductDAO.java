package org.sistema.hibernate.xml.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.sistema.hibernate.xml.HibernateSession;
import org.sistema.hibernate.xml.DAO.ProductDAOInterface;
import org.sistema.hibernate.xml.models.Product;
import org.sistema.hibernate.xml.models.ProductType;

public class ProductDAO implements ProductDAOInterface{

	private Session session;

	/**
	 * starts transaction
	 */
	protected void startTransaction() {
		session = HibernateSession.getSession();
		session.getTransaction().begin();
	}

	/**
	 * ends transaction
	 */
	protected void endTransaction() {
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	/**
	 * returns Hibernate Session instance
	 * @return
	 */
	protected Session getSession() {
		return session;
	}
	
	/**
	 * handles exception, rolls back operations
	 * @param he
	 * @throws HibernateException
	 */
	protected void handleException(HibernateException he)
			throws HibernateException {
		System.out.println("Exception: " + he.getMessage());
		session.getTransaction().rollback();
		throw he;
	}
	
	
	
	public List<Product> selectSameName(String name) {
		List<Product> result = null;
		try {
			startTransaction();
			System.out.println("selectSameName ");
			Query query = getSession().createQuery(
					"FROM " + Product.class.getSimpleName() +
					" p WHERE p.name = :name");
					query.setParameter("name", name);
					
			result = (List<Product>) query.list();

		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
		return result;
		
	}

	public List<Product> selectEmptyDesc() {
		List<Product> result = null;
		
		try {
			startTransaction();
			System.out.println("selectEmptyDesc ");
			Query query = getSession().createQuery(
					"FROM " + Product.class.getSimpleName() +
					" p WHERE p.description = '' OR p.description = null");
			
			result = (List<Product>) query.list();

		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
		return result;
	}

	public List<Product> selectSameTypeNum(Long id) {
		List<Product> result = null;
		
		try {
			startTransaction();
			System.out.println("selectSameTypeNum ");
			Query query = getSession().createQuery(
					"SELECT p.id, p.name, p.description "
					+ "FROM " + Product.class.getSimpleName() +
					" p INNER JOIN p.productType pt "
					+ "WHERE pt.id = :id");
				query.setParameter("id", id);
			
			result = (List<Product>) query.list();

		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
		return result;
	}

	public List<Product> selectSameTypeName(String name) {
		List<Product> result = null;
		
		try {
			startTransaction();
			System.out.println("selectSameTypeName ");
			Query query = getSession().createQuery(
					"FROM " + Product.class.getSimpleName() +
					" p INNER JOIN p.productType pt "
					+ "WHERE pt.name = :name");
				query.setParameter("name", name);
			
			result = (List<Product>) query.list();

		} catch (HibernateException he) {
			handleException(he);
		} finally {
			endTransaction();
		}
		return result;
	}

}
