package com.SneakerBankEnd.model;

import java.time.LocalDate;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;



//@Entity
public class Model {

	//@Id
    private String id;

	private String name;


	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate releaseDate;

	private String[] picturePaths;
	
	private Double price;

//	@ManyToOne
//	@JoinColumn(name = "brand")
	
    private Brand brand;

	
	public Model() {
	
	}

	public Model(String name, LocalDate releaseDate, String[] picturePaths, Double price, Brand brand) {
	super();
	this.name = name;
	this.releaseDate = releaseDate;
	this.picturePaths = picturePaths;
	this.price = price;
	this.brand = brand;
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
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the picturePaths
	 */
	public String[] getPicturePaths() {
		return picturePaths;
	}

	/**
	 * @param picturePaths the picturePaths to set
	 */
	public void setPicturePaths(String[] picturePaths) {
		this.picturePaths = picturePaths;
	}

	/**
	 * @return the brand
	 */
	public Brand getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", releaseDate=" + releaseDate + ", picturePaths="
				+ Arrays.toString(picturePaths) + ", price=" + price + ", brand=" + brand + "]";
	}

	

}