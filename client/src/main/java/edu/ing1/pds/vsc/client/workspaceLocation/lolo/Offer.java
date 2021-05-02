package edu.ing1.pds.vsc.client.workspaceLocation.lolo;

import java.util.ArrayList;
import java.util.Map;

public class Offer {

    double theprice;
    double theplacescore;
    double thefloorscore;
    int themax_employee_number;
    int thearea;
    double thescore;
    ArrayList<Map> openspaces;
    ArrayList<Map> meetingrooms;
    ArrayList<Map> individual;
    String floor_type;

     Offer (ArrayList<WorkSpace> offer) {
         theplacescore = PlaceScore(offer);
         thefloorscore = FloorScore(offer);
         theprice = FinalPrice(offer);
         themax_employee_number = MaxCapacity(offer);
         thearea = TotalArea(offer);
         thescore = theplacescore + thefloorscore;
    }

    public double PlaceIncreasePrice(int place1, int place2) {
        return 1 - Math.abs(place1-place2)*0.25;
    }

    public double PlaceScore(ArrayList<WorkSpace> offer) {
        
        int i = 0;
        int j = 1;
        ArrayList<Double> place_score = new ArrayList<Double>();
        while(i < offer.size()) {
            while(j < offer.size()) {
                WorkSpace wks_i = offer.get(i);
                WorkSpace wks_j = offer.get(j);
                place_score.add(PlaceIncreasePrice(wks_i.theplace, wks_j.theplace));
                j++;
            }
            i++;
            j = i+1;
        }
        double sum = 0;

        for(int k = 0; k < place_score.size(); k++)
            sum += place_score.get(k);

        double score = sum / place_score.size();
        return(score);
     }
    public double FloorScoreTwo(int floor1, int floor2) {
        return 1 - Math.abs(floor1-floor2)*0.25;
    }
    public double FloorScore(ArrayList<WorkSpace> offer) {
        
        int i = 0;
        int j = 1;
        ArrayList<Double> place_score = new ArrayList<Double>();
        while(i < offer.size()) {
            while(j < offer.size()) {
                WorkSpace wks_i = offer.get(i);
                WorkSpace wks_j = offer.get(j);
                place_score.add(FloorScoreTwo(wks_i.thefloor, wks_j.thefloor));
                j++;
            }
            i++;
            j = i+1;
        }
        double sum = 0;

        for(int k = 0; k < place_score.size(); k++)
            sum += place_score.get(k);

        double score = sum / place_score.size();
        return(score);
    }

    public double FinalPrice(ArrayList<WorkSpace> offer) {
        double sum = 0;
        for(int i=0; i < offer.size(); i++) {
            WorkSpace wks_i = offer.get(i);
            sum = sum + wks_i.theprice;
        }
    return(sum);
    }

    public int MaxCapacity(ArrayList<WorkSpace> offer) {
        int sum = 0;
        for(int i=0; i < offer.size(); i++) {
            WorkSpace wks_i = offer.get(i);
            //enlever les salles de reunion
            sum = sum + wks_i.themax_employee_number;
        }
    return(sum); 
    }
    public int TotalArea(ArrayList<WorkSpace> offer) {
        int sum = 0;
        for(int i=0; i < offer.size(); i++) {
            WorkSpace wks_i = offer.get(i);
            sum = sum + wks_i.thearea;
        }
    return(sum);
    }

    public static void main(String[] args) {
        WorkSpace wks1 = new WorkSpace(1, "salle de reunion", 4, 1);
        WorkSpace wks2 = new WorkSpace(1, "salle de reunion", 4, 1);
        WorkSpace wks3 = new WorkSpace(1, "salle de reunion", 2, 1);
        WorkSpace wks4 = new WorkSpace(1, "salle de reunion", 4, 1);
        ArrayList< WorkSpace> liste = new ArrayList<WorkSpace>();
        liste.add(wks1);
        liste.add(wks2);
        liste.add(wks3);
        liste.add(wks4);
        //System.out.println(liste);

        Offer ooof = new Offer(liste);
        System.out.println(ooof.theplacescore);
        System.out.println(ooof.thefloorscore);
        System.out.println(ooof.thescore);
        System.out.println(ooof.thearea);
        System.out.println(ooof.themax_employee_number);
        System.out.println(ooof.theprice);

    }
}
