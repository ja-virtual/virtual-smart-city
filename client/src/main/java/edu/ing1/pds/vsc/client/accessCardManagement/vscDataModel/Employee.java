package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class Employee extends Person {
	private final static Logger logger = LoggerFactory.getLogger(AccessLevelModel.class.getName());

    private int id_matricule;
    private String fonction;
    private String manager;


    public Employee(int id_matricule, String fonction, String manager) {
        super();
        this.id_matricule = id_matricule;
        this.fonction = fonction;
        this.manager = manager;

    }


    public int getId_matricule() {
        return id_matricule;
    }


    public void setId_matricule(int id_matricule) {
        this.id_matricule = id_matricule;
    }


    public String getFonction() {
        return fonction;
    }


    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    public String getManager() {
        return manager;
    }


    public void setManager(String manager) {
        this.manager = manager;
    }
    
    
    @Override
	public String toString() {
		return "Employee [id_matricule=" + id_matricule + ", fonction=" + fonction + ", manager=" + manager + "]";
	}


	static public ArrayList<Map> listOfEmployees(ClientToServer connection, int id_person )
	{
		ArrayList<Map>listOfEmployees=null;
		try
		{
			Request request=new Request();
			request.setName_request("list_of_employees");
			HashMap<String,Object>param=new HashMap<String,Object>();	
			param.put("id_person",id_person);
			request.setData(param);
			Request response=connection.SendRequest(request);
			listOfEmployees=(ArrayList<Map>)response.getData();
		}catch(Exception e)
		{
			logger.info("Server is maybe occupied");
		}
		return listOfEmployees;
	}

}
