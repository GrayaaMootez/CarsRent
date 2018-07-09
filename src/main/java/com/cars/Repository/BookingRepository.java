package com.cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
