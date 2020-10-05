package com.SneakerBankEnd.repository;
/**
 * 
 */


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Orders;



@Repository
public class OrdersRepository implements IOrdersRepository {

	@Autowired
	private DatabaseMocker databaseMocker;

	@Override
	public Optional<Orders> findById(String id) {
		return databaseMocker.getOrders().stream().filter(order -> order.getId().equals(id)).findAny();
	}

	@Override
	public List<Orders> findAll() {
		return databaseMocker.getOrders();
	}

	public void create(Orders order) {
		databaseMocker.getOrders().add(order);
	}

}