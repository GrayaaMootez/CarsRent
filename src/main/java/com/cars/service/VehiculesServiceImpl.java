package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.VehiculesDao;
import com.cars.model.Vehicles;

@Service
public class VehiculesServiceImpl implements VehiculesService {

	@Autowired
	private VehiculesDao dao;

	@Override
	public List<Vehicles> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Vehicles vh) {
		dao.save(vh);
	}

	@Override
	public void modifier(Vehicles vh) {
		dao.save(vh);
	}

	@Override
	public void supp(Vehicles vh) {
		dao.delete(vh);
	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public Vehicles findById(Long id) {
		return dao.findOne(id);
	}

}
