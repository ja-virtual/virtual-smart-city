package edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.ing1.pds.vsc.client.ClientToServer;
import edu.ing1.pds.vsc.client.Request;
import edu.ing1.pds.vsc.client.workspaceLocation.lolo.lolo.WorkSpace;

public class Offer extends JPanel implements ActionListener{

    double theprice;
    double theplacescore;
    double thefloorscore;
    int themax_employee_number;
    int thearea;
    double thescore;
    int theopenspace_nbr;
    int themeetingroom_nbr;
    int theindividual_nbr;
    ArrayList<WorkSpace> offer;
    JLabel price;
    JLabel max_capacity;
    JLabel area;
    JLabel openspace_nbr;
    JLabel meetingroom_nbr;
    JLabel individual_nbr;
    JButton show;
    JButton rent;
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    String offer_description;
    int id_gs;
    
    

    public Offer (ArrayList<WorkSpace> offer,int gs) {
    	id_gs=gs;
        theplacescore = PlaceScore(offer);
        thefloorscore = FloorScore(offer);
        theprice = FinalPrice(offer);
        themax_employee_number = MaxCapacity(offer);
        thearea = TotalArea(offer);
        thescore = theplacescore + thefloorscore;
        this.offer = offer;
        int[] result = count_nbr();
        theopenspace_nbr = result[0];
        themeetingroom_nbr = result[1];
        theindividual_nbr = result[2];
        offer_description = w_toString();
        
        // construction JLabel
        this.setLayout(new BorderLayout());
        
        price = new JLabel("  Prix: " + String.valueOf(theprice)+",  ");
        max_capacity = new JLabel("capacit�: " + String.valueOf(themax_employee_number)+"employ�es, ");
        area = new JLabel("  Taille: " + String.valueOf(thearea)+"m2, ");
        openspace_nbr = new JLabel(String.valueOf(theopenspace_nbr)+" openspace, ");
        meetingroom_nbr = new JLabel(String.valueOf(themeetingroom_nbr)+" salle de reunion, ");
        individual_nbr = new JLabel(String.valueOf(theindividual_nbr)+" bureaux individuels");
        
        JButton show = new JButton("voir");
        show.addActionListener(this);  
        JButton rent = new JButton("Louer");
        rent.addActionListener(this);
        this.show = show;
        this.rent = rent;
        
        left.setLayout(new BoxLayout(left,BoxLayout.X_AXIS));
        right.add(show);
        right.add(rent);
        
        
        left.add(price);
        left.add(area);
        left.add(max_capacity);
        left.add(openspace_nbr );
        left.add(meetingroom_nbr);
        left.add(individual_nbr );
        
        //add JPanel to the global JPanel
        this.add(left);
        this.add(right);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      
        
        
   }
    
    public String w_toString() {
    	StringBuilder SB = new StringBuilder();
    	SB.append("Voulez vous louer l'offre compos�e des WorkSpace ci-dessous ? \n");
    	for ( WorkSpace w : offer ) {
    		SB.append("Un.e "+ String.valueOf(w.thetype) + " avec pour id \""+ String.valueOf(w.id_wokspace) + "\"  qui coute " + String.valueOf(w.theprice) + "euros " +
    				"qui fait " + String.valueOf(w.thearea) + "m2" + " dans le batiment n�" + String.valueOf(w.thebuilding) + " au " + String.valueOf(w.thefloor) + "eme etage\n");
    	}
    	return SB.toString();
    }
    
    
  
    public int[] count_nbr() {
    	
    	 //case get(0) = nbr of openspace;
    	  //case get(1) = nbr of individual;
    	  //case get(2) = nbr of meetinroom;
    	int[] result = new int[3];
    	result[0] = 0;
    	result[1] = 0;
    	result[2] = 0;
    	for (WorkSpace ws : offer) {
    		switch(ws.thetype) {
    		case("open Space"):
    			result[0] += 1;
    			break;
    		case("individuel"):
    			result[1] += 1;
    			break;
    		case("salle de reunion"):
    			result[2] += 1;
    			break;
    		}
    	}
    return result;
    }
    
    public String toString()
    {
        return "[" + thescore + " " + themax_employee_number + " " + thearea + " " + theprice + " " + theplacescore + " " + thefloorscore + "]";
    }
    
    public static Comparator<Offer> OfferComparator = new Comparator<Offer>() {

    	public int compare(Offer s1, Offer s2) {
    	   Double thescore1 = s1.thescore;
    	   Double thescore2 = s2.thescore;

    	   
    	   return thescore1.compareTo(thescore2);
    	}
    };

   public double PlaceIncreasePrice(int place1, int place2) {
       return Math.abs(place1-place2)*0.20;
   }

   public double PlaceScore(ArrayList<WorkSpace> offer) {
       
       int i = 0;
       int j = 1;
       ArrayList<Double> place_score = new ArrayList<Double>();
      while(true) {
    	  if (i >= offer.size()) {
       	   break;
    	  }
    	  while(true) {
        	   if(j >= offer.size()) {
              	   break;
           	  }
        	   WorkSpace wks_i = offer.get(i);
               WorkSpace wks_j = offer.get(j);
               place_score.add(PlaceIncreasePrice(wks_i.thebuilding, wks_j.thebuilding));
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
       return Math.abs(floor1-floor2)*0.20;
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
    
           if(wks_i.thetype.equalsIgnoreCase("individuel"))
        	   sum = sum + wks_i.themax_employee_number;
           if(wks_i.thetype.equalsIgnoreCase("open Space"))
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
   
   
   public void actionPerformed(ActionEvent event) {
		if (event.getSource() == show){
			JOptionPane.showMessageDialog(new JPanel(), offer_description, "Validez votre choix !", JOptionPane.INFORMATION_MESSAGE);
		}
		if (event.getSource() == rent){
			for ( WorkSpace w : offer ) {
				try {
					
		    		ClientToServer connection = new ClientToServer();
		    	
		    		Request request=new Request();
		            request.setName_request("set_workspace_unavailable");
		            HashMap<String,Object> param=new HashMap<String,Object>();
		            param.put("id_workspace", w.id_wokspace);
		            param.put("id_gs", id_gs);
		            request.setData(param);
		   
		            Request response=connection.SendRequest(request);
		    
		            connection.client.close();
		    	 }catch(Exception e){
		             e.printStackTrace();
		         }
			}
			
			JOptionPane.showMessageDialog(new JPanel(), "L'offre � bien �t� lou�e", "Bravo", JOptionPane.INFORMATION_MESSAGE);
		}
   }
}