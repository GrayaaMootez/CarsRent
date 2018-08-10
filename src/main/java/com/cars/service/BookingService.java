package com.cars.service;

import java.util.List;

import com.cars.model.Booking;

public interface BookingService {

	List<Booking> findAll();

	Booking ajout(Booking bk);

	void modifier(Booking bk);

	void supp(Booking bk);

	void suppById(Long id);

	Booking findById(Long id);
}
