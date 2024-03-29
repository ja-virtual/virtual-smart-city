package edu.ing1.pds.vsc.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class General_Services {

	private final static Logger logger = LoggerFactory.getLogger(General_Services.class.getName());
	//attributs
	private int id_generalservices;
	private String company_name;
	
	//constructor
	public General_Services(int id_generalservices, String company_name) {
		super();
		this.id_generalservices = id_generalservices;
		this.company_name = company_name;
	}
	
	public General_Services() {
		
	}

	//getters and setters
	public int getId_generalservices() {
		return id_generalservices;
	}
	public void setId_generalservices(int id_generalservices) {
		this.id_generalservices = id_generalservices;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public static ArrayList<Map> All_GeneralServices(ClientToServer connection)
	{
		ArrayList<Map> general_services=new ArrayList<Map>();
		try
		{
			Request request=new Request();
			request.setName_request("all_generalServices");
			HashMap<String,Object>param=new HashMap<String,Object>();
			request.setData(param);
			Request response=connection.SendRequest(request);
			general_services=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return general_services;
	}
}
