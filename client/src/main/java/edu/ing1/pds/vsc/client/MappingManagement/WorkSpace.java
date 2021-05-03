package edu.ing1.pds.vsc.client.MappingManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class WorkSpace {

	private final static Logger logger = LoggerFactory.getLogger(WorkSpace.class.getName());
	private int  id_workspace;
	private String  type_workspace;
	private int floor_number;
	private boolean is_available;
	private int id_building;
	private int id_general_services;
	public int getId_workspace() {
		return id_workspace;
	}
	public void setId_workspace(int id_workspace) {
		this.id_workspace = id_workspace;
	}
	public String getType_workspace() {
		return type_workspace;
	}
	public void setType_workspace(String type_workspace) {
		this.type_workspace = type_workspace;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public boolean getIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	public int getId_building() {
		return id_building;
	}
	public void setId_building(int id_building) {
		this.id_building = id_building;
	}
	public int getId_generalServices() {
		return id_general_services;
	}
	public void setId_general_services(int id_general_services) {
		this.id_general_services = id_general_services;
	}
	public WorkSpace(int id_workspace, String workSpace_type ,int floor_number, boolean is_available, int id_building,
			int id_general_services) {
		super();
		this.id_workspace = id_workspace;
		this.type_workspace=workSpace_type;
		this.floor_number = floor_number;
		this.is_available = is_available;
		this.id_building = id_building;
		this.id_general_services = id_general_services;
	}
	public String toString()
	{
		if(type_workspace.equals("salle de reunion"))
		return "SR "+id_workspace;
		else
		return "OS "+id_workspace;
	}
	static public ArrayList<Map> listWorkSpace(ClientToServer connection,int id_building, int floor_number)
	{
		ArrayList<Map>workspaces=null;
		try
		{
			Request request=new Request();
			request.setName_request("list_workspaces");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_building",id_building);
			param.put("floor_number",floor_number);
			request.setData(param);
			Request response=connection.SendRequest(request);
			workspaces=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return workspaces;
	}
	static public Map theWorkSpace(ClientToServer connection,int id_workspace)
	{
		ArrayList<Map>theworkspace=null;
		try
		{
			Request request=new Request();
			request.setName_request("the_workspace");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_workspace",id_workspace);
			request.setData(param);
			Request response=connection.SendRequest(request);
			theworkspace=(ArrayList<Map>)response.getData();
			System.out.println(theworkspace.get(0).get("id_workspace"));
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return theworkspace.get(0);
	}
}
