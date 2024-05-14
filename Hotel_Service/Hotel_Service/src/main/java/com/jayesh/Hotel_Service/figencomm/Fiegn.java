package com.jayesh.Hotel_Service.figencomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jayesh.Hotel_Service.entity.Food;

@FeignClient(name="FoodService")
public interface Fiegn {

	@GetMapping("/Food/all")
	public List<Food> getallfood();
	
	@GetMapping("/Food/findById/{id}")
	public Food getbyid(@PathVariable int id);
	
	@GetMapping("/Food/findByHotel/{id}")
	public List<Food> getByHotel(@PathVariable int id);
}
