package com.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cars.service.VehiculesService;

@SpringBootApplication
public class MyApplication implements CommandLineRunner

{
	@Autowired
	VehiculesService service;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		/*
		 * List<Vehicles> v=new ArrayList<>(); v=service.findAll();
		 *
		 * for (Vehicles vh : v) { System.out.println(vh.getPrice()); }
		 */
	}
}