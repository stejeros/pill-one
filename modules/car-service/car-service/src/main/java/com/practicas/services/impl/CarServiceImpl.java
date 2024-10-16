package com.practicas.services.impl;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.dao.CarDao;
import com.practicas.model.Car;
import com.practicas.model.comparators.CarComparator;
import com.practicas.services.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;
	
	@Override
	public Car getCarByPk(int pk) {
		return carDao.getByPk(pk);
	}

	@Override
	public List<Car> getCars(int page, int pageSize) {
		int pageSizeP = pageSize;
		if(pageSizeP <=0) {
			pageSizeP = 25;
		}
		return carDao.findPaginationCars(page, pageSizeP);
	}

	@Override
	public List<Car> getCars(List<Predicate<Car>> ps) {
		return null;
	}

	@Override
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps) {
		return null;
	}

	@Override
	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator) {
		return null;
	}

	@Override
	public long getTotalCar() {
		return carDao.getTotalCat();
	}
	@Override
	public long getCarsCount(List<Predicate<Car>> ps) {
		return 0;
	}

	@Override
	public Car save(Car c) {
		return carDao.save(c);
	}
	
	@Override
	public Car update(Car c) {
		
		return carDao.update(c);
	}
}
