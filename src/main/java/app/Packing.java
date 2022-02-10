package app;

import java.awt.*;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.Common;

public class Packing extends Common {

    private static final Logger logger = LoggerFactory.getLogger(Packing.class);

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        while (true) {

            robot.delay(7000);

            clickKey(KeyEvent.VK_R);
            robot.delay(1000);

            clickKey(KeyEvent.VK_2);
            robot.delay(2000);

            clickMouseRight(1449, 330);
            robot.delay(1000);

            clickKey(KeyEvent.VK_F);
            robot.delay(1000);

            clickKey(KeyEvent.VK_ENTER);
            robot.delay(1000);

            clickMouseRight(1400, 330);
            robot.delay(1000);

            clickKey(KeyEvent.VK_F);
            robot.delay(1000);

            clickKey(KeyEvent.VK_ENTER);
            robot.delay(3000);

            clickMouseRight(1122, 350);
            robot.delay(3000);

            clickKey(KeyEvent.VK_1);
            clickKey(KeyEvent.VK_7);
            clickKey(KeyEvent.VK_4);
            robot.delay(300);
            clickKey(KeyEvent.VK_SPACE);
            robot.delay(1000);

            clickKey(KeyEvent.VK_ESCAPE);
            robot.delay(1000);

            clickKey(KeyEvent.VK_ESCAPE);
            robot.delay(1000);

            clickKey(KeyEvent.VK_L);
            robot.delay(1000);

            clickMouseRight(1388, 352);
            robot.delay(1000);

            clickMouseRight(1388, 352);
            robot.delay(1000);

            clickMouseLeft(749, 873);
            robot.delay(1000);
            clickMouseLeft(749, 873);

            robot.delay(60000);
            robot.delay(60000);
            robot.delay(60000);

        }
    }

}