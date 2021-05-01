package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class AccessLevelModel {
	private final static Logger logger = LoggerFactory.getLogger(AccessLevelModel.class.getName());

	private int id_accessLevel;
	private int id_equipement;
	private int id_workspace;


	public AccessLevelModel(int id_accessLevel, int id_equipement, int id_workspace) {
		super();
		this.id_accessLevel = id_accessLevel;
		this.id_equipement = id_equipement;
		this.id_workspace = id_workspace;
	}

	public int getId_accessLevel() {
		return id_accessLevel;
	}

	public void setId_accessLevel(int id_accessLevel) {
		this.id_accessLevel = id_accessLevel;
	}

	public int getId_equipement() {
		return id_equipement;
	}

	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}

	public int getId_workspace() {
		return id_workspace;
	}

	public void setId_workspace(int id_workspace) {
		this.id_workspace = id_workspace;
	}

	static public ArrayList<Map> listOfAccessLevels(ClientToServer connection, int id_equipement, int id_workspace)
	{
		ArrayList<Map>accessLevels=null;
		try
		{
			Request request=new Request();
			request.setName_request("list_of_access_levels");
			HashMap<String,Object>param=new HashMap<String,Object>();	
			param.put("id_equipement",id_equipement);
			param.put("id_workspace",id_workspace);
			request.setData(param);
			Request response=connection.SendRequest(request);
			accessLevels=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return accessLevels;
	}

}
