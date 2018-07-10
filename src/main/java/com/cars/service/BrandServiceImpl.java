package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.model.Brand;
import com.cars.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository repository;

	@Override
	public List<Brand> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Brand br) {
		repository.saveAndFlush(br);

	}

	@Override
	public void modifier(Brand br) {
		repository.saveAndFlush(br);

	}

	@Override
	public void supp(Brand br) {
		repository.delete(br);

	}

	@Override
	public void suppById(Double id) {
		repository.delete(id);

	}

	@Override
	public Brand findById(Double id) {
		return repository.findOne(id);
	}
}
