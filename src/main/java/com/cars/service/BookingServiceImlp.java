package com.cars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.Repository.BookingRepository;
import com.cars.model.Booking;

@Service
public class BookingServiceImlp implements BookingService {

	@Autowired
	private BookingRepository repository;

	@Override
	public List<Booking> findAll() {
		return repository.findAll();
	}

	@Override
	public void ajout(Booking bk) {
		repository.saveAndFlush(bk);

	}

	@Override
	public void modifier(Booking bk) {
		repository.saveAndFlush(bk);

	}

	@Override
	public void supp(Booking bk) {
		repository.delete(bk);

	}

	@Override
	public void suppById(Long id) {
		repository.delete(id);

	}

	@Override
	public Booking findById(Long id) {
		return repository.findOne(id);
	}

}
