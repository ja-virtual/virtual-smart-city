package edu.ing1.pds.vsc.client.workspaceLocation.lolo;


import java.lang.System.Logger;
import java.time.Year;

public class WorkSpace {
    String thetype;
    int themax_employee_number;
    int thearea;
    int theprice;
    int thefloor;
    int thebuilding;
    int theplace;
    int typeprice;

    public WorkSpace(int id_workspace, String type_workspace, int floor_number, int id_building) {

        typeprice = TypePrice(type_workspace, floor_number);
         
        this.theprice = BuildingPrice(id_building, typeprice, type_workspace);
        this.thetype = type_workspace;
        this.thefloor = floor_number;
        this.theplace = id_building;
        this.themax_employee_number = MaxCapacity(type_workspace);
        this.thearea = Area(type_workspace);
    }

    public int TypePrice(String type_workspace, int floor_number) {
        int price = 0;
 
         if(type_workspace == "open Space") {
             price = 2750 + 250*floor_number;
         }
         else if(type_workspace == "individuel") {
             price = 375 + 25*floor_number; 
         }
         else if(type_workspace == "salle de reunion") {
             price = 475 + 25*floor_number;
            
         } 
        return(price);
    }

    public int BuildingPrice(int id_building, int price, String type_workspace) {
        
        if(type_workspace == "open Space") {
            price = price + 500*id_building;
        }
        else if(type_workspace == "individuel") {
            price = price + 50*id_building; 
        }
        else if(type_workspace == "salle de reunion") {
            price = price + 50*id_building;
           
        }
        return(price);
    }

    public int MaxCapacity(String type_workspace) {
        int max_employee_number = 0;

         if(type_workspace == "open Space") {
            max_employee_number = 30;
         }
         else if(type_workspace == "individuel") {
            max_employee_number = 1; 
         }
         else if(type_workspace == "salle de reunion") {
            max_employee_number = 20; 
        } 
        return(max_employee_number);
    }
    public int Area(String type_workspace) {
        int area = 0;

         if(type_workspace == "open Space") {
            area = 200;
         }
         else if(type_workspace == "individuel") {
            area = 25; 
         }
         else if(type_workspace == "salle de reunion") {
            area = 50; 
        } 
        return(area);
    }


    public static void main(String[] args) {
            WorkSpace wks = new WorkSpace(1, "salle de reunion", 4, 3);
            System.out.println(wks.theprice);
            System.out.println(wks.typeprice);
            System.out.println(wks.themax_employee_number);
           
    }
}

