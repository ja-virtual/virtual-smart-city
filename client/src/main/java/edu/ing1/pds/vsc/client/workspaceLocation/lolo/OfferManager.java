package edu.ing1.pds.vsc.client.workspaceLocation.lolo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class OfferManager {

	public ArrayList<Offer> Offers;
	
	public OfferManager(ArrayList<Offer> Offers, int ask_price, int ask_area, int ask_employee_nbr){
		Offers = OfferSorter(Offers, ask_price, ask_area, ask_employee_nbr);
		this.Offers = Offers;
	}
	
    public ArrayList<Offer> OfferSorter(ArrayList<Offer> Offers, int ask_price, int ask_area, int ask_employee_nbr) {
        for (int i = 0; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            double priice = (ofr_i.theprice + (ofr_i.theprice*(0.05)));
            if (priice > ask_price){
                Offers.remove(i);
            }
            else {
                double diff = (ask_price - (ofr_i.theprice))/(ofr_i.theprice);
                double pricescore = diff*(-2);
                ofr_i.thescore = ofr_i.thescore + pricescore;
            }
        }
        for (int i = 0; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            double area = ofr_i.thearea + (ofr_i.thearea*0.1);
            if (area < ask_area){
                Offers.remove(i);
            }
            else {
                double diff = (area - ask_area)/ask_area;
                double areascore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + areascore;
            } 
        }
        for (int i=0; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            if (ofr_i.themax_employee_number > ask_employee_nbr){
                Offers.remove(i);
            }
            else {
                int diff = (ask_employee_nbr - ofr_i.themax_employee_number)/ofr_i.themax_employee_number;
                double employeescore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + employeescore;
            }
        }
        Collections.sort(Offers, Offer.OfferComparator);
       
        
    return Offers;
    }
}
    
    
    
    
    
    
       /* HashMap<Offer, Integer> hm = new HashMap<Offer, Integer>();
        for (int i; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            hm.put(ofr_i, ofr_i.thescore);
            //caster int en Integer ?
        }

        //Plus qu'a trier la HashMap par Valeur et avoir les meillers offres !*/








