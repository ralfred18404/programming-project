/**
 * 
 */
package com.SneakerBankEnd.resouces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.SneakerBankEnd.service.ICartService;
import com.SneakerBankEnd.service.IPaymentService;
import com.SneakerBankEnd.service.IShoeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "bk/")
public class Checkout {

	@Autowired
	private IShoeService shoeService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IPaymentService paymentService;

	private List<Orders> ordersList;

	public Checkout() {

		ordersList = new ArrayList<>();
	}


	@ApiOperation("Make payment of product from cart")
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "payment")
	public ResponseEntity makePayment(@RequestBody HashMap<String, Object> map) {
		if (this.cartService.cartList().stream().filter(i -> i.getStatus().equals("Pending"))
				.collect(Collectors.toList()).isEmpty() == false) {
			Cart car = new Cart();
			Orders order = new Orders();
			order.setId(UUID.randomUUID().toString());
			ObjectMapper mapper = new ObjectMapper();
			Payment payment = mapper.convertValue(map.get("pay"), Payment.class);
			Double totalAmount = 0.0;
			payment.setId(UUID.randomUUID().toString());
			for (Cart cart : this.cartService.cartList().stream().filter(i -> i.getStatus().equalsIgnoreCase("Pending"))
					.collect(Collectors.toList())) {
				car = cart;
				totalAmount = totalAmount + (cart.getQuantity() * cart.getShoe().getModel().getPrice());
				car.setPayment(payment);
				car.setStatus("Payed");
				this.cartService.updateCart(car);
				Shoe sh = this.shoeService.getById(cart.getShoe().getId()).get();
				this.shoeService.getN().stream().filter(i -> i.getId().equals(sh.getId())).forEach(b -> {
					b.setQuantity(b.getQuantity() - cart.getQuantity());
					this.shoeService.updateShoe(b);

				});
			}
			this.paymentService.addListToPayment(payment);
			order.setPayment(payment);
			order.setTotalAmount(Double.valueOf(totalAmount));
			this.paymentService.addOrderToList(order);

			return ResponseEntity.ok(new MessageResponse("WELL successfull payed"));
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("The cart is empty"));
		}

	}

	@ApiOperation("Display Order after payment")
	@GetMapping(value = "findOrders")
	public List<Orders> returnOrder() {
		return this.paymentService.findAllOrders();
	}

	@GetMapping(value = "orderByCart/{id}")
	public List<Cart> findOrderByCart(@PathVariable("id") String id) {

		return cartService.cartList().stream()
				.filter(i -> i.getStatus().equals("Payed") && i.getPayment().getId().equals(id))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value = "cartList")
	public List<Cart> findUpdateCart() {
		return cartService.cartList().stream().filter(i -> i.getStatus().equals("Payed")).collect(Collectors.toList());
	}

	public IShoeService getShoeService() {
		return shoeService;
	}

	public void setShoeService(IShoeService shoeService) {
		this.shoeService = shoeService;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

}