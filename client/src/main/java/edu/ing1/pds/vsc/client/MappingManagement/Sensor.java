package edu.ing1.pds.vsc.client.MappingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class Sensor {
	
	private final static Logger logger = LoggerFactory.getLogger(Sensor.class.getName());
	//attributs
 private int id_sensor;
 private String type_sensor;
 private boolean is_available;
 private boolean is_working;
 private int id_gs;
 private int id_position;
 
 
 //constructor
 public Sensor(int id_sensor, String type_sensor, boolean is_available, boolean is_working, int id_gs, int id_position) {
		super();
		this.id_sensor = id_sensor;
		this.type_sensor = type_sensor;
		this.is_available = is_available;
		this.is_working = is_working;
		this.id_gs = id_gs;
		this.id_position = id_position;
	}
 
 //getters and setters
 public int getId_sensor() {
	return id_sensor;
}
public void setId_sensor(int id_sensor) {
	this.id_sensor = id_sensor;
}
public String getType_sensor() {
	return type_sensor;
}
public void setType_sensor(String type_sensor) {
	this.type_sensor = type_sensor;
}
public boolean isIs_available() {
	return is_available;
}
public void setIs_available(boolean is_available) {
	this.is_available = is_available;
}
public boolean isIs_working() {
	return is_working;
}
public void setIs_working(boolean is_working) {
	this.is_working = is_working;
}
public int getId_gs() {
	return id_gs;
}
public void setId_gs(int id_gs) {
	this.id_gs = id_gs;
}
public int getId_position() {
	return id_position;
}
public void setId_position(int id_position) {
	this.id_position = id_position;
}

public static ArrayList<Map> listSensors(ClientToServer connection, int id_workspace)
{
	ArrayList<Map>sensors=null;
	try
	{
		Request request=new Request();
		request.setName_request("list_sensors");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("is_available",true);
		param.put("id_workspace",id_workspace);
		request.setData(param);
		Request response=connection.SendRequest(request);
		sensors=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	return sensors;
}

public static boolean mapSensor(ClientToServer connection, int id_gs,int id_position2, String type_sensor) {
	ArrayList<Map>update=null;
	try
	{
		Request request=new Request();
		request.setName_request("map_sensor");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_position",id_position2);
		param.put("type_sensor",type_sensor);
		param.put("id_gs",id_gs);
		request.setData(param);
		Request response=connection.SendRequest(request);
		update=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	return (boolean) update.get(0).get("update_done");
	
}
public static Map getSensor(ClientToServer connection, int id_position)
{
	ArrayList<Map>sensors=null;
	try
	{
		Request request=new Request();
		request.setName_request("my_sensor");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_position",id_position);
		request.setData(param);
		Request response=connection.SendRequest(request);
		sensors=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	if(sensors.isEmpty())
		return null;
		else
	return sensors.get(0);
}
}
