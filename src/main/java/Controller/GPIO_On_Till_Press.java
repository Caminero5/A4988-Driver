package Controller;

import java.io.IOException;

public class GPIO_On_Till_Press extends Thread{
    String pin;
    String btn;
    String delay;

    public GPIO_On_Till_Press(String pin, String btn, String delay){
        this.pin = pin;
        this.btn = btn;
        this.delay = delay;
    }


    public void begin(String pin, String btn, String delay) {
        System.out.println("Gpio on till pressed is called");
        new GPIO_On_Till_Press(pin, btn, delay).start();
    }


    @Override
    public void run(){
        System.out.println("In thread for btn run");
        try {
            System.out.println("python3 /home/pi/gpioOnTillBTN.py " + pin + " " + btn + " " + delay);
            Process p = Runtime.getRuntime().exec("python3 /home/pi/gpioOnTillBTN.py " + pin + " " + btn + " " + delay);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
