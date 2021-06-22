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
    
	public Double nbreEquipment(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("count_equipment");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			nbList = (ArrayList<Map>) response.getData();
			System.out.println("nbList----" + nbList.size());
			if (nbList != null && !nbList.isEmpty()) {
				Map<String, Object> map = nbList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("number_equipment");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error count equipment");
		}
		return null;
	}

	public Double nbConsur(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("count_sensors");
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
			logger.error("Error count sensors");
		}
		return null;
	}

	public Double degre(ClientToServer connection, int id_gs) {
		ArrayList<Map> degreeList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("degre_tempurateur");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			degreeList = (ArrayList<Map>) response.getData();
			System.out.println("nbList----" + degreeList.size());
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

	public Double level(ClientToServer connection, int id_gs) {
		ArrayList<Map> levelList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("level_lighting");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			levelList = (ArrayList<Map>) response.getData();
			System.out.println("nbList----" + levelList.size());
			if (levelList != null && !levelList.isEmpty()) {
				Map<String, Object> map = levelList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("level");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error level lighting");
		}
		return null;
	}
	
	public Double nbreWorkspaceAvailable(ClientToServer connection, int id_gs) {
		ArrayList<Map> nbList = new ArrayList<Map>();
		try {
			Request request = new Request();
			request.setName_request("nbre_workspace_available");
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id_gs", id_gs);
			request.setData(param);
			Request response = connection.SendRequest(request);
			nbList = (ArrayList<Map>) response.getData();
			if (nbList != null && !nbList.isEmpty()) {
				Map<String, Object> map = nbList.get(0);

				if (map != null && !map.isEmpty()) {
					return (Double) map.get("nbWs");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error number workspace available");
		}
		return null;
	}
}