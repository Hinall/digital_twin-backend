package com.digitalgis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.digitalgis.dao.DashboardDao;
import com.digitalgis.service.DashboardService;

@Component
public class DashboardServiceImpl implements DashboardService{
	@Autowired
	DashboardDao dao;
	
	@Override
	public String addUpdateStreetLightData( String json) {// for search drop down list
		String resultJson = dao.addUpdateStreetLightData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Override
	public String deleteStreetLightData( String json) {// for search drop down list
		String resultJson = dao.addUpdateStreetLightData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getPointLayer() {// for search drop down list
		String resultJson = dao.getPointLayer();
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	
	@Override
	public String searchLayer(String json) {
		String resultJson = dao.searchLayer(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Override
	public String getRoleByUserId(String json) {
		String resultJson = dao.getRoleByUserId(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	@Override
	public String getRoleList() {
		String resultJson = dao.getRoleList();
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Override
	public String getAnnouncementDetails(String json) {
		String resultJson = dao.getAnnouncementDetails(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Override
	public String crudMilestoneImage(String json) {
		String resultJson = dao.crudMilestoneImage( json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@Override
	public String getStatusList() {
		String resultJson = dao.getStatusList();
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	
	@Override
	public String getAllMilestoneDetails(String json) {
		String resultJson = dao.getAllMilestoneDetails(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	
	@Override
	public String getAllProjectDetails(String json) {
		String resultJson = dao.getAllProjectDetails(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


	@Override
	public String getDrawFeatureData(String json) {
		String resultJson = dao.getDrawFeatureData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getLulcCountDetails(String json) {
		String resultJson = dao.getLulcCountDetails(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getChangeAnalysisData(String json) {
		String resultJson = dao.getChangeAnalysisData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getRetmsChartData(String json) {
		String resultJson = dao.getRetmsChartData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getRetmsDashboardGridData(String json) {
		String resultJson = dao.getRetmsDashboardGridData(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getAllModules() {
		String resultJson = dao.getAllModules();
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public String getRoleById(String json) {
		String resultJson = dao.getRoleById(json);
		if (resultJson != null && !resultJson.isEmpty()) {
			try {
				return resultJson;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}


	
	
	
	
}
