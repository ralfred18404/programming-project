package com.SneakerBankEnd.service;

import java.util.List;

import com.SneakerBankEnd.model.Cart;

public interface ICartService {

	void saveToCart(Cart cart);
	List<Cart>cartList();
	void removeFromCart(Cart cart);
	void updateCart(Cart cart);
}
