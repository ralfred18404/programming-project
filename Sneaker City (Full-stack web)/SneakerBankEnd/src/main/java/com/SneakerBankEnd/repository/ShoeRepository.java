/**
 * 
 */
package com.SneakerBankEnd.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SneakerBankEnd.model.Shoe;


@Repository
public class ShoeRepository implements IShoeRepository {

	@Autowired
	private DatabaseMocker databaseMocker;

	@Override
	public Optional<Shoe> findById(String id) {
		return databaseMocker.getShoes().stream().filter(shoe -> shoe.getId().equals(id)).findAny();
	}

	@Override
	public List<Shoe> findN() {
		return databaseMocker.getShoes().stream()
				.sorted((x, y) -> y.getModel().getReleaseDate()
						.compareTo(x.getModel().getReleaseDate()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Shoe> findByModel(String id) {
		
		return databaseMocker.getShoes().stream().filter(shoe->shoe.getModel().getId().equals(id)).collect(Collectors.toList());
	}

	@Override
	public Shoe update(Shoe shoe) {
		Shoe sh = new Shoe();
		sh.setId(shoe.getId());
		sh.setModel(shoe.getModel());
		sh.setQuantity(shoe.getQuantity());
		sh.setSize(shoe.getSize());
		Shoe s = databaseMocker.getShoes().stream().filter(i->i.getId().equals(shoe.getId())).findAny().get();
		s= sh;
		return s;
	}

}