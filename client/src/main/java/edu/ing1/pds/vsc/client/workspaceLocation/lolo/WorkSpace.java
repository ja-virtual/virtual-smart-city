package edu.ing1.pds.vsc.client.workspaceLocation.lolo;


import java.lang.System.Logger;
import java.time.Year;
import java.util.Comparator;

public class WorkSpace {
    String thetype;
    int themax_employee_number;
    int thearea;
    int theprice;
    int thefloor;
    int thebuilding;
    //int theplace;
    int typeprice;
    int id_wokspace;

    public WorkSpace(int id_workspace, String type_workspace, int floor_number, int id_building) {

        typeprice = TypePrice(type_workspace, floor_number);
         
        this.theprice = BuildingPrice(id_building, typeprice, type_workspace);
        this.thetype = type_workspace;
        this.thefloor = floor_number;
        this.thebuilding = id_building;
        this.themax_employee_number = MaxCapacity(type_workspace);
        this.thearea = Area(type_workspace);
        this.id_wokspace = id_workspace;
        
    }
    public static Comparator<WorkSpace> IdBuildingComparator = new Comparator<WorkSpace>() {

    	public int compare(WorkSpace s1, WorkSpace s2) {
    	   int id_building1 = s1.thebuilding;
    	   int id_building2 = s2.thebuilding;

    	   
    	   return id_building1-id_building2;
    	}
    };
    
    public int TypePrice(String type_workspace, int floor_number) {
        int price = 0;
        
        if(type_workspace.equalsIgnoreCase("open Space")) {
            price = 2750 + 250*floor_number;
        }
        else if(type_workspace.equalsIgnoreCase("individuel") ) {
            price = 375 + 25*floor_number; 
        }
        else if(type_workspace.equalsIgnoreCase("salle de reunion")) {
            price = 475 + 25*floor_number;
           
        } 
        return(price);
    }

    public int BuildingPrice(int id_building, int price, String type_workspace) {
        
        if(type_workspace.equalsIgnoreCase("open Space")){
            price = price + 500*id_building;
        }
        else if(type_workspace.equalsIgnoreCase("individuel")) {
            price = price + 50*id_building; 
        }
        else if(type_workspace.equalsIgnoreCase("salle de reunion")) {
            price = price + 50*id_building;
           
        }
        return(price);
    }

    public int MaxCapacity(String type_workspace) {
        int max_employee_number = 0;

         if(type_workspace.equalsIgnoreCase("open Space")) {
            max_employee_number = 30;
         }
         else if(type_workspace.equalsIgnoreCase("individuel")) {
            max_employee_number = 1; 
         }
         else if(type_workspace.equalsIgnoreCase("salle de reunion")) {
            max_employee_number = 20; 
        } 
        return(max_employee_number);
    }
    
    public int Area(String type_workspace) {
        int area = 0;

         if(type_workspace.equalsIgnoreCase("open Space")) {
            area = 200;
         }
         else if(type_workspace.equalsIgnoreCase("individuel")) {
            area = 25; 
         }
         else if(type_workspace.equalsIgnoreCase("salle de reunion")) {
            area = 50; 
        } 
        return(area);
    }
    
    


    @Override
	public String toString() {
		return "WorkSpace [thetype=" + thetype + ", themax_employee_number=" + themax_employee_number + ", thearea="
				+ thearea + ", theprice=" + theprice + ", thefloor=" + thefloor + ", thebuilding=" + thebuilding
				+ ", theplace=" + ", typeprice=" + typeprice + ", id_wokspace=" + id_wokspace + "]";
	}

	public static void main(String[] args) {
            WorkSpace wks = new WorkSpace(1, "salle de reunion", 4, 3);
            System.out.println(wks.theprice);
            System.out.println(wks.typeprice);
            System.out.println(wks.themax_employee_number);
           
    }
}

