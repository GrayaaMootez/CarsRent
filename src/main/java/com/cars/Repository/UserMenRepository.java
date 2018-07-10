package com.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cars.model.UsrMen;

@Repository
public interface UserMenRepository extends JpaRepository<UsrMen, String> {


	@Query("from UsrMen a where a.util=:user")
	public UsrMen findUser(@Param("user") String user);



}
