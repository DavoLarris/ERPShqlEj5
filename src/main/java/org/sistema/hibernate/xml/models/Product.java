/**
 * 
 */
package org.sistema.hibernate.xml.models;

/**
 * Represents a Product
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Product {
	private Long id;
	private String name;
	private String description;
	private ProductType productType;
	
	/**
	 * default constructor
	 */
	public Product () {
		
	}
	
	/**
	 * @param name
	 * @param description
	 * @param type
	 */
	public Product(String name, String description, ProductType productType) {
		this.name = name;
		this.description = description;
		this.productType = productType;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	} 
	
	
}
