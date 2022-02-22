package Controller;

import java.io.IOException;

public class Gpio_Off extends Thread{
    public String pin;
    public String identifier;

    public Gpio_Off(String pin, String identifier){
        this.pin = pin;
        this.identifier = identifier;
    }
    public void begin(String pin, String identifier) {
        new Gpio_Off(pin, identifier).start();
    }

    @Override
    public void run(){
        try {
            System.out.println("Turned off pin:" + pin + " this is for identifier: " + identifier);
            Process p = Runtime.getRuntime().exec("python3 /home/pi/gpioOff.py " + pin);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
