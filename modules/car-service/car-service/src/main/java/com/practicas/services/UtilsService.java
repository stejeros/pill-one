package com.practicas.services;

import java.util.List;

import com.practicas.model.Classification;
import com.practicas.model.DriveLine;
import com.practicas.model.EngineStatistics;
import com.practicas.model.FuelType;
import com.practicas.model.Make;
import com.practicas.model.Transmission;

public interface UtilsService {

	public List<Make> getCarsMakes();
	
	public List<Integer> getCarsYears();
	
	public Make saveMake(Make m);
	
	public FuelType saveFuelType(FuelType f);
	
	public DriveLine saveDriveLine(DriveLine d);
	
	public Transmission saveTransmission(Transmission t);
	
	public EngineStatistics saveEngineStatistics(EngineStatistics e);
	
	public Classification saveClassification(Classification c);
	
	public Make getMakeByName(String m) throws Exception;
	
	public Classification getClassificationByName(String m) throws Exception;
	
	public DriveLine getDriveLineByName(String m) throws Exception;
	
	public FuelType getFuelTypeByName(String m) throws Exception;
	
	public Transmission getTransmissionByName(String m) throws Exception;
}
