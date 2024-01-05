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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CAR")
public class Car implements Comparable<Car>, Serializable{

	private static final long serialVersionUID = 3594839582111552527L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// Engine Information
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "TRANSMISSION_ID", referencedColumnName = "ID")
	private Transmission transmission;
	
	@NotNull
	@Column(name="ENGINETYPE", nullable=false)
	private String enginetype;

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "DRIVELINE_ID", referencedColumnName = "ID")
	private DriveLine driveLine;
	
	// Dimensions
	@Column(name="WIDTH", nullable=true)
	private int width;
	
	@Column(name="LENGTH", nullable=true)
	private int length;
	
	@Column(name="HEIGHT", nullable=true)
	private int height;
	
	// Identification
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "MAKE_ID", referencedColumnName = "ID")
	private Make make;
	
	@NotEmpty
	@Column(name="MODELYEAR", nullable=false)
	private String modelyear;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	@NotNull
	@Column(name="YEAR", nullable=false)
	private int year;
	
	// FuelInformation
	@Column(name="HIGHWAYMPG", nullable=true)
	private int highwaympg;
	
	@Column(name="CITYMPH", nullable=true)
	private int citymph;
	
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "FUELTYPE_ID", referencedColumnName = "ID")
	private FuelType fueltype;
	
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "CLASSIFICATION_ID", referencedColumnName = "ID")
	private Classification classification;
	
	@Column(name="HORSEPOWER", nullable=true)
	private int horsepower;
	
	@Column(name="TORQUE", nullable=true)
	private int torque;
	
	@NotNull
	@Column(name="HYBRID", nullable=false)
	private boolean hybrid;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) 
	@JoinColumn(name = "car_id") 
	private List<CarImage> carImages;
	
	public Car() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public String getEnginetype() {
		return enginetype;
	}

	public void setEnginetype(String enginetype) {
		this.enginetype = enginetype;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public String getModelyear() {
		return modelyear;
	}

	public void setModelyear(String modelyear) {
		this.modelyear = modelyear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHighwaympg() {
		return highwaympg;
	}

	public void setHighwaympg(int highwaympg) {
		this.highwaympg = highwaympg;
	}

	public int getCitymph() {
		return citymph;
	}

	public void setCitymph(int citymph) {
		this.citymph = citymph;
	}

	public FuelType getFueltype() {
		return fueltype;
	}

	public void setFueltype(FuelType fueltype) {
		this.fueltype = fueltype;
	}

	public DriveLine getDriveLine() {
		return driveLine;
	}

	public void setDriveLine(DriveLine driveLine) {
		this.driveLine = driveLine;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
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
	
	public boolean isHybrid() {
		return hybrid;
	}

	public void setHybrid(boolean hybrid) {
		this.hybrid = hybrid;
	}
	
	public List<CarImage> getCarImages() {
		return carImages;
	}

	public void setCarImages(List<CarImage> carImages) {
		this.carImages = carImages;
	}
	
	@Override
	public int compareTo(Car o) {
		
		if (this.getId() <= o.getId()) {
			return -1;
		}else {
			return 1;
		}
	}

	@Override
	public boolean equals(Object obj) {
		Car c1 = (Car)obj;
		return this.getId() == c1.getId();
	}

	@Override
	public String toString() {
		return "{id: "+id+",make: "+getMake().getMake()+", name: "+name+"}";
	}
		
	
}
