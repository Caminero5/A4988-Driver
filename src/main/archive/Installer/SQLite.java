package Installer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLite {
    public String configDir = new Info().getConfigDir();
    public int createData(){
        String version = new Info().getVersion();
        Connection con;
        Statement st;

        int i = 999;
        try{
            con = DriverManager.getConnection(configDir);

            st = con.createStatement();

            i = st.executeUpdate("INSERT INTO appInfo(version) VALUES ('"+version+"')");
        }
        catch(Exception ex){
            System.out.println("Exception : " + ex.toString());
        }
        return i;
    }

    public int getRanValue() {
        Connection con;
        Statement st;
        ResultSet rs;

        int ran = 0;

        try {
            con = DriverManager.getConnection(configDir);
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM appInfo WHERE ID = 0");

            while (rs.next()) {
                ran = rs.getInt("ran");
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.toString());
        }
        return ran;
    }

    public int updateRanValue(String value){
        Connection con;
        Statement st;

        int i = 999;
        try{
            con = DriverManager.getConnection(configDir);
            st = con.createStatement();

            i = st.executeUpdate("UPDATE appInfo SET ran = "+value+" WHERE ID = 0");

        }
        catch(Exception ex){
            System.out.println("Exception : " + ex.toString());
        }

        return i;
    }

    public String getVersion(){
        Connection con;
        Statement st;
        ResultSet rs;

        String version = "";

        try {
            con = DriverManager.getConnection(configDir);
            st = con.createStatement();

            rs = st.executeQuery("SELECT * FROM appInfo WHERE ID = 0");

            while (rs.next()) {
                version = rs.getString("version");
            }
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.toString());
        }
        return version;
    }

    public int updateVersionInDB(){
        String value = new Info().getVersion();

        Connection con;
        Statement st;

        int i = 999;
        try{
            con = DriverManager.getConnection(configDir);
            st = con.createStatement();

            i = st.executeUpdate("UPDATE appInfo SET version = '"+value+"' WHERE ID = 0");

        }
        catch(Exception ex){
            System.out.println("Exception : " + ex.toString());
        }

        return i;
    }

}
