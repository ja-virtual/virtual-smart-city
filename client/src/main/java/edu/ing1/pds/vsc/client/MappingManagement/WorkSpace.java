package edu.ing1.pds.vsc.client.MappingManagement;

public class WorkSpace {
	  private String  id_workspace;
	  private String  type_workspace;
	  private int floor_number;
	  private boolean is_available;
	  private int id_building;
	  private int id_general_services;
	public String getId_workspace() {
		return id_workspace;
	}
	public void setId_workspace(String id_workspace) {
		this.id_workspace = id_workspace;
	}
	public String getType_workspace() {
		return type_workspace;
	}
	public void setType_workspace(String type_workspace) {
		this.type_workspace = type_workspace;
	}
	public int getFloor_number() {
		return floor_number;
	}
	public void setFloor_number(int floor_number) {
		this.floor_number = floor_number;
	}
	public boolean getIs_available() {
		return is_available;
	}
	public void setIs_available(boolean is_available) {
		this.is_available = is_available;
	}
	public int getId_building() {
		return id_building;
	}
	public void setId_building(int id_building) {
		this.id_building = id_building;
	}
	public int getId_generalServices() {
		return id_general_services;
	}
	public void setId_general_services(int id_general_services) {
		this.id_general_services = id_general_services;
	}
	public WorkSpace(String id_workspace, String workSpace_type ,int floor_number, boolean is_available, int id_building,
			int id_general_services) {
		super();
		this.id_workspace = id_workspace;
	this.type_workspace=workSpace_type;
		this.floor_number = floor_number;
		this.is_available = is_available;
		this.id_building = id_building;
		this.id_general_services = id_general_services;
	}
	public String toString()
	{
		return type_workspace+" "+id_workspace;
	}

}
