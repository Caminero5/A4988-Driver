package Installer;

import java.io.IOException;
import java.sql.*;

public class Main {
    public void start() throws IOException, InterruptedException {
        // SQLite connection string
        String url = new Info().getConfigDir();

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS appInfo (\n"
                + "	\"ID\" INTEGER,\n"
                + "	\"version\" TEXT,\n"
                + "	\"ran\" INTEGER DEFAULT 0,\n"
                + " PRIMARY KEY(\"ID\" AUTOINCREMENT) \n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLite lite = new SQLite();

        lite.createData();
        int versionChangeStatus = lite.updateVersionInDB();

        if(versionChangeStatus != 0) System.out.println("Something went wrong dumb fuck");

        int ran = lite.getRanValue();

        Download download = new Download();
        if(ran == 0){
            String version = new Info().getVersion();
            //for deploy
//            Process p = Runtime.getRuntime().exec("wget -O /home/pi/" + version + ".zip " + "https://install.swiftpcb.tech/" + version + ".zip" + " && unzip /home/pi/" + version + ".zip -d /home/pi");
//            System.out.println("wget -O /home/pi/" + version + ".zip " + "https://install.swiftpcb.tech/" + version + ".zip" + " | unzip /home/pi/" + version + ".zip -d /home/pi");
            download.begin("https://install.swiftpcb.tech/" + version + ".zip");
            Process p = Runtime.getRuntime().exec("unzip /home/pi/target/pythonDep.zip -d /home/pi");
//            Process p = Runtime.getRuntime().exec("wget https://install.swiftpcb.tech/" + version + ".zip" + " && unzip" + version + ".zip -d /home/pi ");

            int updateStat = lite.updateRanValue("1");
            if(updateStat != 0) System.out.println("Something went wrong");
        }
    }
}



//IT WONT UNZIP IDK WHY I THINK ZIP FILE IS CORRUPTED OR SUM