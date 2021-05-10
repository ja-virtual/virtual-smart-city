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
	private int id_workspace;
	private String type_position;
	private boolean is_available;
	
	//constructor
	public Positions(int id_position, int longitude, int latitude,int id_workspace, String type_position,
			boolean is_available) {
		super();
		this.id_position = id_position;
		this.longitude = longitude;
		this.latitude = latitude;
		this.id_workspace = id_workspace;
		this.type_position = type_position;
		this.is_available = is_available;
	}


	public Positions() {
		// TODO Auto-generated constructor stub
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

	public int getId_workspace() {
		return id_workspace;
	}

	public void setId_workspace(int id_workspace) {
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
	static public ArrayList<Map> listPositions(ClientToServer connection, int id_workspace)
	{
		ArrayList<Map>positions=new ArrayList<Map>();
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
	public static ArrayList<String> possibleMapping(String type_position,String type_object)
	{
		ArrayList<String> listOfObjects=new ArrayList<String>();
		if(type_object.equals("sensor"))
		{
			switch(type_position)
		{
		case "type1":
			listOfObjects.add("detecteur incendie");
			listOfObjects.add("detecteur monoxyde");
			
			break;
		case "type2":
			listOfObjects.add("capteur regulateur energie");
			listOfObjects.add("detecteur de presence");
			break;
		case "type3":
			listOfObjects.add("detecteur de reconaissance de forme");
			break;
		}
		}
		else
		{
			switch(type_position)
			{
			case "type1":
				listOfObjects.add("ligne");
				break;
			case "type2":
				listOfObjects.add("tuyau");
				break;
			case "type3":
				listOfObjects.add("cable");
				listOfObjects.add("fenetre electro-chromatique");
				break;
			}
		}
		return listOfObjects;
	}
	
	//return the list of the positions which are available for mapping
public static ArrayList<Map >availablePositions(ClientToServer connection,int id_workspace,int id_gs)
{

	ArrayList<Map>positions=new ArrayList<Map>();
	try
	{
		Request request=new Request();
		request.setName_request("available_positions");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("is_available",true);
		param.put("id_workspace",id_workspace);
		param.put("id_gs",id_gs);
		request.setData(param);
		Request response=connection.SendRequest(request);
		positions=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	return positions;
	}

//return the specified position with  the id
public static ArrayList<Map >thePosition(ClientToServer connection,int id_position)
{

	ArrayList<Map>positions=new ArrayList<Map>();
	try
	{
		Request request=new Request();
		request.setName_request("the_position");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_workspace",id_position);
		request.setData(param);
		Request response=connection.SendRequest(request);
		positions=(ArrayList<Map>)response.getData();
	}catch(Exception e)
	{
		logger.info("Server is maybe occupied");
	}
	if(positions.isEmpty())
		return null;
	else
	return positions;
	}


static public Map infoPosition(ClientToServer connection,int id_position)
{
	ArrayList<Map>theworkspace=new ArrayList<Map>();
	try
	{
		Request request=new Request();
		request.setName_request("Info_position");
		HashMap<String,Object>param=new HashMap<String,Object>();
		param.put("id_position",id_position);
		request.setData(param);
		Request response=connection.SendRequest(request);
		theworkspace=(ArrayList<Map>)response.getData();
	
	}catch(Exception e)
	{
		e.printStackTrace();
		logger.info("Server is maybe occupied");
	}
	if(!theworkspace.isEmpty())
	return theworkspace.get(0);
	else
		return null;
}
}
