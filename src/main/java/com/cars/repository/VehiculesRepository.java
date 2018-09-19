package com.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cars.model.Vehicles;


@Repository
public interface VehiculesRepository extends JpaRepository<Vehicles, Long>{

	@Query("select vh.vehicleId from Vehicles vh where not exists ( select va.vehicles.vehicleId from VehAv va where vh.vehicleId=va.vehicles.vehicleId and va.isAvailUntil > sysdate) order by vh.vehicleId asc")
	public List<Long> vehiculesAvaible();


}
