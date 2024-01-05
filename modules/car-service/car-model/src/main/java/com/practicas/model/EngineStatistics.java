package com.practicas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ENGINESTATISTICS")
public class EngineStatistics implements Serializable{

	private static final long serialVersionUID = 3988240899233372627L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="HORSEPOWER", nullable=false)
	private int horsepower;
	
	@NotNull
	@Column(name="TORQUE", nullable=false)
	private int torque;
	
	public EngineStatistics() {
		
	}
	
	public EngineStatistics(int id, int horsepower, int torque) {
		super();
		this.id = id;
		this.horsepower = horsepower;
		this.torque = torque;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	public int getTorque() {
		return torque;
	}

	public void setTorque(int torque) {
		this.torque = torque;
	}
	
	
}
