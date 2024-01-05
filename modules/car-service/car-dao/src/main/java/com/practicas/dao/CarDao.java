package com.practicas.dao;

import java.util.List;

import com.practicas.model.Car;
import com.practicas.model.DriveLine;
import com.practicas.model.Make;


public interface CarDao {

	List<Car> findPaginationCars(int page, int pageSize);
	
	List<Car> findPaginationCarsByMake(int page, int pageSize, Make m);
	
	List<Car> findPaginationCarsByMakeAndDriveLine(int page, int pageSize, Make m, DriveLine d);
	
	Integer getTotalCat();
	
	Car save(Car c);
	
	Car update(Car c);
	
	Car getByPk(Integer key);
	
	List<Integer> getCarsYears();
}
