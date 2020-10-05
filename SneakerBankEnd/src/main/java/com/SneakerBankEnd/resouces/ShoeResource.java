package com.SneakerBankEnd.resouces;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SneakerBankEnd.model.Model;
import com.SneakerBankEnd.model.Shoe;
import com.SneakerBankEnd.service.IShoeService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "bk/")
public class ShoeResource {

	@Autowired
	private IShoeService shoeService;
	
	

	public ShoeResource() {
		
	}
	
	@ApiOperation("Return list of shoes")
	@GetMapping("returnShoes/{limit}")
	public List<Model> returnShoesByLimit(@PathVariable("limit") int limit) throws NoSuchMethodException,
	InstantiationException, IllegalAccessException, InvocationTargetException {
		List<Model> shoes = shoeService.getAllShoe(limit);
		return shoes;
	}
	
	
	@ApiOperation("display shoe size and quantity per each size")
	@GetMapping("getShoesDetails/{id}")
	public List<Shoe>findShoeSize(@PathVariable("id")String id){
		return shoeService.findByModelList(id);
	}
	
	@ApiOperation("return shoe details by parsing an id")
	@GetMapping("getModelId/{id}")
	public Model findShoeId(@PathVariable("id")String id) {
		Model model = shoeService.findModelById(id).get();
		return model;
	}
	
	
	
	
	
	

}