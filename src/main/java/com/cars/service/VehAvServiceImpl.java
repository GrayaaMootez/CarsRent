package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cars.dao.VehAvDao;
import com.cars.model.VehAv;

@Repository
public class VehAvServiceImpl implements VehAvService {

	@Autowired
	private VehAvDao dao;

	@Override
	public List<VehAv> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(VehAv vh) {
		dao.saveAndFlush(vh);

	}

	@Override
	public void modifier(VehAv vh) {
		dao.saveAndFlush(vh);

	}

	@Override
	public void supp(VehAv vh) {
		dao.delete(vh);

	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public VehAv findById(Long id) {
		return dao.findOne(id);
	}

}
