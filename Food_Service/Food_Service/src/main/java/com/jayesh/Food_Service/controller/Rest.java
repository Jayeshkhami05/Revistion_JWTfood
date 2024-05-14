package com.jayesh.Food_Service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.Food_Service.enetity.Food;
import com.jayesh.Food_Service.repositry.Repo;

@RestController
@RequestMapping("/Food")
public class Rest {

	@Autowired
	private Repo repo;
	
	@PostMapping("/save")
	public Food savefood(@RequestBody Food food) {
		return repo.save(food);
	}
	
	@GetMapping("/all")
	public List<Food> getallfood(){
		return repo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Food getbyid(@PathVariable int id) {
		Optional<Food> optional=repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}return null;
	}
	
	@GetMapping("/findByHotel/{id}")
	public List<Food> getByHotel(@PathVariable int id){
		return repo.findByhotelid(id);
	}
}


