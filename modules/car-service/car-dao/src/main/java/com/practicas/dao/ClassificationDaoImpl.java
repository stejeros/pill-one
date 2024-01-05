package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.Classification;

@Repository("classificationDao")
@Transactional
public class ClassificationDaoImpl extends AbstractDao<Integer, Classification> implements ClassificationDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Classification> findClassifications() {
		try {
			List<Classification> fuelType = getEntityManager().createQuery("SELECT c FROM Classification c ").getResultList();
			return fuelType;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public Classification findClassificationByName(String name) {

		try {
			Classification c = (Classification) getEntityManager()
					.createQuery("SELECT c FROM Classification c where c.classification = :classification")
					.setParameter("classification", name).getSingleResult();
			return c;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Classification save(Classification t) {
		if (findClassificationByName(t.getClassification()) == null) {
			return persist(t);
		}
		return t;
	}
	
	public Classification getByPk(Integer key) {
		return getByKey(key);
	}

}
