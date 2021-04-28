package edu.ing1.pds.vsc.client.electroChromaticWindowsManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static final String DRIVER_NAME = "org.postgresql.Driver";
	public static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/episen";

	Connection connect = null;

	public static Connection dbConnector() {
		try {

			Class.forName(DRIVER_NAME);
			Connection connect = DriverManager.getConnection(DATABASE_URL, "postgres", "admin");

			return connect;

		} catch (Exception e) {
			return null;
		}

	}

}
