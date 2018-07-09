package com.cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cars.model.Custumer;

@Repository
public interface CustumerRepository extends JpaRepository<Custumer, Long>{

}
