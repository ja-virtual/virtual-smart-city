package edu.ing1.pds.vsc.client.workspaceLocation.lolo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;

public class OfferCreator {

    int openspace_number;
    int individual_office_number;
    int meetingroom_number;
    String type_floor;
    ArrayList<Offer> final_offers_array;

    ClientToServer connection = new ClientToServer();
    

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
    	
    	while(a < arl_op.size() || b < arl_io.size() || c < arl_mr.size()) {
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
    	}
    	return ArlOfr;
    }
    public ArrayList<WorkSpace> ResultOp() {
    	ArrayList<WorkSpace> arl_op = new ArrayList<WorkSpace>();
    	
    	try {
	    	//send the openspace number requested
	        Request request=new Request();
	        request.setName_request("request_workspace");
	        HashMap<String,Object>param=new HashMap<String,Object>();
	        param.put("type_workspace","open Space");
	        param.put("type_floor",type_floor);
	        request.setData(param);
	        Request response=connection.SendRequest(request);
	        for(Map n :(ArrayList<Map>) response.getData())
	        	arl_op.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));
    	 }catch(Exception e){
             
         }
 		return arl_op;
 	}
    public ArrayList<WorkSpace> ResultMr() {
    	ArrayList<WorkSpace> arl_mr = new ArrayList<WorkSpace>();
    	
    	try {
    		// send the meeting room number requested
    		Request request=new Request();
            request.setName_request("request_workspace");
            HashMap<String,Object> param=new HashMap<String,Object>();
            param.put("type_workspace","salle de reunion");
            param.put("type_floor",type_floor);
            request.setData(param);
            Request response=connection.SendRequest(request);
            for(Map n :(ArrayList<Map>) response.getData())
            	arl_mr.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));
    	 }catch(Exception e){
             
         }
 		return arl_mr;
 	}

    public ArrayList<WorkSpace> ResultIo() {
    	ArrayList<WorkSpace> arl_io = new ArrayList<WorkSpace>();
    	try
        {
            //send the individual office number requested
    		Request request=new Request();
            request.setName_request("request_workspace");
            HashMap<String,Object> param=new HashMap<String,Object>();
            param.put("type_workspace","individuel");
            param.put("type_floor",type_floor);
            request.setData(param);
            Request response=connection.SendRequest(request);
            for(Map n :(ArrayList<Map>) response.getData())
            	arl_io.add(new WorkSpace((Integer)n.get("id_workspace"),(String)n.get("type_workspace"),(Integer)n.get("floor_number"),(Integer)n.get("id_building")));

        }catch(Exception e){
            
        }
		return arl_io;
    }

    public static void main(String[] args) {
    	OfferCreator Offers = new OfferCreator(2,2,1,"haut");
    	 }
}