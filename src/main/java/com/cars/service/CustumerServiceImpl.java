package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.CustumerDao;
import com.cars.model.Custumer;

@Service
public class CustumerServiceImpl implements CustumerService {

	@Autowired
	private CustumerDao dao;

	@Override
	public List<Custumer> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Custumer br) {
		dao.saveAndFlush(br);

	}

	@Override
	public void modifier(Custumer br) {
		dao.saveAndFlush(br);

	}

	@Override
	public void supp(Custumer br) {
		dao.delete(br);

	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public Custumer findById(Long id) {
		return dao.findOne(id);
	}
}
