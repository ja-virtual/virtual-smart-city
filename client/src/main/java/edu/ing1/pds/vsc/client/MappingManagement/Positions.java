package edu.ing1.pds.vsc.client.MappingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class Positions {
	
	private final static Logger logger = LoggerFactory.getLogger(Positions.class.getName());
	
	//attributs
	private int id_position;
	private int longitude;
	private int latitude;
	private String id_workspace;
	private String type_position;
	private boolean is_available;
	
	//constructor
	public Positions(int id_position, int longitude, int latitude, String id_workspace, String type_position,
			boolean is_available) {
		super();
		this.id_position = id_position;
		this.longitude = longitude;
		this.latitude = latitude;
		this.id_workspace = id_workspace;
		this.type_position = type_position;
		this.is_available = is_available;
	}


	//getters and setters
	public int getId_position() {
		return id_position;
	}

	public void setId_position(int id_position) {
		this.id_position = id_position;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public String getId_workspace() {
		return id_workspace;
	}

	public void setId_workspace(String id_workspace) {
		this.id_workspace = id_workspace;
	}

	public String getType_position() {
		return type_position;
	}

	public void setType_position(String type_position) {
		this.type_position = type_position;
	}
	public boolean isIs_available() {
		return is_available;
	}

	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}

	
	//return the list of positions existing in the workspace with the id mentioned in the parameters
	static public ArrayList<Map> listPositions(ClientToServer connection, String id_workspace)
	{
		ArrayList<Map>positions=null;
		try
		{
			Request request=new Request();
			request.setName_request("list_positions");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_workspace",id_workspace);
			request.setData(param);
			Request response=connection.SendRequest(request);
			positions=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return positions;
	}
	
	//return the types of the object that could be mapped on the specified type of position
	public static ArrayList<String> possibleMapping(String type_position)
	{
		ArrayList<String> listOfObjects=new ArrayList<String>();
		switch(type_position)
		{
		case "type1":
			listOfObjects.add("lignes");
			listOfObjects.add("detecteur incendie");
			listOfObjects.add("detecteur monoxyde");
			
			break;
		case "type2":
			listOfObjects.add("tuyaux");
			listOfObjects.add("capteur r�gulateur energie");
			listOfObjects.add("detecteur de presence infra rouge");
			break;
		case "type3":
			listOfObjects.add("c�bles");
			listOfObjects.add("Fenetre electro-chromatique");
			listOfObjects.add("detecteur de reconaissance de forme");
			break;
		}
		return listOfObjects;
	}

}