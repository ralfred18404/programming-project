package com.SneakerBankEnd.repository;

import java.util.List;

import com.SneakerBankEnd.model.Cart;

public interface ICartRepository {

	List<Cart>cartList();
	void addToCart(Cart cart);
	void removeCart(Cart cart);
	void updateCart(Cart cart);
}
