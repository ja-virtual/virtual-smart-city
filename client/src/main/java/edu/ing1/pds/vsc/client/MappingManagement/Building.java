package edu.ing1.pds.vsc.client.MappingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class Building {
	private final static Logger logger = LoggerFactory.getLogger(Building.class.getName());
	
	//attribut
	private int id_building;

	
	// constructor
	public Building(int id_building) {
		super();
		this.id_building = id_building;
	}

	
	//getter and setter
	public int getId_building() {
		return id_building;
	}

	public void setId_building(int id_building) {
		this.id_building = id_building;
	}
	
	//return  a list of all the buildings
	public static ArrayList<Map> allBuildings(ClientToServer connection)
	{
		ArrayList<Map>workspaces=new ArrayList<Map>();
		try
		{
			Request request=new Request();
			request.setName_request("all_buildings");
			HashMap<String,Object>param=new HashMap<String,Object>();
			request.setData(param);
			Request response=connection.SendRequest(request);
			workspaces=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return workspaces;
	}
}
