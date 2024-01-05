package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Make;

@Repository("makeDao")
@Transactional
public class MakeDaoImpl extends AbstractDao<Integer, Make> implements MakeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Make> findMakes() {
		try {
			List<Make> makes = getEntityManager().createQuery("SELECT m FROM Make m ").getResultList();
			
			return makes;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Make findMakeByName(String name) {

		try {
			Make make = (Make) getEntityManager()
					.createQuery("SELECT m FROM Make m where m.make = :make")
					.setParameter("make", name).getSingleResult();
			return make;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Make save(Make m) {
		if (findMakeByName(m.getMake()) == null) {
			return persist(m);
		}
		return m;
	}

	
	public Make getByPk(Integer key) {
		return getByKey(key);
	}
}
