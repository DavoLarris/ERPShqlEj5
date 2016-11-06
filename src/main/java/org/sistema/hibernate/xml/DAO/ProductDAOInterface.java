package org.sistema.hibernate.xml.DAO;

import java.util.List;

import org.sistema.hibernate.xml.models.Product;
import org.sistema.hibernate.xml.models.ProductType;

public interface ProductDAOInterface {

	public List<Product> selectSameName (String name);
	public List<Product> selectEmptyDesc ();
	public List<Product> selectSameTypeNum (Long id);
	public List<Product> selectSameTypeName (String name);

	
}
