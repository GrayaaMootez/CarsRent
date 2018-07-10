package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.model.Custumer;
import com.cars.repository.CustumerRepository;

@Service
public class CustumerServiceImpl implements CustumerService {

	@Autowired
	private CustumerRepository repository;

	@Override
	public List<Custumer> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Custumer br) {
		repository.saveAndFlush(br);

	}

	@Override
	public void modifier(Custumer br) {
		repository.saveAndFlush(br);

	}

	@Override
	public void supp(Custumer br) {
		repository.delete(br);

	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public Custumer findById(Long id) {
		return repository.findOne(id);
	}
}
