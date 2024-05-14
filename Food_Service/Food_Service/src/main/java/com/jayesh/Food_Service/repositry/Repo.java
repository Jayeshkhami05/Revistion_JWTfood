package com.jayesh.Food_Service.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.Food_Service.enetity.Food;

@Repository
public interface Repo extends JpaRepository<Food, Integer>{

	

	List<Food> findByhotelid(int id);

}
