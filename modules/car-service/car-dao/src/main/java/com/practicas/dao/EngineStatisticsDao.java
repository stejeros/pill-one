package com.practicas.dao;

import java.util.List;

import com.practicas.model.EngineStatistics;

public interface EngineStatisticsDao {

	List<EngineStatistics> findEngineStatisticss();
	
	EngineStatistics findEngineStatisticsByTorqueHorsePower(int torque, int horsepower);
	
	EngineStatistics save(EngineStatistics t);
	
	EngineStatistics getByPk(Integer key);
}
