package com.practicas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="FUELTYPE")
public class FuelType implements Serializable{
	
	private static final long serialVersionUID = -8552078235100626997L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="FUELTYPE", nullable=false)
	private String fuelType;
	
	public FuelType() {
		super();
	}
	
	public FuelType(int id, String fuelType) {
		super();
		this.id = id;
		this.fuelType = fuelType;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{id: "+id+",fuelType: "+fuelType+"}";
	}
	
	
}
