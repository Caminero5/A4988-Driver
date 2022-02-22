package Controller;

import java.io.IOException;

public class Debug {
    public static void main(String[] args) throws InterruptedException, IOException {
//        Main installer = new Main();
//        installer.start();
//        System.out.println("Checked and or installed for new version");
//        System.out.println(new Info().getVersion());
        Motor motor = new Motor();
        motor.rotate(true, false, false, false, "21", "16", "19", "20", "26", "0.005", "24");
    }
}
