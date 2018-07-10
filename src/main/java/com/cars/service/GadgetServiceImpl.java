package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.model.Gadget;
import com.cars.repository.GadgetRepository;

@Service
public class GadgetServiceImpl implements GadgetService{

	@Autowired
	private GadgetRepository repository;


	@Override
	public List<Gadget> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Gadget gadget) {
		repository.saveAndFlush(gadget);

	}

	@Override
	public void modifier(Gadget gadget) {
		repository.saveAndFlush(gadget);

	}

	@Override
	public void supp(Gadget gadget) {
		repository.delete(gadget);

	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public Gadget findById(Long id) {
		return repository.findOne(id);
	}

}
