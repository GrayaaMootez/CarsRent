package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.Repository.VehiculesRepository;
import com.cars.model.Vehicles;

@Service
public class VehiculesServiceImpl implements VehiculesService {

	@Autowired
	private VehiculesRepository repository;

	@Override
	public List<Vehicles> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Vehicles vh) {
		repository.save(vh);
	}

	@Override
	public void modifier(Vehicles vh) {
		repository.save(vh);
	}

	@Override
	public void supp(Vehicles vh) {
		repository.delete(vh);
	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public Vehicles findById(Long id) {
		return repository.findOne(id);
	}

}
