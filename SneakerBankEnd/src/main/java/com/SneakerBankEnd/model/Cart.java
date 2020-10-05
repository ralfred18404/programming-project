/**
 * 
 */
package com.SneakerBankEnd.model;



//@Entity
public class Cart {


		//@Id
		private String id;

		//@OneToOne
		private Shoe shoe;
 
		private Integer quantity;
		
		
		private Payment payment;
		

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
		 * @return the shoe
		 */
		public Shoe getShoe() {
			return shoe;
		}

		/**
		 * @param shoe the shoe to set
		 */
		public void setShoe(Shoe shoe) {
			this.shoe = shoe;
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

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public Cart(String id, Shoe shoe, Integer quantity) {
			super();
			this.id = id;
			this.shoe = shoe;
			this.quantity = quantity;
		}

		public Cart() {
			super();
			// TODO Auto-generated constructor stub
		}

	

}