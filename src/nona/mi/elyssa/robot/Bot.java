package nona.mi.elyssa.robot;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

public class Bot {

    public static final String L_KEY = "l";
    public static final String Z_KEY = "z";

    public Bot(File path, int targetTime, String key){

        try {
            int resetDelay = 3000;
            int keyPressedDelay = 1000;

            Robot bot = new Robot();
            Desktop.getDesktop().open(path);

            bot.delay(resetDelay);

            bot.keyPress(KeyEvent.VK_CONTROL);
            bot.keyPress(KeyEvent.VK_R);
            bot.keyRelease(KeyEvent.VK_CONTROL);
            bot.keyRelease(KeyEvent.VK_R);

            bot.delay(targetTime);

            if (key.equals(L_KEY)) {
                bot.keyPress(KeyEvent.VK_L);
                bot.delay(keyPressedDelay);
                bot.keyRelease(KeyEvent.VK_L);
            } else {
                bot.keyPress(KeyEvent.VK_Z);
                bot.delay(keyPressedDelay);
                bot.keyRelease(KeyEvent.VK_Z);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}