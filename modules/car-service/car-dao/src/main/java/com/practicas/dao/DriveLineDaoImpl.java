package com.practicas.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.practicas.model.DriveLine;

@Repository("driveLineDao")
@Transactional
public class DriveLineDaoImpl extends AbstractDao<Integer, DriveLine> implements DriveLineDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DriveLine> findDriveLines() {
		try {
			List<DriveLine> fuelType = getEntityManager().createQuery("SELECT d FROM DriveLine d ").getResultList();
			return fuelType;
		} catch (NoResultException ex) {
			return null;
		}
	}

	public DriveLine findDriveLineByName(String name) {

		try {
			DriveLine d = (DriveLine) getEntityManager()
					.createQuery("SELECT d FROM DriveLine d where d.driveLine = :driveLine")
					.setParameter("driveLine", name).getSingleResult();
			return d;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public DriveLine save(DriveLine d) {
		if (findDriveLineByName(d.getDriveLine()) == null) {
			return persist(d);
		}
		return d;
	}
	
	public DriveLine getByPk(Integer key) {
		return getByKey(key);
	}

}
