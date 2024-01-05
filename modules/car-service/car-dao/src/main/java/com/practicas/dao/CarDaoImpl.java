package com.practicas.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Car;
import com.practicas.model.DriveLine;
import com.practicas.model.Make;

@Repository("carDao")
@Transactional
public class CarDaoImpl extends AbstractDao<Serializable, Car> implements CarDao {

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCars(int page, int pageSize) {
		
		int pageCalc = page - 1;
		if(pageCalc< 0 ) {
			pageCalc = 0;
		}
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c ORDER BY c.id ASC")
				.setFirstResult(pageCalc * pageSize)
				.setMaxResults(pageSize)
				.getResultList();
		
		return listCar;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCarsByMake(int page, int pageSize, Make m) {
		
		int pageCalc = page - 1;
		if(pageCalc< 0 ) {
			pageCalc = 0;
		}
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c, Make m WHERE c.make.id = m.id AND m.id = :ma ORDER BY m.make ASC")
				.setFirstResult(pageCalc * pageSize)
				.setMaxResults(pageSize)
				.setParameter("ma", m.getId())
				.getResultList();
		
		return listCar;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Car> findPaginationCarsByMakeAndDriveLine(int page, int pageSize, Make m, DriveLine d) {
		
		int pageCalc = page - 1;
		if(pageCalc< 0 ) {
			pageCalc = 0;
		}
		
		List<Car> listCar = getEntityManager()
				.createQuery("SELECT c FROM Car c, Make m, DriveLine d WHERE c.make.id = m.id AND c.driveLine.id = d.id AND m.id = :ma AND d.id :dr ORDER BY m.make ASC")
				.setFirstResult(pageCalc * pageSize)
				.setMaxResults(pageSize)
				.setParameter("ma", m.getId())
				.setParameter("dr", d.getId())
				.getResultList();
		
		return listCar;
	}
	

	public List<Car> findPaginationCarsEjemplo(int start, int end, Map<String, Object> params, String order, String ascDesc) {
		
		StringBuffer sb = new StringBuffer("SELECT c FROM Car c WHERE ");
		for(Map.Entry<String, Object> entry: params.entrySet()) {
			sb.append(" AND ");
			sb.append(entry.getKey());
			sb.append(" = ");
			sb.append(" :");
			sb.append(entry.getKey());
		}
		
		if(order != null && !order.equals("")) {
			sb.append(" ORDER BY "+order+","+ascDesc);
		}
		if(start > 0) {
			sb.append(" LIMIT "+start+","+end);
		}
		if(end > 0) {
			sb.append(" , "+end);
		}
		Query q = getEntityManager().createQuery(sb.toString());
		
		for(Map.Entry<String, Object> entry: params.entrySet()) {
			if(entry.getValue() instanceof String) {
				q.setParameter(entry.getKey(), (String)entry.getValue());
			}else if(entry.getValue() instanceof Integer) {
				q.setParameter(entry.getKey(), (Integer)entry.getValue());
			}
		}
		@SuppressWarnings("unchecked")
		List<Car> listCar = q.getResultList();
		
		return listCar;
	}
	
	public Car findCarByName(String name) {

		try {
			Car c = (Car) getEntityManager()
					.createQuery("SELECT c FROM Car c where c.name = :name")
					.setParameter("name", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public Car save(Car c) {
		Car c1 = findCarByName(c.getName());
		if(c1 == null) {
			return persist(c);
		}
		return c1;
	}
	
	@Override
	public Car update(Car c) {
		return update(c);
	}
	
	public int update(int id,String name, String engineType, int driveLine, int make) {
		
		int executed = getEntityManager()
		.createQuery("UPDATE Car c set c.name = :name, engineType = :engineType WHERE c.id = :id")
		.setParameter("name", name)
		.executeUpdate();

		return executed;
	}
	
	public Car getByPk(Integer key) {
		return getByKey(key);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCarsYears() {
		
		List<Integer> listCar = getEntityManager()
		.createQuery("SELECT distinct (c.year) FROM Car c ORDER BY c.year")
		.getResultList();

		return listCar;
	}

	@Override
	public Integer getTotalCat() {
		return getEntityManager()
				.createQuery("SELECT c FROM Car c ORDER BY c.id ASC")
				.getMaxResults();
	}

}
