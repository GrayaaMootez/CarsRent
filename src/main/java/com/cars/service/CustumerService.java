package com.cars.service;

import java.util.List;

import com.cars.model.Custumer;

public interface CustumerService {

	List<Custumer> findAll();

	void ajout(Custumer cu);

	void modifier(Custumer cu);

	void supp(Custumer cu);

	void suppById(Long id);

	Custumer findById(Long id);
}
