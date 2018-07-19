package com.cars.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cars.model.Brand;
import com.cars.model.Vehicles;
import com.cars.repository.VehiculesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehiculesServiceTest {

	@Mock
	private VehiculesRepository repository;

	@InjectMocks
	private VehiculesServiceImpl service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		vhs = getVehiclesList();
	}

	@Spy
	List<Vehicles> vhs = new ArrayList<>();

	@Test
	public void findAllVehicles() {

		when(repository.findAll()).thenReturn(vhs);
		assertEquals(service.findAll(), vhs);
		assertEquals(3, service.findAll().size());
	}

	@Test
	public void findById() {
		Vehicles v1 = vhs.get(0);
		when(repository.findOne(1L)).thenReturn(v1);
		Vehicles result = service.findById(1L);
		Long l = 1L;
		assertEquals(l, result.getVehicleId());
	}

	@Test()
	public void saveVehicles() {
		Vehicles v1 = vhs.get(0);
		when(repository.save(v1)).thenReturn(v1);
		v1.setVehicleId(5L);
		Vehicles result = service.ajout(v1);
		Long l = 5L;
		assertEquals(l, result.getVehicleId());
	}

	@Test
	public void deleteProfil() {

		Vehicles v1 = vhs.get(0);
		service.supp(v1);
		verify(repository, times(1)).delete(v1);
	}

	public List<Vehicles> getVehiclesList() {

		Brand b = new Brand(1d, "BMW", "1 series", "Convertible");
		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);
		Vehicles v2 = new Vehicles(2L, b, 4785L, 2.5, 178L);
		Vehicles v3 = new Vehicles(3L, b, 7515L, 4.5, 238L);

		List<Vehicles> vhs = new ArrayList<>();
		vhs.add(v1);
		vhs.add(v2);
		vhs.add(v3);

		return vhs;
	}

}
