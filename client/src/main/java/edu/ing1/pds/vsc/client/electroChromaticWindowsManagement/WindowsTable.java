package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.General_Services;
import edu.ing1.pds.vsc.client.Request;

public class WindowsTable {
	
	private final static Logger logger = LoggerFactory.getLogger(WindowsTable.class.getName());

	private int id_windows;
	private int temperature;
	private String light;
	private String blind;
	private String opacity;
	private int id_equipment;
	General_Services company=null;
	
	
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
	
	public static ArrayList<Map> ownEquipment(ClientToServer connection, int id_gs)
	{
		ArrayList<Map>equipment=new ArrayList<Map>();
		//id_gs = company.
		try
		{
			Request request=new Request();
			request.setName_request("own_equipment");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_gs",id_gs);
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
	
	public static ArrayList<Map> ownWindows(ClientToServer connection, int id_gs)
	{
		ArrayList<Map>window=new ArrayList<Map>();
		//ArrayList<Map>windows=null;
		try
		{
			Request request=new Request();
			request.setName_request("own_windows");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_gs",id_gs);
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
		ArrayList<Map>selection=new ArrayList<Map>();
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
	
	public static int windowsDefaultInsertion(ClientToServer connection, int choice)
	{
		ArrayList<Map>none=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none!=null) 
			return (int) none.get(0).get("insertion_done");
			else
		return (int)none.get(0).get("not_done");
		
	}
	
	
	
	public static ArrayList<Map> windowsDefaultStatus(ClientToServer connection, int choice)
	{
		ArrayList<Map>defaultStatus=new ArrayList<Map>();
		//Windows.selection = choice ;
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
	
	public static int windowsUpdateForLightLevelAucun(ClientToServer connection, int choice)
	{
		ArrayList<Map>none1=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none1!=null) 
			return (int) none1.get(0).get("update_done");
			else
		return (int)none1.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForLightLevelFaible(ClientToServer connection, int choice)
	{
		ArrayList<Map>none2=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none2!=null) 
			return (int) none2.get(0).get("update_done");
			else
		return (int)none2.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForLightLevelMoyen(ClientToServer connection, int choice)
	{
		ArrayList<Map>none3=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none3!=null) 
			return (int) none3.get(0).get("update_done");
			else
		return (int)none3.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForLightLevelFort(ClientToServer connection, int choice)
	{
		ArrayList<Map>none4=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none4!=null) 
			return (int) none4.get(0).get("update_done");
			else
		return (int)none4.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForLightLevelAutre(ClientToServer connection, int choice)
	{
		ArrayList<Map>none5=new ArrayList<Map>();
		//choice = Windows.selection;
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
		if(none5!=null) 
			return (int) none5.get(0).get("update_done");
			else
		return (int)none5.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForTemperatureDegreeLessThan18(ClientToServer connection, int choice)
	{
		ArrayList<Map>none6=new ArrayList<Map>();
		//Windows.selection = choice;
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
		if(none6!=null) 
			return (int) none6.get(0).get("update_done");
			else
		return (int)none6.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForTemperatureDegree18_22(ClientToServer connection, int choice)
	{
		ArrayList<Map>none7=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none7!=null) 
			return (int) none7.get(0).get("update_done");
			else
		return (int)none7.get(0).get("not_done");
		
	}
	
	public static int windowsUpdateForTemperatureDegree22(ClientToServer connection, int choice)
	{
		ArrayList<Map>none8=new ArrayList<Map>();
		//Windows.selection = choice ;
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
		if(none8!=null) 
			return (int) none8.get(0).get("update_done");
			else
		return (int)none8.get(0).get("not_done");
		
	}
	
	public static ArrayList<Map> windowsUpdatedStatus(ClientToServer connection, int choice)
	{
		ArrayList<Map>updatedStatus=new ArrayList<Map>();
		//choice = Windows.selection;
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
