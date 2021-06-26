package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;
import edu.ing1.pds.vsc.client.MappingManagement.WorkSpace;

import java.sql.Connection;
import java.sql.ResultSet;

public class AnalyserDaoImpl implements AnalyserDao {
	

	private final static Logger logger = LoggerFactory.getLogger(WorkSpace.class.getName());
    
	public Double nbEquipment(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("number_equipment_req");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			nbList = (ArrayList<Map>) response.getData();
			if (nbList != null && !nbList.isEmpty()) {
				Map<String, Object> map = nbList.get(0);
				if (map != null && !map.isEmpty()) {
					return (Double) map.get("number_equipment");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error number equipment");
		}
		return null;
	}

	public Double nbSensor(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("number_sensor_req");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			nbList = (ArrayList<Map>) response.getData();
			if (nbList != null && !nbList.isEmpty()) {
				Map<String, Object> map = nbList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("number_sensor");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error number sensors");
		}
		return null;
	}

	public Double degre(ClientToServer connection, int id_gs) {
		ArrayList<Map> degreeList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("degre_tempurateur_req");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			degreeList = (ArrayList<Map>) response.getData();
			if (degreeList != null && !degreeList.isEmpty()) {
				Map<String, Object> map = degreeList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("degree");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error degree of temperature");
		}
		return null;
	}

	public Double power(ClientToServer connection, int id_gs) {
		ArrayList<Map> powerList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("power_consumption_req");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			powerList = (ArrayList<Map>) response.getData();
			if (powerList != null && !powerList.isEmpty()) {
				Map<String, Object> map = powerList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("power_consumption");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error power consumption");
		}
		return null;
	}
	
	public Double nbWorkspaceAvailable(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("nb_workspace_available_req");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			nbList = (ArrayList<Map>) response.getData();
			if (nbList != null && !nbList.isEmpty()) {
				Map<String, Object> map = nbList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("nb_workspace_available");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error number workspace available");
		}
		return null;
	}
}