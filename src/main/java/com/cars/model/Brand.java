package com.cars.model;
// Generated 6 juin 2018 18:04:52 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Brand generated by hbm2java
 */
@Entity
@Table(name = "BRAND")
public class Brand implements java.io.Serializable {

	@NotNull
	private Double brandId;
	@NotEmpty
	private String brandName;
	@NotEmpty
	private String modelName;
	@NotEmpty
	private String category;
	private Set<Vehicles> vehicleses = new HashSet<Vehicles>(0);

	public Brand() {
	}

	public Brand(Double brandId, String brandName, String modelName, String category) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.modelName = modelName;
		this.category = category;
	}

	public Brand(Double brandId, String brandName, String modelName, String category, Set<Vehicles> vehicleses) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.modelName = modelName;
		this.category = category;
		this.vehicleses = vehicleses;
	}

	@Id

	@Column(name = "BRAND_ID", unique = true, nullable = false, precision = 126, scale = 0)
	public Double getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Double brandId) {
		this.brandId = brandId;
	}

	@Column(name = "BRAND_NAME", nullable = false, length = 45)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "MODEL_NAME", nullable = false, length = 45)
	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Column(name = "CATEGORY", nullable = false, length = 45)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<Vehicles> getVehicleses() {
		return this.vehicleses;
	}

	public void setVehicleses(Set<Vehicles> vehicleses) {
		this.vehicleses = vehicleses;
	}

}
