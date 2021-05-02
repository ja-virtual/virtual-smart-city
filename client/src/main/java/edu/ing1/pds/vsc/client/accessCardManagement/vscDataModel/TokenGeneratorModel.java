package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class TokenGeneratorModel {
	private final static Logger logger = LoggerFactory.getLogger(TokenGeneratorModel.class.getName());

    private int id_token;

    private enum token {
        frojfoejzf4484ezaerth,
        frojfoejzf4484ezae86d,
        frojfoejzf4484ezaezef,
        frojfoejzf4484ezae862,
        frojfoejzf4484ezaeze5
    };

    private int id_accesslevel;

    public int getId_token() {
        return id_token;
    }

    public void setId_token(int id_token) {
        this.id_token = id_token;
    }

    public int getId_accesslevel() {
        return id_accesslevel;
    }

    public void setId_accesslevel(int id_accesslevel) {
        this.id_accesslevel = id_accesslevel;
    }

    static public ArrayList<Map> tokengenrators(ClientToServer connection, int id_accesslevel )
    {
        ArrayList<Map>tokengenrators=null;
        try
        {
            Request request=new Request();
            request.setName_request("general services");
            HashMap<String,Object>param=new HashMap<String,Object>();
            param.put("id_accesslevel",id_accesslevel);
            request.setData(param);
            Request response=connection.SendRequest(request);
            tokengenrators=(ArrayList<Map>)response.getData();
        }catch(Exception e)
        {
            logger.info("Server is maybe occupied");
        }
        return tokengenrators;
    }

}
