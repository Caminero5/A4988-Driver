package Controller;

import java.io.IOException;

public class Motor{
    public void rotate(boolean clockwise, boolean ms1, boolean ms2, boolean ms3, String STEP, String MS1, String MS2, String MS3, String DIR, String step_delay, String btn_pin) throws IOException {

        System.out.println("Clockwise: " + clockwise + " MS1: " + ms1 + " MS2:" + ms2 + " MS3:" + ms3);
        //checks if the value is true or false then sets the pin to that
        if(clockwise) {
            Gpio_On clockwiseOn = new Gpio_On(DIR, "DIR on");
            clockwiseOn.begin(DIR, "DIR on");
        }
        else {
            System.out.println("Working in DIR else");
            Gpio_Off clockwiseOff = new Gpio_Off(DIR, "DIR off");
            clockwiseOff.begin(DIR, "DIR off");
        }

        if(ms1) {
            Gpio_On MS1On = new Gpio_On(MS1, "MS1 On");
            MS1On.begin(MS1, "MS1 On");
        }
        else {
            System.out.println("Working in ms1 else");
            Gpio_Off MS1Off = new Gpio_Off(MS1, "MS1 off");
            MS1Off.begin(MS1, "MS1 off");
        }

        if(ms2) {
            Gpio_On MS2On = new Gpio_On(MS2, "MS2 on");
            MS2On.begin(MS2, "MS2 on");
        }
        else {
            System.out.println("Working in ms2 else");
            Gpio_Off MS2Off = new Gpio_Off(MS2, "MS2 off");
            MS2Off.begin(MS2, "MS2 off");
        }

        if(ms3) {
            Gpio_On MS3On = new Gpio_On(MS3, "MS3 On");
            MS3On.begin(MS3, "MS3 On");
        }
        else {
            System.out.println("Working in ms3 else");
            Gpio_Off MS3Off = new Gpio_Off(MS3, "MS3 off");
            MS3Off.begin(MS3, "MS3 off");
        }

        System.out.println("Set all the pin states");

        GPIO_On_Till_Press gpioOnTillPress = new GPIO_On_Till_Press(STEP, btn_pin, step_delay);

        //starts motor thread
        gpioOnTillPress.begin(STEP, btn_pin, step_delay);
    }
}