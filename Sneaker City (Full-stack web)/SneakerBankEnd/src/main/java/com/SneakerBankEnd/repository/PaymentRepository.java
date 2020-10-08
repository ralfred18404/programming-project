package com.SneakerBankEnd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Payment;

@Repository
public class PaymentRepository implements IPaymentRepository {
	
	@Autowired
	private DatabaseMocker mocker;

	@Override
	public List<Payment> paymentList() {
		
		return mocker.getPaymentList();
	}

	@Override
	public void addToPayementList(Payment payment) {
		mocker.saveToPayment(payment);
		
	}

}
