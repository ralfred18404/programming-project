package com.SneakerBankEnd.resouces;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SneakerBankEnd.Response.MessageResponse;
import com.SneakerBankEnd.model.Cart;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.service.ICartService;
import com.SneakerBankEnd.service.IShoeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "bk/")
public class CartResouce {

	@Autowired
	private ICartService cartService;

	@Autowired
	private IShoeService shoeService;

	@ApiOperation("add product to cart")
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "addToCart")
	public ResponseEntity addToCart(@RequestBody HashMap<String, Object> map) {
		Cart cart = new Cart();
		// ObjectMapper mapper = new ObjectMapper();
		Integer qty = (Integer) map.get("quantity");
		System.out.println("Quantity: " + qty);
		String shoeId = (String) map.get("shoe");
		Shoe shoe = shoeService.getById(shoeId).get();
		System.out.println("" + shoe.getModel().getName());
		cart.setId(UUID.randomUUID().toString());
		cart.setStatus("Pending");
		cart.setQuantity(qty);
		cart.setShoe(shoe);
		this.cartService.saveToCart(cart);
		return ResponseEntity.ok(new MessageResponse("well successfull added"));
	}

	@ApiOperation("display product on shopping cart")
	@GetMapping(value = "shoppingCart")
	public List<Cart> shoppingCart() {
		return this.cartService.cartList().stream().filter(i->i.getStatus().equals("Pending")).collect(Collectors.toList());
	}

	@ApiOperation("Update quantity in cart items")
	@SuppressWarnings("rawtypes")
	@PutMapping(value = "updateCart")
	public ResponseEntity updateCart(@RequestBody Cart cart) {
		this.cartService.updateCart(cart);
		return ResponseEntity.ok(new MessageResponse("well updated"));
	}

	@ApiOperation("Delete product in cart")
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value = "remove/{id}")
	public ResponseEntity removeFromCart(@PathVariable("id") String id) {
		if (this.cartService.cartList().isEmpty()) {
			return ResponseEntity.badRequest().body(new MessageResponse("cart is empty"));

		} else {
			Cart cart = this.cartService.cartList().stream().filter(i -> i.getId().equals(id)).findAny()
					.orElseThrow(() -> new RuntimeException("id not found on cart"));

			this.cartService.removeFromCart(cart);
			return ResponseEntity.ok(new MessageResponse("well removed"));
		}
	}

}
