/**
 * 
 */
package com.SneakerBankEnd.service;

import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.model.Payment;

public interface IPaymentService {

	Boolean processPayment(Cart cart, Payment payment);

}