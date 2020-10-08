/**
 * 
 */
package com.SneakerBankEnd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Model;



@Repository
public class ModelRepository implements IModelRepository {

	private List<Model> models;
	
	@Autowired
	private DatabaseMocker databaseMocker;

	public ModelRepository() {
		models = new ArrayList<>();
	}

	@Override
	public Optional<Model> findById(String id) {
		return databaseMocker.getShoeModels().stream().filter(shoe->shoe.getId().equals(id)).findAny();
	}

	@Override
	public Optional<Model> findByName(String id) {
		return models.stream().filter(model -> model.getName().equals(id)).findAny();
	}

	@Override
	public List<Model> findAll(int limit) {
		return databaseMocker.getShoeModels().stream()
				.limit(limit)
				.sorted((x, y) -> y.getReleaseDate()
						.compareTo(x.getReleaseDate()))
				.collect(Collectors.toList());
	}

}