/*package edu.ing1.pds.vsc.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionServer {


    private Socket client;
    private ObjectInputStream in2 =null;
    private BufferedReader in;
    private PrintWriter out;
    public ConnectionServer()
    {
        try {
            client=new Socket(InetAddress.getLocalHost(),1099);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public update_person(int id)
    {
        try {
            out = new PrintWriter(client.getOutputStream(),true);
            System.out.println("update personne set ");
            out.println("select * from building");
            System.out.println("test1");
            // in = new BufferedReader(new InputStreamReader(client_test.getInputStream()));

            InputStream inputStream = client.getInputStream();
            in2 = new ObjectInputStream(inputStream);
            System.out.println("one");
            Object b=(Object) in2.readObject();
            if(b==null)
                System.out.println("well....");

        } catch (Exception e) {
            System.out.println("Server is maybe occupied!");
        }
        //return b;
        return null;
    }

    public String delete_person(int id)
    {
        return null;
    }

    public String create_person(int id)
    {
        return null;
    }

    public String read_person(int id)
    {
        return null;
    }

    public String all_person()
    {
        return null;
    }
}*/