package com.SneakerBankEnd.repository;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Orders;



public interface IOrdersRepository {

	Optional<Orders> findById(String id);

	List<Orders> findAll();
	
	void create(Orders order);

}