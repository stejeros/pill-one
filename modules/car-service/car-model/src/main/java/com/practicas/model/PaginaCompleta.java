package com.practicas.model;

import java.util.List;
import java.util.Map;

public class PaginaCompleta {

	
	private List<Car> cars;
	
	private Map<String, List<?>> filters;

	public PaginaCompleta() {
		
	}
	
	public PaginaCompleta(List<Car> cars, Map<String, List<?>> filters) {
		this.cars = cars;
		this.filters = filters;
	}
	
	
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	public Map<String, List<?>> getFilters() {
		return filters;
	}
	public void setFilters(Map<String, List<?>> filters) {
		this.filters = filters;
	}
	
}
