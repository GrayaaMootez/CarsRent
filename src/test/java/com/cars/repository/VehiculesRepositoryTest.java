package com.cars.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cars.model.Brand;
import com.cars.model.Vehicles;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VehiculesRepositoryTest {

	@Autowired
	VehiculesRepository repository;

	@Autowired
	BrandRepository repositoryb;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void findOne() {

		Brand b = new Brand(1, "BMW", "1 series", "Convertible");
		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);
		entityManager.persist(b);
		entityManager.persist(v1);

		Vehicles found = repository.findOne(1L);
		assertThat(found.getVehicleId()).isEqualTo(v1.getVehicleId());
	}

	@Test()
	public void delete() {

		Brand b = new Brand(1, "BMW", "1 series", "Convertible");
		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);
		entityManager.persist(b);
		entityManager.persist(v1);
		repository.delete(1L);
		assertNull(repository.findOne(1L));
	}

	@Test
	public void findAll() {

		Brand b = new Brand(1, "BMW", "1 series", "Convertible");

		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);
		Vehicles v2 = new Vehicles(2L, b, 4785L, 2.5, 178L);
		Vehicles v3 = new Vehicles(3L, b, 7515L, 4.5, 238L);

		entityManager.persist(b);
		entityManager.persist(v1);
		entityManager.persist(v2);
		entityManager.persist(v3);
		entityManager.flush();

		assertEquals(repository.findAll().size(), 3);
	}

	@Test()
	public void save() {

		Brand b = new Brand(1, "BMW", "1 series", "Convertible");
		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);

		repositoryb.save(b);
		Vehicles v2 = repository.save(v1);

		assertEquals(repository.findOne(v2.getVehicleId()).getVehicleId(), v1.getVehicleId());
	}

	@Test()
	public void modify() {

		Brand b = new Brand(1, "BMW", "1 series", "Convertible");
		Vehicles v1 = new Vehicles(1L, b, 3293L, 1.7, 119L);
		entityManager.persist(b);
		entityManager.persist(v1);

		Long price=500L;
		v1.setPrice(price);

		Vehicles v2 = repository.save(v1);

		assertEquals(repository.findOne(v2.getVehicleId()).getPrice(), price);
	}

}
