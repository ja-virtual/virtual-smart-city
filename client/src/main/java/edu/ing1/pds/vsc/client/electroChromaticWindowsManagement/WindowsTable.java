package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class WindowsTable {
	
	private final static Logger logger = LoggerFactory.getLogger(WindowsTable.class.getName());

	private int id_windows;
	private int temperature;
	private String light;
	private String blind;
	private String opacity;
	private int id_equipment;
	
	public int getId_windows() {
		return id_windows;
	}
	public void setId_windows(int id_windows) {
		this.id_windows = id_windows;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public String getLight() {
		return light;
	}
	public void setLight(String light) {
		this.light = light;
	}
	public String getBlind() {
		return blind;
	}
	public void setBlind(String blind) {
		this.blind = blind;
	}
	public String getOpacity() {
		return opacity;
	}
	public void setOpacity(String opacity) {
		this.opacity = opacity;
	}
	public int getId_equipment() {
		return id_equipment;
	}
	public void setId_equipment(int id_equipment) {
		this.id_equipment = id_equipment;
	}
	
	public WindowsTable(int id_windows, int temperature, String light, String blind, String opacity, int id_equipment) {
		super();
		this.id_windows = id_windows;
		this.temperature = temperature;
		this.light = light;
		this.blind = blind;
		this.opacity = opacity;
		this.id_equipment = id_equipment;
		
	}
	
	public static ArrayList<Map> ownEquipment(ClientToServer connection)
	{
		ArrayList<Map>equipment=new ArrayList<Map>();
		try
		{
			Request request=new Request();
			request.setName_request("own_equipment");
			HashMap<String,Object>param=new HashMap<String,Object>();
			//param.put("id_equipment",id_equipment);
			//param.put("type_equipment",type_equipment);
			request.setData(param);
			Request response=connection.SendRequest(request);
			equipment=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return equipment;
	}
	
	public static ArrayList<Map> ownWindows(ClientToServer connection)
	{
		ArrayList<Map>window=new ArrayList<Map>();
		//ArrayList<Map>windows=null;
		try
		{
			Request request=new Request();
			request.setName_request("own_windows");
			HashMap<String,Object>param=new HashMap<String,Object>();
			//param.put("type_equipment", type_equipment); //fenetre electro-chromatique
			request.setData(param);
			Request response=connection.SendRequest(request);
			window=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return window;
	}
	
	public static ArrayList<Map> windowsSelected(ClientToServer connection, int choice)
	{
		ArrayList<Map>selection=null;
		choice = Windows.selection;		
		try
		{
			Request request=new Request();
			request.setName_request("box_selection");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_equipment", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			selection=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return selection;
	}
	
	public static ArrayList<Map> windowsDefaultInsertion(ClientToServer connection, int choice)
	{
		ArrayList<Map>none=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("win_default_insert");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_equipment", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none;
	}
	
	
	
	public static ArrayList<Map> windowsDefaultStatus(ClientToServer connection, int choice)
	{
		ArrayList<Map>defaultStatus=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("default_status");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_equipment", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			defaultStatus=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return defaultStatus;
	}
	
	public static ArrayList<Map> windowsUpdateForLightLevelAucun(ClientToServer connection, int choice)
	{
		ArrayList<Map>none1=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("light_aucun");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none1=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none1;
	}
	
	public static ArrayList<Map> windowsUpdateForLightLevelFaible(ClientToServer connection, int choice)
	{
		ArrayList<Map>none2=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("light_faible");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none2=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none2;
	}
	
	public static ArrayList<Map> windowsUpdateForLightLevelMoyen(ClientToServer connection, int choice)
	{
		ArrayList<Map>none3=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("light_moyen");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none3=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none3;
	}
	
	public static ArrayList<Map> windowsUpdateForLightLevelFort(ClientToServer connection, int choice)
	{
		ArrayList<Map>none4=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("light_fort");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none4=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none4;
	}
	
	public static ArrayList<Map> windowsUpdateForLightLevelAutre(ClientToServer connection, int choice)
	{
		ArrayList<Map>none5=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("light_autre");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none5=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none5;
	}
	
	public static ArrayList<Map> windowsUpdateForTemperatureDegreeLessThan18(ClientToServer connection, int choice)
	{
		ArrayList<Map>none6=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("less_than_18");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none6=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none6;
	}
	
	public static ArrayList<Map> windowsUpdateForTemperatureDegree18_22(ClientToServer connection, int choice)
	{
		ArrayList<Map>none7=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("between_18_22");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none7=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none7;
	}
	
	public static ArrayList<Map> windowsUpdateForTemperatureDegree22(ClientToServer connection, int choice)
	{
		ArrayList<Map>none8=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("more_than_22");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			none8=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return none8;
	}
		
	public static ArrayList<Map> windowsUpdatedStatus(ClientToServer connection, int choice)
	{
		ArrayList<Map>updatedStatus=null;
		choice = Windows.selection;
		try
		{
			Request request=new Request();
			request.setName_request("default_status");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			updatedStatus=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return updatedStatus;
	}
	
}
