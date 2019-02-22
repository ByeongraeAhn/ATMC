package app;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.Common;

public class Work extends Common {

    private static final Logger logger = LoggerFactory.getLogger(CloseFish.class);

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {

        startBlack(1000);

        doWork(1000);

        exitBlack(1000);
    }

    static public void doWork(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_CONTROL);
        robot.delay(1000);
        clickMouseLeft(182, 149);
        robot.delay(1000);
        clickMouseLeft(2208, 801);
        robot.delay(1000);
        clickMouseLeft(1943, 502);
        robot.delay(1000);
        clickMouseLeft(2327, 802);
        robot.delay(1000);
        clickKey(KeyEvent.VK_ESCAPE);
    }

}