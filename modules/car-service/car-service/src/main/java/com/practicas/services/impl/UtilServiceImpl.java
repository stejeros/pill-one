package com.practicas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicas.dao.ClassificationDao;
import com.practicas.dao.DriveLineDao;
import com.practicas.dao.EngineStatisticsDao;
import com.practicas.dao.FuelTypeDao;
import com.practicas.dao.MakeDao;
import com.practicas.dao.TransmissionDao;
import com.practicas.model.Classification;
import com.practicas.model.DriveLine;
import com.practicas.model.EngineStatistics;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;
import com.practicas.services.UtilsService;

@Service("utilService")
public class UtilServiceImpl implements UtilsService {

	@Autowired
	private TransmissionDao transmissionDao;
	
	@Autowired
	private MakeDao makeDao;

	@Autowired
	private FuelTypeDao fuelTypeDao;
	
	@Autowired
	private DriveLineDao driveLineDao;
	
	@Autowired
	private EngineStatisticsDao engineStatisticsDao;
	
	@Autowired
	private ClassificationDao classificationDao;
	
	/**
	 * Obtiene las marcas distintas de los coches
	 * 
	 * @return
	 */
	public List<Make> getCarsMakes() {

		return makeDao.findMakes();
	}

	/**
	 * Obtiene los años distintos de los vehículos
	 * 
	 * @return
	 */
	public List<Integer> getCarsYears() {

		return new ArrayList<Integer>();
	}

	public Make saveMake(Make m) {

		return makeDao.save(m);
	}

	public FuelType saveFuelType(FuelType f) {

		return fuelTypeDao.save(f);
	}

	public DriveLine saveDriveLine(DriveLine d) {

		return driveLineDao.save(d);
	}
	
	public Transmission saveTransmission(Transmission t) {

		return transmissionDao.save(t);
	}
	
	public EngineStatistics saveEngineStatistics(EngineStatistics e) {

		return engineStatisticsDao.save(e);
	}
	
	public Classification saveClassification(Classification c) {

		return classificationDao.save(c);
	}
	
	
	public Make getMakeByName(String m) throws Exception{
		Make make = makeDao.findMakeByName(m);
		if(make == null) {
			throw new Exception("Marca con nombre "+ m +" no encontrada");
		}
		return make;
	}
	
	public Classification getClassificationByName(String m) throws Exception{
		Classification c = classificationDao.findClassificationByName(m);
		if(c == null) {
			throw new Exception("Classification con nombre "+ m +" no encontrada");
		}
		return c;
	}
	
	public DriveLine getDriveLineByName(String m) throws Exception{
		DriveLine d = driveLineDao.findDriveLineByName(m);
		if(d == null) {
			throw new Exception("DriveLine con nombre "+ m +" no encontrada");
		}
		return d;
	}

	@Override
	public FuelType getFuelTypeByName(String m) throws Exception {
		FuelType f = fuelTypeDao.findFuelTypeByName(m);
		if(f == null) {
			throw new Exception("FuelType con nombre "+ m +" no encontrada");
		}
		return f;
	}

	@Override
	public Transmission getTransmissionByName(String m) throws Exception {
		Transmission t = transmissionDao.findTransmissionByName(m);
		if(t == null) {
			throw new Exception("Transmission con nombre "+ m +" no encontrada");
		}
		return t;
	}
	
	
	
}
