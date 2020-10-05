package com.SneakerBankEnd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity

public class Shoe {

	//@Id
	private String id;

	

	private Short size;

	private Integer quantity;

//	@ManyToOne
//	@JoinColumn(name = "model")
	private Model model;

	/**
	 * @param price
	 * @param size
	 * @param quantity
	 * @param model
	 */
	public Shoe( Short size, Integer quantity, Model model) {
		
		this.size = size;
		this.quantity = quantity;
		this.model = model;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	

	/**
	 * @return the size
	 */
	public Short getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Short size) {
		this.size = size;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Shoe [id=" + id + ", size=" + size + ", quantity=" + quantity + ", model=" + model + "]";
	}

	public Shoe(String id, Short size, Integer quantity, Model model) {
		super();
		this.id = id;
		this.size = size;
		this.quantity = quantity;
		this.model = model;
	}

	public Shoe() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}