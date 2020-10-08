package com.SneakerBankEnd.repository;

import java.util.List;

import com.SneakerBankEnd.model.Payment;

public interface IPaymentRepository {

	List<Payment>paymentList();
	void addToPayementList(Payment payment);
}
