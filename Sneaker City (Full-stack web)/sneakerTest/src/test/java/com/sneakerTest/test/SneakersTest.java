package com.sneakerTest.test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

class SneakersTest {

private final String CONTEXT ="/bk/";
	
	@BeforeEach
	void setUp() throws Exception{
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
	}
	
	
	@Test
	public void getShoeList() {
		Response res = given().pathParam("limit", 10).contentType("application/json").accept("application/json").when().get(CONTEXT+"returnShoes/{limit}")
				.then().statusCode(200).contentType("application/json").extract().response();
		String id =res.jsonPath().toString();
		assertNotNull(id);
	}
	@Test
	public void getShoeDetails() {
		Response res = given().pathParam("id", 2).contentType("application/json").accept("application/json").when().get(CONTEXT+"getShoesDetails/{id}")
				.then().statusCode(200).contentType("application/json").extract().response();
		String id =res.jsonPath().toString();
		assertNotNull(id);
	}
	@Test
	public void addToCart() {
		Map<String, Object>map = new HashMap<>();
		map.put("shoe", "3");
		
		 Response res = given().
					contentType("application/json").
					accept("application/json").
					body(map).when().
					post(CONTEXT+"addToCart").
					then().statusCode(200).
					contentType("application/json").extract().response();
			 String id = res.jsonPath().toString();
			 assertNotNull(id);
	}
	@Test
	public void shoppingCartList() {
		Response res = given().contentType("application/json").accept("application/json").when().get(CONTEXT+"shoppingCart")
				.then().statusCode(200).contentType("application/json").extract().response();
		String id =res.jsonPath().toString();
		assertNotNull(id);
	}
	

}
