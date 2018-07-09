package com.cars.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cars.Repository.VehiculesRepository;
import com.cars.model.Vehicles;


@RunWith(SpringJUnit4ClassRunner.class)
public class VehiculesServiceTest {

	@Mock
	private VehiculesRepository repository;

	@InjectMocks
	private VehiculesServiceImpl service;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void testGetAllToDo(){
		List<Vehicles> vList = new ArrayList<Vehicles>();
		vList=repository.findAll();
		when(repository.findAll()).thenReturn(vList);
		List<Vehicles> result = service.findAll();
		System.out.println(result.size());
		assertEquals(149, result.size());
	}
}
