package org.sistema.hibernate.xml;


import java.util.List;

import org.sistema.hibernate.xml.DAO.GenericDAOInterface;
import org.sistema.hibernate.xml.DAO.ProductDAOInterface;
import org.sistema.hibernate.xml.DAOimpl.GenericDAO;
import org.sistema.hibernate.xml.DAOimpl.ProductDAO;
import org.sistema.hibernate.xml.models.Product;
import org.sistema.hibernate.xml.models.ProductType;

/**
 * Main class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Main  {
	/**
	 * main function
	 * @param args
	 */
    public static void main( String[] args )
    {
 
    	GenericDAOInterface<Product> productDAO = new GenericDAO<Product>();
    	GenericDAOInterface<ProductType> productTypeDAO = new GenericDAO<ProductType>();
    	
        // INSERT NEW DATA
    	ProductType productType1 = new ProductType("Luxurious");
		ProductType productType2 = new ProductType("Gadgets");

		Product product1 = new Product("Angulas","Angulas de Aginaga",productType1);
		Product product2 = new Product("Caviar","Nacarii",productType1);


		Product product3 = new Product("Sony Vaio","PC Intel Core i5",productType2);
		Product product4 = new Product("Huawei","Smartphone ascend p10",productType2);
		
		productType1.addProduct(product1);
		productType1.addProduct(product2);
		
		productType2.addProduct(product3);
		productType2.addProduct(product4);
		
		
    	//Inserto los dos primeros productos
    	productTypeDAO.saveOrUpdate(productType1);
    	productTypeDAO.saveOrUpdate(productType2);
    	
    	
    	System.out.println("Inserted tipo id: " + productType1.getId());
    	System.out.println("Inserted tipo id: " + productType2.getId());
 	
    	ProductDAOInterface proDAO = new ProductDAO();
    	
    	List<Product> lista = proDAO.selectSameName("Angulas");
    	if (lista.size() > 0){
	    	for (Product proc: lista) {
	    		System.out.println("Id " + proc.getId() + " | Nombre: " + proc.getName() + " | Descripcion: " + proc.getDescription() );
	    	}
    	} else {
    		System.out.println("No data");
    	}
    	
    	System.out.println();
    			
    	lista = proDAO.selectEmptyDesc();
    	if (lista.size() > 0){
	    	for (Product proc: proDAO.selectEmptyDesc()) {
	    		System.out.println("Id " + proc.getId() + " | Nombre: " + proc.getName() + " | Descripcion: " + proc.getDescription() );	
	    	}
    	} else {
    		System.out.println("No data");
    	}
    		
    	System.out.println();
		
    	lista = proDAO.selectSameTypeNum(2l);
    	if (lista.size() > 0){
	    	for (Product proc: lista) {
	    		System.out.println("Id " + proc.getId() + " | Nombre: " + proc.getName() + " | Descripcion: " + proc.getDescription() );
	    	}
    	} else {
    		System.out.println("No data");
    	}
    		
    	System.out.println();
    	lista = proDAO.selectSameTypeName("Luxurious");
    	
    	if (lista.size() > 0){
	    	for (Product proc: lista) {
	    		System.out.println("Id " + proc.getId() + " | Nombre: " + proc.getName() + " | Descripcion: " + proc.getDescription() );
	    	}
    	} else {
    		System.out.println("No data");
    	}
    }
}
