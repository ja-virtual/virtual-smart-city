package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

public class EmpowermentModel {

	private int id_empowerment ;
	private enum type_empowerment {
		IT,
		Security
	};
	private int id_equipement ;

	
	public EmpowermentModel(int id_empowerment, int id_equipement) {
		super();
		this.id_empowerment = id_empowerment;
		this.id_equipement = id_equipement;
	}

	public int getId_empowerment() {
		return id_empowerment;
	}

	public void setId_empowerment(int id_empowerment) {
		this.id_empowerment = id_empowerment;
	}

	public int getId_equipement() {
		return id_equipement;
	}

	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}




}
