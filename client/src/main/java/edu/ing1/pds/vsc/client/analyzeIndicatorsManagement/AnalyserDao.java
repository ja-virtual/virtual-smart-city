package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;

import edu.ing1.pds.vsc.client.ClientToServer;

public interface AnalyserDao {
	Double numberEquipment(ClientToServer connection, int id_gs);
	
	Double nbConsur(ClientToServer connection, int id_gs);

	
	Double degree(ClientToServer connection, int id_gs);
	
	
	Double level(ClientToServer connection, int id_gs);
	
	
	Double numberWorkspaceAvailable(ClientToServer connection, int id_gs);

}
