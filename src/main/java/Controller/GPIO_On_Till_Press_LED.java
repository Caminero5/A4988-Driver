package Controller;

import java.io.IOException;

public class GPIO_On_Till_Press_LED extends Thread{
    String pin;
    String btn;
    String delay;
    String LED;

    public GPIO_On_Till_Press_LED(String pin, String btn, String delay, String LED){
        this.pin = pin;
        this.btn = btn;
        this.delay = delay;
        this.LED = LED;
    }


    public void begin(String pin, String btn, String delay, String LED) {
        System.out.println("Gpio on till pressed is called");
        new GPIO_On_Till_Press_LED(pin, btn, delay, LED).start();
    }


    @Override
    public void run(){
        System.out.println("In thread for btn run");
        try {
            Process p = Runtime.getRuntime().exec("python3 /home/pi/gpioOnTillBTNLED.py " + pin + " " + btn + " " + delay + " " + LED);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
