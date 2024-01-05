package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.EngineStatistics;

@Repository("engineStatisticsDao")
@Transactional
public class EngineStatisticsDaoImpl extends AbstractDao<Integer, EngineStatistics> implements EngineStatisticsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EngineStatistics> findEngineStatisticss() {
		try {
			List<EngineStatistics> trans = getEntityManager().createQuery("SELECT e FROM EngineStatistics e ").getResultList();
			return trans;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public EngineStatistics findEngineStatisticsByTorqueHorsePower(int torque, int horsepower) {

		try {
			EngineStatistics e = (EngineStatistics) getEntityManager()
					.createQuery("SELECT e FROM EngineStatistics e where e.torque = :torque and e.horsepower = :horsepower ")
					.setParameter("torque", torque).setParameter("horsepower", horsepower).getSingleResult();
			return e;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public EngineStatistics save(EngineStatistics e) {
		if (findEngineStatisticsByTorqueHorsePower(e.getTorque(), e.getHorsepower()) == null) {
			return persist(e);
		}
		return e;
	}
	
	public EngineStatistics getByPk(Integer key) {
		return getByKey(key);
	}
	
}
