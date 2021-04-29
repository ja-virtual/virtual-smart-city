 package edu.ing1.pds.vsc.client;

import java.net.InetAddress;
import java.net.Socket;

public class Request {
	private String name_request;
	private Object data;
	public String getName_request() {
		return name_request;
	}
	public void setName_request(String name_request) {
		this.name_request = name_request;
	}
	public Object getData() {
		return data;
	}
	public Request() {

	}

	public void setData(Object data) {
		this.data = data;
	}
}
