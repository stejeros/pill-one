package com.practicas.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.dao.CarDao;
import com.practicas.model.Car;
import com.practicas.model.comparators.CarComparator;
import com.practicas.services.CarService;
import com.practicas.services.data.DatabaseJson;


public class OldCarServiceImpl {

	public long totalCar;
	
	@Autowired
	private CarDao carDao;
	
	@PostConstruct
	public void init() {
		
	}
	
	/**
	 * Obtiene los coches de un rango, se precargan todos
	 * @param start inicio del rango
	 * @param stop fin del rango
	 * @return
	 */
	private List<Car> getCars(int start, int stop) {
		
		// comprobamos los parámetros de entrada
		
		//List<Car> listCar = DatabaseJson.loadDatabase().getDataParsed();
		//totalCar = listCar.size();
		int begin = start;
		if(begin < 0) {
			begin = 0;
		}
		int end = stop;
		// si end es mayor que la longitud, end lo asignamos a la longitud
		if(end <= 0 ) {
			end = 0;
		}
		
		return carDao.findPaginationCars(begin, end);
	}
	
	public long getTotalCar() {
		if(totalCar == 0) {
			getCars(-1, -1);
		}
		return totalCar;
	}
	
	public List<Car> getCars(){
		
		return getCars(-1, -1);
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, Predicate<Car> p) {
		
		List<Car> cars = getCars(-1, -1);
		Stream<Car> stream = cars.stream();
		if(p != null) {
			stream = stream.filter(p);
			
		}
		
		return stream.collect(Collectors.toList()).subList(start, end);
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList());
		return cars;
	}
	
	/**
	 * Obtiene los coches que cumplen un predicado
	 * @param start inicio
	 * @param end fin
	 * @param p Predicado
	 * @return
	 */
	public List<Car> getCars(int start, int end, List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		List<Car> cars = stream.collect(Collectors.toList()).subList(start, end);
		return cars;
	}
	
	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * @param p
	 * @return
	 */
	public long getCarsCount(List<Predicate<Car>> ps) {
		
		Stream<Car> stream = getCars(-1, -1).stream();
		if(ps != null) {
			for(Predicate<Car> p: ps) {
				stream = stream.filter(p);
			}
		}
		return stream.count();
	}
	
	
	/**
	 * Obtiene el número de coches que cumplen el predicado
	 * @param p
	 * @return
	 */
	public long getCarsCount(Predicate<Car> p) {
		
		Stream<Car> stream = getCars(-1, -1).stream().filter(p);
		return stream.count();
	}
	
	public List<Car> getCars(int start, int end, List<Predicate<Car>> p, CarComparator comparator){
		
		List<Car> cars = getCars( -1, -1, p);
		long total = getCarsCount(p);
		if(start < 0) {
			start = 0;
		}
		if(total < end) {
			end = (int)total;
		}
		
		if(comparator != null) {
			return cars.stream().sorted(comparator).collect(Collectors.toList()).subList(start, end);
		}
		
		return cars.stream().sorted().collect(Collectors.toList()).subList(start, end);
	}
	
	/*
	public List<Car> getCars(int start, int end, Predicate<Car> p, CarComparator comparator, int limit){
		
		List<Car> cars = getCars( start, end, p, comparator);
		return cars.stream().limit(limit).collect(Collectors.toList());
	}*/
	
	
	public Car getCarByPk(int pk) {
		
		List<Car> cars = getCars(-1, -1);
		return cars.stream().filter(c -> c.getId() == pk).findFirst().get();
	}

	public Car save(Car c) {
		return carDao.save(c);
	}
	
	
}
