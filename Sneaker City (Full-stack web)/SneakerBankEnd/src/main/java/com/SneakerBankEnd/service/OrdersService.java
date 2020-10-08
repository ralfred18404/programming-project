/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.repository.IOrdersRepository;


@Service
public class OrdersService implements IOrdersService {

	@Autowired
	private IOrdersRepository ordersRepository;

	@Override
	public Optional<Orders> getById(String id) {
		return ordersRepository.findById(id);
	}

	@Override
	public List<Orders> getAll() {
		return ordersRepository.findAll();
	}

}