package com.SneakerBankEnd.repository;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Model;



public interface IModelRepository {

	Optional<Model> findById(String id);

	Optional<Model> findByName(String name);

	List<Model> findAll(int limit);

}