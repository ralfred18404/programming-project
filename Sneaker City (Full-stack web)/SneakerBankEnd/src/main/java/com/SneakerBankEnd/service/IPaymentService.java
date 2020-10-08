/**
 * 
 */
package com.SneakerBankEnd.service;


import java.util.List;

import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.model.Payment;

public interface IPaymentService {

	List<Payment>paymentList();
	void addListToPayment(Payment payment);
	void addOrderToList(Orders order);
	List<Orders>findAllOrders();

}