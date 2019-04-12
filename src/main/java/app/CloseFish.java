package app;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.Common;

public class CloseFish extends Common {

    private static final Logger logger = LoggerFactory.getLogger(CloseFish.class);

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        startBlack(1000);

        openInventory(1000);

        deleteItem(1000, 2190, 424);

        releaseRod(300);

        closeInventory(1000);

        startSwim(1000);

        exitBlack(2000);
        Thread.sleep(300000);
        startBlack(1000);

        exitToHome(1000);

        moveToBaza(20000);

        exitBlack(33000);
    }

    static public void releaseRod(int delayTime) {
        robot.delay(delayTime);
        clickMouseRight(1908, 559);
    }

    static public void startSwim(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(5000);
        robot.keyRelease(KeyEvent.VK_W);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_E);
        robot.delay(5000);
        robot.keyRelease(KeyEvent.VK_E);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_T);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_T);
    }

    static public void exitToHome(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_0);
        clickKey(KeyEvent.VK_CONTROL);
        clickMouseLeft(1275, 554);
        clickMouseLeft(1223, 447);
    }

    static public void moveToBaza(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1448, 725);
        clickMouseLeft(1050, 571);
        clickMouseLeft(1334, 464);
        robot.mouseMove(1334, 464 + 15);
        scrollWheel(7);
        clickMouseLeft(1277, 528);
        clickMouseLeft(1319, 505);
        robot.mouseMove(1319, 505 + 15);
        clickMouseLeft(1324, 520);
        clickMouseLeft(1373, 650);
        clickKey(KeyEvent.VK_ENTER);
    }

}