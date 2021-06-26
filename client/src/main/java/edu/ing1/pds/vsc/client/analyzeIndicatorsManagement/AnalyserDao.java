package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;

import edu.ing1.pds.vsc.client.ClientToServer;

public interface AnalyserDao {
	Double nbEquipment(ClientToServer connection, int id_gs);
	
	Double nbSensor(ClientToServer connection, int id_gs);

	
	Double degre(ClientToServer connection, int id_gs);
	
	
	Double power(ClientToServer connection, int id_gs);
	
	
	Double nbWorkspaceAvailable(ClientToServer connection, int id_gs);

}
