package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.Repository.InsuranceRepository;
import com.cars.model.Insurance;

@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceRepository repository;

	@Override
	public List<Insurance> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Insurance insurance) {
		repository.saveAndFlush(insurance);

	}

	@Override
	public void modifier(Insurance insurance) {
		repository.saveAndFlush(insurance);

	}

	@Override
	public void supp(Insurance insurance) {
		repository.delete(insurance);

	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public Insurance findById(Long id) {
		return repository.findOne(id);
	}

}

