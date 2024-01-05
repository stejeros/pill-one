package com.practicas.dao;

import java.util.List;

import com.practicas.model.FuelType;

public interface FuelTypeDao {

	List<FuelType> findFueltTpes();
	
	FuelType findFuelTypeByName(String name);
	
	FuelType save(FuelType f);
	
	FuelType getByPk(Integer key);
}
