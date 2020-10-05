package com.SneakerBankEnd.repository;

import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Brand;



public interface IBrandRepository {

	Optional<Brand> findById(String id);

	Optional<Brand> findByName(String name);

	List<Brand> findAll();

}