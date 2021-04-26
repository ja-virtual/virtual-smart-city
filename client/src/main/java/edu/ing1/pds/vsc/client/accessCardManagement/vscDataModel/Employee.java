package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

public class Employee extends Person {
	private int id_matricule ;
	private String fonction ;
	private String manager ;




	public Employee(int id_matricule, String fonction, String manager) {
		super();
		this.id_matricule = id_matricule;
		this.fonction = fonction;
		this.manager = manager;

	}



	public int getId_matricule() {
		return id_matricule;
	}



	public void setId_matricule(int id_matricule) {
		this.id_matricule = id_matricule;
	}



	public String getFonction() {
		return fonction;
	}



	public void setFonction(String fonction) {
		this.fonction = fonction;
	}



	public String getManager() {
		return manager;
	}



	public void setManager(String manager) {
		this.manager = manager;
	}





}
