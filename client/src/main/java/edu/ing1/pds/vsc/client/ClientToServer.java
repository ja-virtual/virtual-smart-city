package edu.ing1.pds.vsc.client;

import java.io.*;
import java.net.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientToServer {

	public Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private ObjectMapper mapper=new ObjectMapper();

	
	public Request SendRequest(Request req) throws Exception
	{
		String request=mapper.writeValueAsString(req);
		out=new PrintWriter(client.getOutputStream(),true);
		out.println(request);
		in=new BufferedReader(new InputStreamReader(client.getInputStream()));
		String response_string=in.readLine();
		Request response=mapper.readValue(response_string,Request.class);
		return response;
	}

	public ClientToServer() {
try {
String serverAdress="172.31.254.94"; //InetAddress.getLocalHost();
	client=new Socket(serverAdress,1099);
} catch (Exception e) {

	e.printStackTrace();
}
	}
}
