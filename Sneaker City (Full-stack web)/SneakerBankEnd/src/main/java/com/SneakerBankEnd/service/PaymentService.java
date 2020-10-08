/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.model.Payment;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.repository.IOrdersRepository;
import com.SneakerBankEnd.repository.IShoeRepository;
import com.SneakerBankEnd.repository.OrdersRepository;
import com.SneakerBankEnd.repository.PaymentRepository;



@Service
public class PaymentService implements IPaymentService {
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private OrdersRepository orderRepo;

	@Override
	public List<Payment> paymentList() {
		
		return this.paymentRepo.paymentList();
	}

	@Override
	public void addListToPayment(Payment payment) {
		this.paymentRepo.addToPayementList(payment);
	}

	@Override
	public void addOrderToList(Orders order) {
		orderRepo.create(order);
		
	}

	@Override
	public List<Orders> findAllOrders() {
		
		return orderRepo.findAll();
	}

	
}