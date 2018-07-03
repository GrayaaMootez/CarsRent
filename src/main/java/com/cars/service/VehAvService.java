package com.cars.service;

import java.util.List;

import com.cars.model.VehAv;

public interface VehAvService {


	List<VehAv> findAll();

	void ajout(VehAv vh);

	void modifier(VehAv vh);

	void supp(VehAv vh);

	void suppById(Long id);

	VehAv findById(Long id);
}
