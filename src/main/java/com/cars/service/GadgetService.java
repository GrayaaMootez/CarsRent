package com.cars.service;

import java.util.List;

import com.cars.model.Gadget;

public interface GadgetService {

	List<Gadget> findAll();

	void ajout(Gadget gadget);

	void modifier(Gadget gadget);

	void supp(Gadget gadget);

	void suppById(Long id);

	Gadget findById(Long id);
}
