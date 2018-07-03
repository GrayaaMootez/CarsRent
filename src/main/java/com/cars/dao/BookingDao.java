package com.cars.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Booking;

@Repository
public interface BookingDao extends JpaRepository<Booking, Long>{

}
