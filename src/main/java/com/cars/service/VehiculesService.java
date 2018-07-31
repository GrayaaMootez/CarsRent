package com.cars.service;

import java.util.List;

import com.cars.model.Vehicles;

public interface VehiculesService {

	List<Vehicles> findAll();

	Vehicles ajout(Vehicles vh);

	void modifier(Vehicles vh);

	void supp(Vehicles vh);

	void suppById(Long id);

	Vehicles findById(Long id);

	List<Long> vehiculesAvaible();

}
