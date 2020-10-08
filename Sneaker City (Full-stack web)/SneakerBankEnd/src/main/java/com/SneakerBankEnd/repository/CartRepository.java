package com.SneakerBankEnd.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Cart;

@Repository
public class CartRepository implements ICartRepository {
	
	
	
	@Autowired
	private DatabaseMocker mocker;

	@Override
	public List<Cart> cartList() {
		
		return this.mocker.getCartProduct();
	}

	@Override
	public void addToCart(Cart cart) {
		mocker.saveTocart(cart);
	}

	@Override
	public void removeCart(Cart cart) {
		mocker.getCartProduct().remove(cart);
		
	}

	@Override
	public void updateCart(Cart cart) {
		Cart car = this.mocker.getCartProduct().stream().filter(i->i.getId().equals(cart.getId())).findAny().get();
		this.mocker.getCartProduct().remove(car);
		car.setQuantity(cart.getQuantity());
		car.setPayment(cart.getPayment());
		car.setStatus(cart.getStatus());
		this.mocker.getCartProduct().add(car);
	}

}
