package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cars.model.VehAv;
import com.cars.repository.VehAvRepository;

@Repository
public class VehAvServiceImpl implements VehAvService {

	@Autowired
	private VehAvRepository repository;

	@Override
	public List<VehAv> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(VehAv vh) {
		repository.saveAndFlush(vh);

	}

	@Override
	public void modifier(VehAv vh) {
		repository.saveAndFlush(vh);

	}

	@Override
	public void supp(VehAv vh) {
		repository.delete(vh);

	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public VehAv findById(Long id) {
		return repository.findOne(id);
	}

}
