package com.cars.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Vehicles;


@Repository
public interface VehiculesDao extends CrudRepository<Vehicles, Long>{

	@Override
	List<Vehicles> findAll();

}
