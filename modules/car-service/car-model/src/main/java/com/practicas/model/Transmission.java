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
@Table(name="TRANSMISSION")
public class Transmission implements Serializable{

	private static final long serialVersionUID = 5712342354647258470L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="TRANSMISSION", nullable=false)
	private String transmission;
	
	public Transmission() {
		super();
	}
	
	public Transmission(int id, String transmission) {
		super();
		this.id = id;
		this.transmission = transmission;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	@Override
	public String toString() {
		return "{id: "+id+",transmission: "+transmission+"}";
	}
	
	
}
