
package com.digitalgis.dao.impl;

import javax.sql.DataSource;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.digitalgis.dao.DashboardDao;
import com.digitalgis.utils.LoggerUtil;
import com.digitalgis.utils.SPUtility;

@Component
@SuppressWarnings("deprecation")
public class DashboardDaoImpl extends JdbcDaoSupport implements DashboardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public DashboardDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	
	@Override
	public String addUpdateStreetLightData(  String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_ADD_UPDATE_STREETLIGHT_ARMS, new Object[] {json  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in addUpdateStreetLightData ");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String deleteStreetLightData( String json ) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_DELETE_STREETLIGHT_ARMS, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in addUpdateStreetLightData ");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getPointLayer( ) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_POINT_LAYER, new Object[] {  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getDrawFeatureData ");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String searchLayer(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_SEARCH_LAYER, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getDrawFeatureData ");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getRoleByUserId(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_ROLEID_BY_USERNAME, new Object[] { json  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllMilestoneDetails ");
			e.printStackTrace();
			return null;
		}

}
	@Override
	public String getRoleList() {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_ROLE_LIST,
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllMilestoneDetails ");
			e.printStackTrace();
			return null;
		}

}
	
	@Override
	public String getAnnouncementDetails(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_CRUD_ANNOUNCEMENT_MANAGEMENT, new Object[] { json  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllMilestoneDetails ");
			e.printStackTrace();
			return null;
		}

}
	
	@Override
	public String crudMilestoneImage(String json) throws JSONException {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_CRUD_MILESTONE_DETAILS, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in crudMilestoneImage ");
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String getStatusList() {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_GET_STATUS_LIST, new Object[] {  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllModules ");
			e.printStackTrace();
			return null;
		}

}
	
	@Override
	public String getAllMilestoneDetails(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_CRUD_MILESTONE_DETAILS, new Object[] { json  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllMilestoneDetails ");
			e.printStackTrace();
			return null;
		}

}
	
	@Override
	public String getAllProjectDetails(String json) {
		String result;
		try {
			 result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_CRUD_PROJECT_DETAILS, new Object[] { json  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllProjectDetails ");
			e.printStackTrace();
			return null;
		}

}

	@Override
	public String getDrawFeatureData(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_GET_DRAW_FEATURE_DATA, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getDrawFeatureData ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getLulcCountDetails(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_LULC_COUNT_DETAILS, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getLulcCountDetails ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getChangeAnalysisData(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_CHANGE_ANALYSIS_DATA, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getChangeAnalysisData ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getRetmsChartData(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_RETMS_CHART_DATA, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getChangeAnalysisData ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getRetmsDashboardGridData(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_WEB_GET_RETMS_DASHBOARD_GRID_DATA, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getChangeAnalysisData ");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAllModules() {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_GET_ALL_MODULES, new Object[] {  },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllModules ");
			e.printStackTrace();
			return null;
		}

}

	@Override
	public String getRoleById(String json) {
		String result;
		try {
			result = jdbcTemplate.queryForObject(SPUtility.FN_GET_ROLE_BY_ROLEID, new Object[] { json },
					String.class);
			return result;
		} catch (Exception e) {
			LoggerUtil.setError(this.getClass(), "Error in getAllModules ");
			e.printStackTrace();
			return null;
		}
	}
	
}
