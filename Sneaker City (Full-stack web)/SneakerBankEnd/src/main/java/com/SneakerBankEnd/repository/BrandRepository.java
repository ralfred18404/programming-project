/**
 * 
 */
package com.SneakerBankEnd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SneakerBankEnd.model.Brand;



public class BrandRepository implements IBrandRepository {

	private List<Brand> brands;

	public BrandRepository() {
		brands = new ArrayList<>();
	}

	@Override
	public Optional<Brand> findById(String id) {
		return brands.stream().findAny();
	}

	@Override
	public Optional<Brand> findByName(String id) {
		return brands.stream().filter(brand -> brand.getName().equals(id)).findAny();
	}

	@Override
	public List<Brand> findAll() {
		return brands;
	}

}