package edu.ing1.pds.vsc.client.accessCardManagement.vscDataModel;

public class AccessCardModel {

	private String id_accessCard; 
	private String type_card; 
	private enum statut_card {
		OK,
		KO,
		Warning;   
	}; 	   
	private int id_matricule; 
	private int id_generalServices; 
	private int id_empowerment; 
	private int id_token; 
	private int id_accessLevel;

	public AccessCardModel(String id_accessCard, String type_card, int id_matricule, int id_generalServices,
			int id_empowerment, int id_token, int id_accessLevel) {
		super();
		this.id_accessCard = id_accessCard;
		this.type_card = type_card;
		this.id_matricule = id_matricule;
		this.id_generalServices = id_generalServices;
		this.id_empowerment = id_empowerment;
		this.id_token = id_token;
		this.id_accessLevel = id_accessLevel;
	}


	public String getId_accessCard() {
		return id_accessCard;
	}

	public void setId_accessCard(String id_accessCard) {
		this.id_accessCard = id_accessCard;
	}
	public String getType_card() {
		return type_card;
	}
	public void setType_card(String type_card) {
		this.type_card = type_card;
	}
	public int getId_matricule() {
		return id_matricule;
	}
	public void setId_matricule(int id_matricule) {
		this.id_matricule = id_matricule;
	}
	public int getId_generalServices() {
		return id_generalServices;
	}
	public void setId_generalServices(int id_generalServices) {
		this.id_generalServices = id_generalServices;
	}
	public int getId_empowerment() {
		return id_empowerment;
	}
	public void setId_empowerment(int id_empowerment) {
		this.id_empowerment = id_empowerment;
	}
	public int getId_token() {
		return id_token;
	}
	public void setId_token(int id_token) {
		this.id_token = id_token;
	}
	public int getId_accessLevel() {
		return id_accessLevel;
	}
	public void setId_accessLevel(int id_accessLevel) {
		this.id_accessLevel = id_accessLevel;
	}

	@Override
	public String toString() {
		return "AccessCardModel [id_accessCard=" + id_accessCard + ", type_card=" + type_card + ", id_matricule="
				+ id_matricule + ", id_generalServices=" + id_generalServices + ", id_empowerment=" + id_empowerment
				+ ", id_token=" + id_token + ", id_accessLevel=" + id_accessLevel + "]";
	} 


}
