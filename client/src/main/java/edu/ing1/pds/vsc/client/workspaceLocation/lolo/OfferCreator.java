package edu.ing1.pds.vsc.client.workspaceLocation.lolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class OfferCreator {

    public int openspace_number;
    public int individual_office_number;
    public int meetingroom_number;
    String type_floor;
    ArrayList<Offer> final_offers_array;

    
    

    public OfferCreator (int op_nbr, int io_nbr, int mr_nbr, String floor) {
        
        openspace_number = op_nbr;
        individual_office_number = io_nbr;
        meetingroom_number = mr_nbr;
        type_floor = floor;
        final_offers_array = ArlOfr(OfferFromResult(ResultOp(),ResultMr(),ResultIo()));
        		
    }
    
    public ArrayList<Offer> ArlOfr (ArrayList<ArrayList<WorkSpace>> ofr) {
    	int i = 0;
    	ArrayList<Offer> offers = new ArrayList<Offer>();
    	while(i < ofr.size()) {
    		Offer arlfr = new Offer(ofr.get(i));
    		offers.add(arlfr);
    		i++;
    	}
		return offers;	
    }
  
    public ArrayList<ArrayList<WorkSpace>> OfferFromResult(ArrayList<WorkSpace> arl_op,ArrayList<WorkSpace> arl_mr, ArrayList<WorkSpace> arl_io) {
    	ArrayList<ArrayList<WorkSpace>> ArlOfr = new ArrayList<ArrayList<WorkSpace>>();   
    	Collections.sort(arl_op, WorkSpace.IdBuildingComparator);
    	Collections.sort(arl_io, WorkSpace.IdBuildingComparator);
    	Collections.sort(arl_mr, WorkSpace.IdBuildingComparator);
    	
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	while(true) {
    		if((arl_op.size() <= a + openspace_number) || arl_io.size() <= b + individual_office_number || arl_mr.size() <= c + meetingroom_number) {
    			//System.out.println("skrt");
    			break;
    		}
    		
    		List<WorkSpace> list = new ArrayList<>();
    		//System.out.println(openspace_number);
        	for(int i = 0; i < openspace_number; i++) {
        		list.add(arl_op.get(a));
        		++a;
        		//System.out.println(arl_op.get(a).toString());
        		//System.out.println("arl_op is null : " + arl_op == null);
        		
        	}
        	for(int i = 0; i < individual_office_number; i++) {
        		list.add(arl_io.get(b));
        		++b;
        		//System.out.println(arl_io == null);
        	}
        	for(int i = 0; i< meetingroom_number; i++) {
        		list.add(arl_mr.get(c));
        		++c;
        		//System.out.println("arl_mr is null : " + arl_mr == null);
        	}
        	
        	ArlOfr.add((ArrayList<WorkSpace>) list);
    	}
    	//System.out.println("ArlOfr" + ArlOfr);
 

    	
//    	int a = 0;
//    	int b = 0;
//    	int c = 0;
//    	
//    	while(true) {
//    		if(a < arl_op.size() || b < arl_io.size() || c < arl_mr.size())
//    			break;
//    		ArrayList<WorkSpace> oneArl = new ArrayList<WorkSpace>();
//    		int i = 0;
//    		while(true) {
//    			if(i < openspace_number)
//    				break;
//    			oneArl.add(arl_op.get(i));
//    			i++;
//    			a++;
//    			
//    		}
//    		int j = 0;
//    		while(true) {
//    			if(j < individual_office_number)
//    				break;
//    			oneArl.add(arl_io.get(j));
//    			j++;
//    			b++;
//    			
//    		}
//    		int k = 0;
//    		while(true) {
//    			if(k < meetingroom_number)
//    				break;
//    			oneArl.add(arl_mr.get(k));
//    			k++;
//    			c++;
//    		}
//    		ArlOfr.add(oneArl);
//    	}
    	
    	
    	
    	
    	
    	
    	/*while(a < arl_op.size() || b < arl_io.size() || c < arl_mr.size()) {
    		ArrayList<WorkSpace> oneArl = new ArrayList<WorkSpace>();
    		int i = 0;
    		while(i < openspace_number) {
    			oneArl.add(arl_op.get(i));
    			i++;
    			a++;
    		}
    		int j = 0;
    		while(j < individual_office_number) {
    			oneArl.add(arl_io.get(j));
    			j++;
    			b++;
    		}
    		int k = 0;
    		while(k < meetingroom_number) {
    			oneArl.add(arl_mr.get(k));
    			k++;
    			c++;
    		}
    		ArlOfr.add(oneArl);
    	}*/
    	return ArlOfr;
    }
    public ArrayList<WorkSpace> ResultOp() {
    	ArrayList<WorkSpace> arl_op = new ArrayList<WorkSpace>();
    	
    	try {
    		ClientToServer connection = new ClientToServer();
	        Request request=new Request();
	        request.setName_request("request_workspace");
	        HashMap<String,Object>param=new HashMap<String,Object>();
	        param.put("type_workspace","open Space");
	        param.put("type_floor",type_floor);
	        request.setData(param);
	        Request response=connection.SendRequest(request);
	        for(Map n :(ArrayList<Map>) response.getData())
	        	arl_op.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));
	        
	        connection.client.close();
    	 }catch(Exception e){
             
         }
    	//System.out.println(arl_op.get(1).toString());
 		return arl_op;	
 	}
    
    
    
    public ArrayList<WorkSpace> ResultMr() {
    	ArrayList<WorkSpace> arl_mr = new ArrayList<WorkSpace>();
    	
    	try {
    		ClientToServer connection = new ClientToServer();
    		Request request=new Request();
            request.setName_request("request_workspace");
            HashMap<String,Object> param=new HashMap<String,Object>();
            param.put("type_workspace","salle de reunion");
            param.put("type_floor",type_floor);
            request.setData(param);
            Request response=connection.SendRequest(request);
            for(Map n :(ArrayList<Map>) response.getData())
            	arl_mr.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));
            
            connection.client.close();
    	 }catch(Exception e){
             e.printStackTrace();
         }
 		return arl_mr;
 	}

    public ArrayList<WorkSpace> ResultIo() {
    	ArrayList<WorkSpace> arl_io = new ArrayList<WorkSpace>();
    	try
        {
    		ClientToServer connection = new ClientToServer();
    		Request request=new Request();
            request.setName_request("request_workspace");
            HashMap<String,Object> param=new HashMap<String,Object>();
            param.put("type_workspace","individuel");
            param.put("type_floor",type_floor);
            request.setData(param);
            Request response=connection.SendRequest(request);
            for(Map n :(ArrayList<Map>) response.getData())
            	arl_io.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));
            
            connection.client.close();

        }catch(Exception e){
            
        }
		return arl_io;
    }

    public static void main(String[] args) {
    	OfferCreator Offers = new OfferCreator(2,2,1,"haut");
    	 }
}