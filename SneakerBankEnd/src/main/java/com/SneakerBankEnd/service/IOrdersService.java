/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Orders;



public interface IOrdersService {

	Optional<Orders> getById(String id);

	List<Orders> getAll();

}