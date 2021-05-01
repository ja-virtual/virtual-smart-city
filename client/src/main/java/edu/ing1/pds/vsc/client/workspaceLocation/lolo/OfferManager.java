package edu.ing1.pds.vsc.client.workspaceLocation.lolo;
import java.util.ArrayList;
import java.util.HashMap;

public class OfferManager {

    offer first;
    offer seconde;

    public OfferManager(ArrayList Offers) {
        for (int i = 0; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            int priice = ofr_i.theprice + (ofr_i.theprice*0.05);
            if (priice > Location.price){
                Offers.remove(i);
            }
            else {
                int diff = (Location.price - ofr_i.theprice)/ofr_i.theprice;
                doucble pricescore = diff*(-2);
                ofr_i.thescore = ofr_i.thescore + pricescore;
            }
        }
        for (int i; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            int area = ofr_i.thearea + (ofr_i.thearea*0.1);
            if (area < Location.area){
                Offers.remove(i);
            }
            else {
                int diff = (area - Location.area)/Location.area;
                double areascore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + areascore;
            } 
        }
        for (int i; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            if (ofr_i.themax_employee_number > Location.employee_nbr){
                Offers.remove(i);
            }
            else {
                int diff = (Location.employee_nbr - ofr_i.themax_employee_number)/ofr_i.themax_employee_number;
                double employeescore = diff*(-1);
                ofr_i.thescore = ofr_i.thescore + employeescore;
            }
        }
        HashMap<Offer, Integer> hm = new HashMap<Offer, Integer>();
        for (int i; i < Offers.size(); i++){
            Offer ofr_i = Offers.get(i);
            hm.put(ofr_i, ofr_i.thescore);
            //caster int en Integer ?
        }

        //Plus qu'a trier la HashMap par Valeur et avoir les meillers offres !












    }








}