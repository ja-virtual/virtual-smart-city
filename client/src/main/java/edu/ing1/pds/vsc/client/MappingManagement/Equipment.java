package edu.ing1.pds.vsc.client.MappingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class Equipment {
	
	private final static Logger logger = LoggerFactory.getLogger(Equipment.class.getName());
	//attributs
 private int id_equipment;
 private String type_equipment;
 private boolean is_available;
 private boolean is_working;
 private int id_gs;
 private int id_position;
 
 
 //constructor
 public Equipment(int id_equipment, String type_equip, boolean is_available, boolean is_working, int id_gs, int id_position) {
		super();
		this.id_equipment = id_equipment;
		this.type_equipment = type_equip;
		this.is_available = is_available;
		this.is_working = is_working;
		this.id_gs = id_gs;
		this.id_position = id_position;
	}
 
 //getters and setters
 public int getId_equipment() {
	return id_equipment;
}
public void setId_equipment(int id_equipment) {
	this.id_equipment = id_equipment;
}
public String getType_equipment() {
	return type_equipment;
}
public void setType_equipment(String type_equipment) {
	this.type_equipment = type_equipment;
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

public static ArrayList<Map> listEquipments(ClientToServer connection, int id_workspace)
{
	ArrayList<Map>equipments=null;
	try
	{
		Request request=new Request();
		request.setName_request("list_equipments");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("is_available",true);
		param.put("id_workspace",id_workspace);
		request.setData(param);
		Request response=connection.SendRequest(request);
		equipments=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	return equipments;
}

public static boolean mapEquipment(ClientToServer connection,int id_gs,int id_position2, String type_equipment) {
	
	ArrayList<Map>update=null;
	try
	{
		Request request=new Request();
		request.setName_request("map_equipment");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_position",id_position2);
		param.put("type_equipment",type_equipment);
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
public static Map getEquipment(ClientToServer connection, int id_position)
{
	ArrayList<Map>equipment=null;
	try
	{
		Request request=new Request();
		request.setName_request("my_equipment");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_position",id_position);
		request.setData(param);
		Request response=connection.SendRequest(request);
		equipment=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	if(equipment.isEmpty())
		return null;
		else
	return equipment.get(0);
}
}
