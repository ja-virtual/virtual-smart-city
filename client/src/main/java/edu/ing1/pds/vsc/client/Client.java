package edu.ing1.pds.vsc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client extends Thread
{
	public void run()
	{	try
		{
		
		InetAddress host = InetAddress.getLocalHost();
	      
        String[] operation=new String[] {"add","update","delete","read"};
       ClientConfig config=new ClientConfig();
       Socket   client_test=new Socket(host.getHostName(),config.getConfig().getListenPort());
		int i=1;
		while(i<5)
		{
		PrintWriter out = new PrintWriter(client_test.getOutputStream(),true);
		String operation_name=operation[new Random().nextInt(4)];
		out.println(operation_name);
		System.out.println("client  number "+i+"wants an /a "+operation_name+ "'s operation\n");
		BufferedReader in = new BufferedReader(new InputStreamReader(client_test.getInputStream()));
		String msg=in.readLine();
		System.out.println("Server's response\n"+msg+"\n");
		i++;
		}
		}catch (Exception ex)
	{
		logger.error("erreur coté client");
	}
	}
    private final static Logger logger = LoggerFactory.getLogger(Client.class.getName());
	public static void main(String[] args) throws Exception {

		new Client().start();


	}

}
