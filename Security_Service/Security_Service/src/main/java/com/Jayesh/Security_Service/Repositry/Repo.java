package com.Jayesh.Security_Service.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jayesh.Security_Service.entity.MyUser;

@Repository
public interface Repo extends JpaRepository<MyUser, Integer> {


	Optional<MyUser> findByName(String username);

}
