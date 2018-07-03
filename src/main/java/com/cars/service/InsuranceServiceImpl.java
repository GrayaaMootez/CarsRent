package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.InsuranceDao;
import com.cars.model.Insurance;

@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	private InsuranceDao dao;

	@Override
	public List<Insurance> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Insurance insurance) {
		dao.saveAndFlush(insurance);

	}

	@Override
	public void modifier(Insurance insurance) {
		dao.saveAndFlush(insurance);

	}

	@Override
	public void supp(Insurance insurance) {
		dao.delete(insurance);

	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public Insurance findById(Long id) {
		return dao.findOne(id);
	}

}

