package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class EmpowermentModel {
	
	private final static Logger logger = LoggerFactory.getLogger(EmpowermentModel.class.getName());

    private int id_empowerment;

    private enum type_empowerment {
        IT,
        Security
    }

    ;
    private int id_equipement;


    public EmpowermentModel(int id_empowerment, int id_equipement) {
        super();
        this.id_empowerment = id_empowerment;
        this.id_equipement = id_equipement;
    }

    public int getId_empowerment() {
        return id_empowerment;
    }

    public void setId_empowerment(int id_empowerment) {
        this.id_empowerment = id_empowerment;
    }

    public int getId_equipement() {
        return id_equipement;
    }

    public void setId_equipement(int id_equipement) {
        this.id_equipement = id_equipement;
    }

    static public ArrayList<Map> allEmpowerments(ClientToServer connection, int id_empowerment )
    {
        ArrayList<Map>allEmpowerments=null;
        try
        {
            Request request=new Request();
            request.setName_request("all empowerments");
            HashMap<String,Object>param=new HashMap<String,Object>();
            param.put("id_empowerment",id_empowerment);
            request.setData(param);
            Request response=connection.SendRequest(request);
            allEmpowerments=(ArrayList<Map>)response.getData();
        }catch(Exception e)
        {
            logger.info("Server is maybe occupied");
        }
        return allEmpowerments;
    }

    }
