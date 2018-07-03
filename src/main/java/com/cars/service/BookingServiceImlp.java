package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.dao.BookingDao;
import com.cars.model.Booking;

@Service
public class BookingServiceImlp implements BookingService {

	@Autowired
	private BookingDao dao;

	@Override
	public List<Booking> findAll() {
		return dao.findAll();
	}

	@Override
	public void ajout(Booking bk) {
		dao.saveAndFlush(bk);

	}

	@Override
	public void modifier(Booking bk) {
		dao.saveAndFlush(bk);

	}

	@Override
	public void supp(Booking bk) {
		dao.delete(bk);

	}

	@Override
	public void suppById(Long id) {
		dao.delete(id);

	}

	@Override
	public Booking findById(Long id) {
		return dao.findOne(id);
	}

}
