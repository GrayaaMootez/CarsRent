package com.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Gadget;

@Repository
public interface GadgetRepository extends JpaRepository<Gadget, Long>{

}
