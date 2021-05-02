package edu.ing1.pds.vsc.client.analyzeIndicatorsManagement;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class AnalyserDaoImpl implements AnalyserDao {

    private Connection getConnection() {
        Connection connection = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_connection();
        return connection;
    }
    

    @Override
    public int getNombreCapteurs() {
        Connection connection = getConnection();
        try {

            String query = "select count(*) from capteurs";
            Statement statemnt = connection.createStatement();
            ResultSet rs = statemnt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
                // System.out.println(rs.getString(2));
            }
            throw new RuntimeException("Not Found");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not Found");
        }
    }



    @Override
    public int getNombreServices() {
        Connection connection = getConnection();
        try {

            String query = "select count(*) from services";
            Statement statemnt = connection.createStatement();
            ResultSet rs = statemnt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1);
                // System.out.println(rs.getString(2));
            }
            throw new RuntimeException("Not Found");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Not Found");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Capteurs : "+new AnalyserDaoImpl().getNombreCapteurs());

    }
}