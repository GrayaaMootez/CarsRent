package com.cars.model;
// Generated 6 juin 2018 18:04:52 by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VehAv generated by hbm2java
 */
@Entity
@Table(name = "VEH_AV")
public class VehAv implements java.io.Serializable {

	private Long vehAvId;
	private Vehicles vehicles;
	private Date isAvailUntil;
	private Date isAvailFrom;

	public VehAv() {
	}

	public VehAv(Long vehAvId, Vehicles vehicles) {
		this.vehAvId = vehAvId;
		this.vehicles = vehicles;
	}

	public VehAv(Long vehAvId, Vehicles vehicles, Date isAvailUntil, Date isAvailFrom) {
		this.vehAvId = vehAvId;
		this.vehicles = vehicles;
		this.isAvailUntil = isAvailUntil;
		this.isAvailFrom = isAvailFrom;
	}

	@Id

	@Column(name = "VEH_AV_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getVehAvId() {
		return this.vehAvId;
	}

	public void setVehAvId(Long vehAvId) {
		this.vehAvId = vehAvId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VEHICLE_ID", nullable = false)
	public Vehicles getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "IS_AVAIL_UNTIL", length = 7)
	public Date getIsAvailUntil() {
		return this.isAvailUntil;
	}

	public void setIsAvailUntil(Date isAvailUntil) {
		this.isAvailUntil = isAvailUntil;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "IS_AVAIL_FROM", length = 7)
	public Date getIsAvailFrom() {
		return this.isAvailFrom;
	}

	public void setIsAvailFrom(Date isAvailFrom) {
		this.isAvailFrom = isAvailFrom;
	}

}
