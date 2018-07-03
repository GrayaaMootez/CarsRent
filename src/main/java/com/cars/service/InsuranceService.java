package com.cars.service;

import java.util.List;

import com.cars.model.Insurance;

public interface InsuranceService {

	List<Insurance> findAll();

	void ajout(Insurance ins);

	void modifier(Insurance ins);

	void supp(Insurance ins);

	void suppById(Long id);

	Insurance findById(Long id);

}
