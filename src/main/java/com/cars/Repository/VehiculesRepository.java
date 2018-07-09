package com.cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Vehicles;


@Repository
public interface VehiculesRepository extends JpaRepository<Vehicles, Long>{


}
