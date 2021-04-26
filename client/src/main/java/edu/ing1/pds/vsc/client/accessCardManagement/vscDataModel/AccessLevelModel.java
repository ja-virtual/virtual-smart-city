package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

public class AccessLevelModel {

	private int id_accessLevel;
	private int id_equipement;
	private int id_workspace;


	public AccessLevelModel(int id_accessLevel, int id_equipement, int id_workspace) {
		super();
		this.id_accessLevel = id_accessLevel;
		this.id_equipement = id_equipement;
		this.id_workspace = id_workspace;
	}

	public int getId_accessLevel() {
		return id_accessLevel;
	}
	public void setId_accessLevel(int id_accessLevel) {
		this.id_accessLevel = id_accessLevel;
	}
	public int getId_equipement() {
		return id_equipement;
	}
	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}
	public int getId_workspace() {
		return id_workspace;
	}
	public void setId_workspace(int id_workspace) {
		this.id_workspace = id_workspace;
	}


}
