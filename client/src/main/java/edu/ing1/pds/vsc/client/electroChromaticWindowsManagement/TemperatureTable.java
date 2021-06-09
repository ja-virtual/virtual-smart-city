package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class TemperatureTable {
	
	private final static Logger logger = LoggerFactory.getLogger(TemperatureTable.class.getName());

	private int id_temperature;
	private int degree;
	private int id_windows;
	
	public int getId_temperature() {
		return id_temperature;
	}
	public void setId_temperature(int id_temperature) {
		this.id_temperature = id_temperature;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public int getId_windows() {
		return id_windows;
	}
	public void setId_windows(int id_windows) {
		this.id_windows = id_windows;
	}
	
	public TemperatureTable(int id_temperature, int degree, int id_windows) {
		super();
		this.id_temperature = id_temperature;
		this.degree = degree;
		this.id_windows = id_windows;
	}
	
//	public static boolean temperatureDefaultInsertion(ClientToServer connection, int id_gs, int id_eq)
//	{
//		ArrayList<Map>none1=new ArrayList<Map>();
//		//choice = Windows.selection;
//		try
//		{
//			Request request=new Request();
//			request.setName_request("temp_default_insert");
//			HashMap<String,Object>param=new HashMap<String,Object>();
//			param.put("id_windows", id_eq);
//			request.setData(param);
//			Request response=connection.SendRequest(request);
//			none1=(ArrayList<Map>)response.getData();
//		}catch(Exception e)
//		{
//			logger.info("Server is maybe occupied");
//		}
//		if(!none1.isEmpty()) 
//			return (boolean) none1.get(0).get("update_done");
//			else
//		return false;
//		}
	
	public static ArrayList<Map> degreeFromTemperature(ClientToServer connection, int choice)
	{
		ArrayList<Map>degree=new ArrayList<Map>();
		//choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("got_degree");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			degree=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return degree;
	}

}
