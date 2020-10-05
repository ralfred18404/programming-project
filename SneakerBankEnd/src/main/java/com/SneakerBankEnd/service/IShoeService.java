/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Model;
import com.SneakerBankEnd.model.Shoe;


public interface IShoeService {

	Optional<Shoe> getById(String id);

	List<Shoe> getN(int number);
	List<Model>getAllShoe(int limit);
	List<Shoe>findByModelList(String modelId);
	Optional<Model>findModelById(String id);

}