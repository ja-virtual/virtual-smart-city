package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class GeneralServices {
	
	private final static Logger logger = LoggerFactory.getLogger(GeneralServices.class.getName());

    private int id_generalServices;

    public GeneralServices(int id_generalServices) {
        super();
        this.id_generalServices = id_generalServices;
    }

    public int getId_generalServices() {
        return id_generalServices;
    }

    public void setId_generalServices(int id_generalServices) {
        this.id_generalServices = id_generalServices;
    }

    static public ArrayList<Map> generalServices(ClientToServer connection, int id_company )
    {
        ArrayList<Map>generalServices=null;
        try
        {
            Request request=new Request();
            request.setName_request("general services");
            HashMap<String,Object>param=new HashMap<String,Object>();
            param.put("id_company",id_company);
            request.setData(param);
            Request response=connection.SendRequest(request);
            generalServices=(ArrayList<Map>)response.getData();
        }catch(Exception e)
        {
            logger.info("Server is maybe occupied");
        }
        return generalServices;
    }

	public String getCompany_name() {
		// TODO Auto-generated method stub
		return null;
	}

}
