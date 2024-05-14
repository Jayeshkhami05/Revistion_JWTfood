package com.jayesh.Hotel_Service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh.Hotel_Service.entity.Food;
import com.jayesh.Hotel_Service.entity.Hotel;
import com.jayesh.Hotel_Service.figencomm.Fiegn;
import com.jayesh.Hotel_Service.repositry.Repo;


@RestController
@RequestMapping("/Hotel")
public class Rest {

	@Autowired
	private Repo repo;
	
	@Autowired
	private Fiegn fiegn;
	
	@PostMapping("/save")
	public Hotel savehotel(@RequestBody Hotel hotel)
	{
		return repo.save(hotel);
	}
	@GetMapping("/all")
	public List<Hotel> getAllHotel(){
		List<Hotel> listHotel=repo.findAll();
		return listHotel.stream().map(Hotel->{
			List<Food> listFood=fiegn.getByHotel(Hotel.getId());
			Hotel.setFoods(listFood);
			return Hotel;
		}).toList();
	}
	@GetMapping("/getByHotelid/{id}")
	public Hotel getByhotelId(@PathVariable int  id) {
		Optional<Hotel> optional=repo.findById(id);
		if(optional.isPresent()) {
			Hotel hotel=optional.get();
			List<Food> listfood=fiegn.getByHotel(id);
			hotel.setFoods(listfood);
			return hotel;
		}return null;
	}
}
