package Controller;

import java.io.IOException;

public class Gpio_On extends Thread {
    public String pin;
    public String identifier;
    public Gpio_On(String pin, String identifier){
        this.pin = pin;
        this.identifier = identifier;
    }
    public void begin(String pin, String identifier) {
        new Gpio_On(pin, identifier).start();
    }

    @Override
    public void run(){
        try {
            System.out.println("Turned on pin:" + pin + " this is for process id: " + identifier);
            Process p = Runtime.getRuntime().exec("python3 /home/pi/gpioOn.py " + pin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
