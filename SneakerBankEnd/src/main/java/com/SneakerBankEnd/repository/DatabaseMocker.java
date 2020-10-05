package com.SneakerBankEnd.repository;



import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Brand;
import com.SneakerBankEnd.model.Model;
import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.model.Shoe;


@Repository
public class DatabaseMocker {

	private List<Shoe> shoes;
	private List<Orders> orders;
	private List<Model>shoeModels;

	public DatabaseMocker() {
		initializeShoes();
		orders = new ArrayList<>();
	}

	public List<Shoe> getShoes() {
		return shoes;
	}

	
	public List<Orders> getOrders() {
		return orders;
	}
	

	public void initializeShoes() {
		shoes = new ArrayList<>();
		shoeModels = new ArrayList<>();
		Brand brand = new Brand("Nike");
		
		String []image = {"first1.JPG","first2.JPG","first1.JPG"};
		Model model = new Model("AirForce", LocalDate.of(2015, Month.OCTOBER, 10), image,40.0, brand);
		model.setId("1");
		shoeModels.add(model);
		Shoe shoe = new Shoe((short)33, 80, model);
		shoe.setId("1");
		shoes.add(shoe);
		shoe = new Shoe((short)15, 100, model);
		shoe.setId("2");
		shoes.add(shoe);
		shoe = new Shoe((short)13, 50, model);
		shoe.setId("3");
		shoes.add(shoe);
		
		String []image1 = {"second1.JPG","second2.JPG","second3.JPG"};
		model = new Model("AirMax", LocalDate.of(2021, Month.JUNE, 20), image1,20.0, brand);
		model.setId("2");
		shoeModels.add(model);
		shoe = new Shoe((short)15, 100, model);
		shoe.setId("4");
		shoes.add(shoe);
		shoe = new Shoe((short)30, 90, model);
		shoe.setId("5");
		shoes.add(shoe);
		
		String []image2 = {"third1.JPG","third2.JPG","third3.JPG"};
		model = new Model("Air", LocalDate.of(2009, Month.JANUARY, 12), image2,60.0, brand);
		model.setId("3");
		shoeModels.add(model);
		shoe = new Shoe((short)20, 60, model);
		shoe.setId("6");
		shoes.add(shoe);
		shoe = new Shoe((short)15, 100, model);
		shoe.setId("7");
		shoes.add(shoe);
		shoe = new Shoe((short)15, 100, model);
		shoe.setId("8");
		shoes.add(shoe);
	}

	public List<Model> getShoeModels() {
		return shoeModels;
	}

	public void setShoeModels(List<Model> shoeModels) {
		this.shoeModels = shoeModels;
	}

	public void setShoes(List<Shoe> shoes) {
		this.shoes = shoes;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}