package com.practicas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SortNatural;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MAKE")
public class Make implements Serializable{

	
	
	private static final long serialVersionUID = -4096888939812857252L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="MAKE", nullable=false)
	@SortNatural
	private String make;
	
	@NotNull
	@OneToMany( mappedBy="make", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private transient List<Car> cars;
	
	
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public Make() {
		super();
	}
	
	public Make(int id, String make) {
		super();
		this.id = id;
		this.make = make;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+",make: "+make+"}";
	}
	
	
}
