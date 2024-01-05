package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.FuelType;

@Repository("fuelTypeDao")
@Transactional
public class FuelTypeDaoImpl extends AbstractDao<Integer, FuelType> implements FuelTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<FuelType> findFueltTpes() {
		try {
			List<FuelType> fuelType = getEntityManager().createQuery("SELECT f FROM FuelType f ").getResultList();
			return fuelType;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public FuelType findFuelTypeByName(String name) {

		try {
			FuelType f = (FuelType) getEntityManager()
					.createQuery("SELECT f FROM FuelType f where f.fuelType = :fueltype")
					.setParameter("fueltype", name).getSingleResult();
			return f;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public FuelType save(FuelType f) {
		if (findFuelTypeByName(f.getFuelType()) == null) {
			return persist(f);
		}
		return f;
	}
	
	public FuelType getByPk(Integer key) {
		return getByKey(key);
	}

}
