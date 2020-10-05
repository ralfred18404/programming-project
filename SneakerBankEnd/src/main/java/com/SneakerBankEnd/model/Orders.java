/**
 * 
 */
package com.SneakerBankEnd.model;



//@Entity
public class Orders {

	//@Id
	private String id;

	private Double totalAmount;

	//@OneToOne
	private Payment payment;

	private Status status;

	/**
	 * @param cart
	 * @param payment
	 * @param status
	 */
	public Orders(Payment payment, Status status) {
		
		this.payment = payment;
		this.status = status;
	}

	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


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
	 * @return the cart
	

	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Status {

		PLACED, DELIVERED

	}

}