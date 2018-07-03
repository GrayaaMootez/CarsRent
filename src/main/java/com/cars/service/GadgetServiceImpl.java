package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.GadgetDao;
import com.cars.model.Gadget;

@Service
public class GadgetServiceImpl implements GadgetService{

	@Autowired
	private GadgetDao dao;


	@Override
	public List<Gadget> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Gadget gadget) {
		dao.saveAndFlush(gadget);

	}

	@Override
	public void modifier(Gadget gadget) {
		dao.saveAndFlush(gadget);

	}

	@Override
	public void supp(Gadget gadget) {
		dao.delete(gadget);

	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public Gadget findById(Long id) {
		return dao.findOne(id);
	}

}
