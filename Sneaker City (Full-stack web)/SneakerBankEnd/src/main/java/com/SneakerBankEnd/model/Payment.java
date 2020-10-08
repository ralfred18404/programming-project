package com.SneakerBankEnd.model;

import javax.validation.constraints.NotBlank;

//@Entity
public class Payment {

	//@Id
	private String id;

	@NotBlank(message="Empty first name  field")
	private String firstName;
	
	@NotBlank(message="Empty last name  field")
	private String lastName;
	
	@NotBlank(message="Empty email  field")
	private String email;
	
	@NotBlank(message="Empty address1  field")
	private String address1;
	
	@NotBlank(message="Empty address2  field")
	private String address2;
	
	@NotBlank(message="Empty country  field")
	private String country;
	
	@NotBlank(message="Empty Phone Number  field")
	private String phone;
	
	@NotBlank(message="Empty username  field")
	private String username;
	
	@NotBlank(message="Empty password  field")
	private String passkey;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

	public Payment(String id, String firstName, String lastName, String email, String address1, String address2,
			String country, String phone, String username, String passkey) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.country = country;
		this.phone = phone;
		this.username = username;
		this.passkey = passkey;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address1=" + address1 + ", address2=" + address2 + ", country=" + country + ", phone=" + phone
				+ ", username=" + username + ", passkey=" + passkey + "]";
	}

	
	

}