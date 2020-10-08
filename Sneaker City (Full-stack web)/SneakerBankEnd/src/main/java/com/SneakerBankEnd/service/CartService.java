package com.SneakerBankEnd.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.repository.ICartRepository;

@Service
public class CartService implements ICartService {
	
	@Autowired
	private ICartRepository cartRepo;

	@Override
	public void saveToCart(Cart cart) {
		cartRepo.addToCart(cart);
		
	}

	@Override
	public List<Cart> cartList() {
		return cartRepo.cartList().stream().sorted((x,y)->y.getShoe().getModel().getReleaseDate().compareTo(x.getShoe().getModel().getReleaseDate()))
				.collect(Collectors.toList());
	}

	@Override
	public void removeFromCart(Cart cart) {
		cartRepo.removeCart(cart);
		
	}

	@Override
	public void updateCart(Cart cart) {
	cartRepo.updateCart(cart);	
	}

}
