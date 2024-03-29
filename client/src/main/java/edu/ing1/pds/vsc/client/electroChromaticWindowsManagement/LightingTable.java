package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class LightingTable {
	
	private final static Logger logger = LoggerFactory.getLogger(LightingTable.class.getName());

	private int id_light;
	private String level;
	private int id_windows;
	
	public int getId_light() {
		return id_light;
	}

	public void setId_light(int id_light) {
		this.id_light = id_light;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getId_windows() {
		return id_windows;
	}

	public void setId_windows(int id_windows) {
		this.id_windows = id_windows;
	}

	public LightingTable(int id_light, String level, int id_windows) {
		super();
		this.id_light = id_light;
		this.level = level;
		this.id_windows = id_windows;
	}
	
	public static Map levelFromLighting(ClientToServer connection, int choice)
	{
		ArrayList<Map>level=new ArrayList<Map>();
		//choice = Windows.selection;
		try
		{	
			if(connection.client.isClosed())
			   connection = new ClientToServer();
			Request request=new Request();
			request.setName_request("get_light");
			HashMap<String,Object>param=new HashMap<String,Object>();
			param.put("id_windows", choice);
			request.setData(param);
			Request response=connection.SendRequest(request);
			level=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.info("Server is maybe occupied");
		}
		if(level.isEmpty())
			return null;
			else
		return level.get(0);
	}

}
