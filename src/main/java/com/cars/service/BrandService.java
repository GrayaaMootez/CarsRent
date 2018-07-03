package com.cars.service;

import java.util.List;

import com.cars.model.Brand;

public interface BrandService {

	List<Brand> findAll();

	void ajout(Brand br);

	void modifier(Brand br);

	void supp(Brand br);

	void suppById(Double id);

	Brand findById(Double id);

}
