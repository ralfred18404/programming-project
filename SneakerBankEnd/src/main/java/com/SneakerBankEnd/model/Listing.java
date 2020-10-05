package com.SneakerBankEnd.model;

import java.util.ArrayList;
import java.util.List;


public class Listing {

    private List<Shoe> shoes;

    /**
	 * @param shoes
	 */
	public Listing() {
		this.shoes = new ArrayList<>();
	}

	/**
	 * @return the shoes
	 */
	public List<Shoe> getShoes() {
		return shoes;
	}

	/**
	 * @param shoes the shoes to set
	 */
	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}

	@Override
	public String toString() {
		return "Listing [shoes=" + shoes + "]";
	}

}