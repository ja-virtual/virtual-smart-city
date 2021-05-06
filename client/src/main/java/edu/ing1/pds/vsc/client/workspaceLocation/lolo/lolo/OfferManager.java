package edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OfferManager {

	public ArrayList<Offer> offfers;
	
	public OfferManager(ArrayList<Offer> offers, int ask_price, int ask_area, int ask_employee_nbr){
		offers = OfferSorter(offers, ask_price, ask_area, ask_employee_nbr);
		this.offfers = offers;
	}
	
    public ArrayList<Offer> OfferSorter(ArrayList<Offer> offers, int ask_price, int ask_area, int ask_employee_nbr) {
        for (int i = 0; i < offers.size(); i++){
            Offer ofr_i = offers.get(i);
            double priice = (ofr_i.theprice + (ofr_i.theprice*(0.05)));
            if (priice > ask_price){
            	System.out.println("if price");
                offers.remove(i);
                i-=1;
            }
            else {
                double diff = (ask_price - (ofr_i.theprice))/(ofr_i.theprice);
                double pricescore = diff*(-2);
                ofr_i.thescore = ofr_i.thescore + pricescore;
                System.out.println("else price");
            }
        }
        System.out.println("offers.size() " + offers.size());
        if(!offers.isEmpty())
        {
        for (int i = 0; i < offers.size(); i++){
            Offer ofr_i = offers.get(i);
            double area = ofr_i.thearea*1.1;
            
            if (area <= ask_area){
            	 System.out.println("if area");
                offers.remove(i);
                i-=1;
            }
            
            else {
                double diff = (area - ask_area)/ask_area;
                double areascore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + areascore;
                System.out.println("else area ");
            } 
        }  
        for (int i=0; i < offers.size(); i++){
            Offer ofr_i = offers.get(i);
            if (ofr_i.themax_employee_number < ask_employee_nbr){
            	System.out.println("if employee");
            	offers.remove(i);
                i-=1;
                
            }
            else {
                int diff = (ask_employee_nbr - ofr_i.themax_employee_number)/ofr_i.themax_employee_number;
                double employeescore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + employeescore;
                System.out.println("themax_employee_number " + ofr_i.themax_employee_number);
                System.out.println("else employee");
            }
        }
        Collections.sort(offers, Offer.OfferComparator);
        return offers;
        }
        else
        	return new ArrayList<Offer>();
        
  
    }
}