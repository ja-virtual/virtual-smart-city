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

	private DataSource data_source;
	private PrintWriter out;
	private BufferedReader in;
	private ObjectMapper mapper=new ObjectMapper();
	
	public String SendResponse(Request request) throws Exception
	{
		ConnectionDB con=data_source.takeCon();
		Connection connection=con.connection;
		String request_name=request.getName_request();
		System.out.println(request_name);
		String response_string="";
		if(request_name.equals("all_workspaces"))
		{
			Map data_loading=(Map) request.getData();
			ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM work_space where id_building="+(Integer)data_loading.get("id_building")+" and floor_number="+(Integer)data_loading.get("floor_number"));
			List<Map> workSpaces=new ArrayList<Map>();
			while(rs1.next()) {
				Map<String,Object> hm=new HashMap<String,Object>();
				hm.put("id_workspace",rs1.getString("id_workspace"));
				hm.put("type_workspace",rs1.getString("type_workspace"));
				hm.put("floor_number",rs1.getInt("floor_number"));
				hm.put("is_availabl",rs1.getBoolean("is_availabl"));
				hm.put("id_building",rs1.getInt("id_building"));
				hm.put("id_gs",rs1.getInt("id_gs"));
				workSpaces.add(hm);
			}
			rs1.close();
			Map<String,Object> response=new HashMap<String,Object>();
			response.put("name_request",request_name);
			response.put("data",workSpaces);
			 response_string=mapper.writeValueAsString(response);
		}
		else if(request_name.equals("all_buildings"))
		{
			Map data_loading=(Map) request.getData();
			ResultSet rs1 = connection.createStatement().executeQuery("SELECT * FROM building");
			List<Map> workSpaces=new ArrayList<Map>();
			while(rs1.next()) {
				Map<String,Object> hm=new HashMap<String,Object>();
				hm.put("id_building",rs1.getInt("id_building"));
				workSpaces.add(hm);
			}
			rs1.close();
			Map<String,Object> response=new HashMap<String,Object>();
			response.put("name_request",request_name);
			response.put("data",workSpaces);
			 response_string=mapper.writeValueAsString(response);
		}
		data_source.returnCon(con);
		return response_string;
	}

	public ServerToClient(DataSource ds) {
try {
	data_source=ds;
} catch (Exception e) {
	e.printStackTrace();
} 
	}
}
