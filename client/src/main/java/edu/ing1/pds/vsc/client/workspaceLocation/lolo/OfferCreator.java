package edu.ing1.pds.vsc.client.workspaceLocation.lolo;
public class OfferCreator {

    int openspace_number;
    int individual_office_number;
    int meetingroom_number;
    String type_floor;
    Offer ofr;

    public OfferCreator (int op_nbr, int io_nbr, int mr_nbr, String floor) {
        
        openspace_number = op_nbr;
        individual_office_number = io_nbr;
        meetingroom_number = mr_nbr;
        type_floor = floor;
        ofr = new Offer();
        
        try
        {
            //send the openspace number requested
            Request request=new Request();
            request.setName_request("request_workspace");
            HashMap<String,Object>param=new HashMap<String,Object>();
            param.put("requested_number",openspace_number);
            param.put("type_workspace","open Space");
            param.put("type_floor",type_floor);
            request.setData(param);
            Request response=connection.SendRequest(request);
            ofr.openspaces=(ArrayList<Map>)response.getData();

            // send the meeting room number requested
            request=new Request();
            request.setName_request("request_workspace");
            param=new HashMap<String,Object>();
            param.put("requested_number",meetingroom_number);
            param.put("type_workspace","salle de reunion");
            param.put("type_floor",type_floor);
            request.setData(param);
            response=connection.SendRequest(request);
            ofr.meetingrooms=(ArrayList<Map>)response.getData();

            //send the individual office number requested
            request=new Request();
            request.setName_request("request_workspace");
            param=new HashMap<String,Object>();
            param.put("requested_number",individual_number);
            param.put("type_workspace","individuel");
            param.put("type_floor",type_floor);
            request.setData(param);
            response=connection.SendRequest(request);
            ofr.individual=(ArrayList<Map>)response.getData();

        }catch(Exception e){
            
        }
    }
}