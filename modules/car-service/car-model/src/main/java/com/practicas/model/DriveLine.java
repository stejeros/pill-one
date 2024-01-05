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
@Table(name="DRIVELINE")
public class DriveLine implements Serializable{

	private static final long serialVersionUID = 5975730285393800405L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="DRIVELINE", nullable=false)
	private String driveLine;
	
	public DriveLine() {
		super();
	}
	
	public DriveLine(int id, String driveLine) {
		super();
		this.id = id;
		this.driveLine = driveLine;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDriveLine() {
		return driveLine;
	}

	public void setDriveLine(String driveLine) {
		this.driveLine = driveLine;
	}
	
	@Override
	public String toString() {
		return "{id: "+id+",driveLine: "+driveLine+"}";
	}
	
}
