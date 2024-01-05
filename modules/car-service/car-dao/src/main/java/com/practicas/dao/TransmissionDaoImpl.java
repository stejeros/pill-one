package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Transmission;

@Repository("transmissionDao")
@Transactional
public class TransmissionDaoImpl extends AbstractDao<Integer, Transmission> implements TransmissionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Transmission> findTransmissions() {
		try {
			List<Transmission> trans = getEntityManager().createQuery("SELECT f FROM FuelType f ").getResultList();
			return trans;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Transmission findTransmissionByName(String name) {

		try {
			Transmission t = (Transmission) getEntityManager()
					.createQuery("SELECT t FROM Transmission t where t.transmission = :transmission")
					.setParameter("transmission", name).getSingleResult();
			return t;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Transmission save(Transmission t) {
		if (findTransmissionByName(t.getTransmission()) == null) {
			return persist(t);
		}
		return t;
	}
	
	public Transmission getByPk(Integer key) {
		return getByKey(key);
	}
	
}
