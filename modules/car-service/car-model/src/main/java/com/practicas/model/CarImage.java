package com.practicas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Parent;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CARIMAGE")
public class CarImage implements Serializable{

	

	private static final long serialVersionUID = 3594839582111552528L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="IMAGE", nullable=false)
	private byte[] image;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@JoinColumn(name = "car_id", referencedColumnName = "id")
	@ManyToOne(optional=false)
	private Car car;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
