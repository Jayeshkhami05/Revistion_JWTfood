package com.jayesh.Hotel_Service.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayesh.Hotel_Service.entity.Hotel;

@Repository
public interface Repo extends JpaRepository <Hotel, Integer> {

}
