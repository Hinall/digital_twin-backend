package com.digitalgis.service;

import org.springframework.stereotype.Service;

@Service
public interface DashboardService {

	String getDrawFeatureData(String json);

	String getLulcCountDetails(String json);

	String getChangeAnalysisData(String json);

	String getRetmsChartData(String json);

	String getRetmsDashboardGridData(String json);

	String getAllModules();

	String getRoleById(String json);

	String getAllProjectDetails(String json);

	String getAllMilestoneDetails(String json);

	String getStatusList();

	String crudMilestoneImage(String string);

	String getAnnouncementDetails(String json);

	String getRoleByUserId(String json);

	String getRoleList();

	String searchLayer(String json);

	String getPointLayer();

	String addUpdateStreetLightData( String json);

	String deleteStreetLightData (String json);
	
}
