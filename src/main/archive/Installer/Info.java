package Installer;

public class Info {
    public String version = "1.2.2";
    public String configDir = "jdbc:sqlite:/home/pi/PCB_Config/config.pcb";


    public String getConfigDir() {return configDir;}

    public String getVersion() {return version;}
}
