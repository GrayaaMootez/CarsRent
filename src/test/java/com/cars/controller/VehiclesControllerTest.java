package com.cars.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.model.Brand;
import com.cars.model.Vehicles;
import com.cars.service.VehiculesService;

@RunWith(MockitoJUnitRunner.class)
public class VehiclesControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private VehiclesController vehiclesController;

	@Mock
	private VehiculesService service;

	@Spy
	ModelMap model;

	@Mock
	BindingResult result;

	@Mock
	RedirectAttributes redirectAttributes;

	@Mock
	MessageSource message;

	@Spy
	List<Vehicles> vehicles = new ArrayList<>();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(this.vehiclesController).build();
		vehicles = getVehiclesList();
	}

	@Test
	public void listV() {
		when(service.findAll()).thenReturn(vehicles);
		assertEquals(vehiclesController.listV(model), "/admin/vhs");
		assertEquals(model.get("listVhs"), vehicles);
		verify(service, atLeastOnce()).findAll();
	}

	@Test
	public void addVhs() {

		assertEquals(vehiclesController.addVhs(model), "/admin/addVhs");
		assertNotNull(model.get("vehicule"));
	}

	@Test
	public void saveVhsWithValidationError() {

		when(result.hasErrors()).thenReturn(true);
		assertEquals(vehiclesController.save(vehicles.get(0), result, model), "/admin/addVhs");
	}

	@Test
	public void saveVhsWithoutValidationError() {
		when(result.hasErrors()).thenReturn(false);
		Vehicles vehicule = vehicles.get(0);
		when(service.ajout(any(Vehicles.class))).thenReturn(vehicule);
		assertEquals(vehiclesController.save(vehicule, result, model), "redirect:/admin/vhs");
	}

	@Test
	public void deleteVhs() {
		doNothing().when(service).suppById(anyLong());
		assertEquals(vehiclesController.deleteVhs("0", redirectAttributes), "redirect:/admin/vhs");
	}


	@Test
	public void editVhs() {
		Vehicles vehicule = vehicles.get(0);
		when(service.findById(1L)).thenReturn(vehicule);
		assertEquals(vehiclesController.editVh(1L, model), "/admin/editVhs");
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
