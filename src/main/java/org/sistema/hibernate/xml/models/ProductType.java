/**
 * 
 */
package org.sistema.hibernate.xml.models;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a ProductType
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class ProductType {
	private Long id;
	private String name;
	private Set<Product> products = new HashSet<Product>();
	
	/**
	 * default constructor
	 */
	public ProductType () {
		
	}

	/**
	 * @param name
	 */
	public ProductType(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	/**
	 * Añade un producto a la lista de productos
	 * @param product
	 */
	public void addProduct(Product product){
		this.products.add(product);
	}
	

	

}
