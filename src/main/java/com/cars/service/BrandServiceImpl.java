package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.BrandDao;
import com.cars.model.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao dao;

	@Override
	public List<Brand> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Brand br) {
		dao.saveAndFlush(br);

	}

	@Override
	public void modifier(Brand br) {
		dao.saveAndFlush(br);

	}

	@Override
	public void supp(Brand br) {
		dao.delete(br);

	}

	@Override
	public void suppById(Double id) {
		dao.delete(id);

	}

	@Override
	public Brand findById(Double id) {
		return dao.findOne(id);
	}
}
