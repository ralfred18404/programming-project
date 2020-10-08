package com.SneakerBankEnd.repository;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Model;
import com.SneakerBankEnd.model.Shoe;



public interface IShoeRepository {

	Optional<Shoe> findById(String id);

	List<Shoe> findN();
	List<Shoe>findByModel(String id);
	Shoe update(Shoe shoe);
}