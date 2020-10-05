/**
 * 
 */
package com.SneakerBankEnd.resouces;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SneakerBankEnd.Response.MessageResponse;
import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.model.Orders;
import com.SneakerBankEnd.model.Payment;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.service.IShoeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "bk/")
public class Checkout {

	
	
	@Autowired
	private IShoeService shoeService;
	
	private List<Cart>cartList;
	private List<Cart>cartList2;
	private List<Payment>paymentList;
	private List<Orders>ordersList;
	private List<Cart>cartByPayment;
	
	public Checkout() {
		this.cartByPayment = new ArrayList<>();
		cartList = new ArrayList<Cart>();
		cartList2 =new ArrayList<Cart>();
		paymentList = new ArrayList<>();
		ordersList = new ArrayList<>();
	}

	@ApiOperation("add product to cart")
	@SuppressWarnings("rawtypes")
	@PostMapping(value="addToCart")
	public ResponseEntity addToCart(@RequestBody HashMap<String, Object> map) {
		Cart cart = new Cart();
		//ObjectMapper mapper = new ObjectMapper();
		Integer qty =(Integer) map.get("quantity");
		System.out.println("Quantity: "+qty);
		String shoeId = (String)map.get("shoe");
		Shoe shoe = shoeService.getById(shoeId).get();
		System.out.println(""+shoe.getModel().getName());
		cart.setQuantity(qty);
	    cart.setShoe(shoe);
		this.cartList.add(cart);
		return ResponseEntity.ok(new MessageResponse("well successfull added"));
	}
	@ApiOperation("display product on shopping cart")
	@GetMapping(value="shoppingCart")
	public List<Cart>shoppingCart(){
		return this.cartList;
	}
	@ApiOperation("Make payment of product from cart")
	@SuppressWarnings("rawtypes")
	@PostMapping(value="payment")
	public ResponseEntity makePayment(@RequestBody HashMap<String, Object>map) {
		Cart car = new Cart();
		Orders order = new Orders();
		order.setId(UUID.randomUUID().toString());
		ObjectMapper mapper = new ObjectMapper();
		Payment payment = mapper.convertValue(map.get("pay"), Payment.class);
		Integer totalAmount =(Integer) map.get("total");
		payment.setId(UUID.randomUUID().toString());
		for(Cart cart : this.cartList) {
			car = cart;
			car.setId(UUID.randomUUID().toString());
			car.setPayment(payment);
			this.cartList2.add(car);
		}
		this.paymentList.add(payment);
		order.setPayment(payment);
		order.setTotalAmount(Double.valueOf(totalAmount));
		this.ordersList.add(order);
		this.cartList = new ArrayList<Cart>();
		return ResponseEntity.ok(new MessageResponse("WELL successfull payed"));
		
	}
	
	@ApiOperation("Display Order after payment")
	@GetMapping(value="findOrders")
	public List<Orders>returnOrder(){
		return this.ordersList;
	}
	
	
	@GetMapping(value="orderByCart/{id}")
	public List<Cart> findOrderByCart(@PathVariable("id")String id){
		
	   return cartList2.stream().filter(i->i.getPayment().getId().equals(id)).collect(Collectors.toList());
	}
	
	
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public IShoeService getShoeService() {
		return shoeService;
	}

	public void setShoeService(IShoeService shoeService) {
		this.shoeService = shoeService;
	}

	public List<Cart> getCartList2() {
		return cartList2;
	}

	public void setCartList2(List<Cart> cartList2) {
		this.cartList2 = cartList2;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	public List<Cart> getCartByPayment() {
		return cartByPayment;
	}

	public void setCartByPayment(List<Cart> cartByPayment) {
		this.cartByPayment = cartByPayment;
	}
	

}