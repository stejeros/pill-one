package com.practicas.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.practicas.model.Car;
import com.practicas.model.comparators.CarComparator;

public interface CarService {

	public  Car getCarByPk(int pk);
	
	public List<Car> getCars(int page, int pageSize);
	
	public List<Car> getCars(List<Predicate<Car>> ps);
	
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps);
	
	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator);
	
	public long getTotalCar();
	
	public long getCarsCount(List<Predicate<Car>> ps);
	
	public Car save(Car c);
	
	public Car update(Car c);
	
}
