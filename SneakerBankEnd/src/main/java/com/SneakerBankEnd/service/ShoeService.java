/**
 * 
 */
package com.SneakerBankEnd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SneakerBankEnd.model.Model;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.repository.IModelRepository;
import com.SneakerBankEnd.repository.IShoeRepository;


@Service
public class ShoeService implements IShoeService {

	@Autowired
	private IShoeRepository shoeRepository;
	
	@Autowired
	private IModelRepository modelRepository;

	@Override
	public Optional<Shoe> getById(String id) {
		return shoeRepository.findById(id);
	}

	@Override
	public List<Shoe> getN(int number) {
		return shoeRepository.findN(number);
	}

	@Override
	public List<Model> getAllShoe(int limit) {
		
		return modelRepository.findAll(limit);
	}

	@Override
	public List<Shoe> findByModelList(String modelId) {
		
		return shoeRepository.findByModel(modelId);
	}

	@Override
	public Optional<Model> findModelById(String id) {
		
		return modelRepository.findById(id);
	}

}