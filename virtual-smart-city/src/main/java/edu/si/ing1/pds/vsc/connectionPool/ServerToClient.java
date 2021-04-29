package edu.si.ing1.pds.vsc.connectionPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ServerToClient {

	private Connection con=null;
	private PrintWriter out;
	private BufferedReader in;
	private ObjectMapper mapper=new ObjectMapper();
	
	public String SendResponse(Request request) throws Exception
	{
		String request_name=request.getName_request();
		System.out.println(request_name);
		String response_string="";
		if(request_name.equals("all_workspaces"))
		{
			Map data_loading=(Map) request.getData();
			ResultSet rs1 = con.createStatement().executeQuery("SELECT * FROM work_space where id_building="+(Integer)data_loading.get("id_building"));
			List<Map> workSpaces=new ArrayList<Map>();
			while(rs1.next()) {
				Map<String,Object> hm=new HashMap<String,Object>();
				hm.put("id_workspace",rs1.getInt("id_workspace"));
				hm.put("type_workspace",rs1.getString("type_workspace"));
				workSpaces.add(hm);
			}
			Map<String,Object> response=new HashMap<String,Object>();
			response.put("name_request",request_name);
			response.put("data",workSpaces);
			 response_string=mapper.writeValueAsString(response);
		}
		
		return response_string;
	}

	public ServerToClient() {
try {
	con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestHajar","postgres","admin");
} catch (Exception e) {
	e.printStackTrace();
} 
	}
}
