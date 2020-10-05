/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.model.Payment;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.repository.IOrdersRepository;
import com.SneakerBankEnd.repository.IShoeRepository;



@Service
public class PaymentService implements IPaymentService {

	@Autowired
	private IShoeRepository shoeRepository;

	@Autowired
	private IOrdersRepository ordersRepository;

	public Boolean processPayment(Cart cart, Payment payment) {
//		if (validatePaymentInformation(payment)) {
//			if (((int)(new Random().nextDouble() * 4) == 0 ? false: true)) {
//				cart.getEntries().parallelStream().forEach(entry -> {
//					Shoe shoe = shoeRepository.findById(entry.getShoe().getId()).get();
//					shoe.setQuantity(shoe.getQuantity() - entry.getQuantity());
//				});
//				Orders order = new Orders(cart, payment, Orders.Status.PLACED);
//				ordersRepository.findAll().add(order);
//				
//				return true;
//			}
//		}
		return false;
	}

	private Boolean validatePaymentInformation(Payment payment) {
//		if (payment == null)
//			return false;
//		if (payment.getFirstName() == null || payment.getFirstName().isEmpty())
//			return false;
//		if (payment.getLastName() == null || payment.getLastName().isEmpty())
//			return false;
//		if (payment.getMethod() == null)
//			return false;
//		if (payment.getAccountNumber() == null || payment.getAccountNumber().isEmpty())
//			return false;
//		if (payment.getPasskey() == null || payment.getPasskey().isEmpty())
//			return false;

		return true;
	}

}