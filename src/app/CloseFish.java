package app;

import java.awt.event.KeyEvent;

public class CloseFish extends Common {

    public static void main(String[] args) throws Exception {

        startBlack(1000);

        openInventory(1000);

        releaseRod(1000);

        closeInventory(1000);

        clickKey(KeyEvent.VK_CONTROL);

        clickShipIcon(1000);

        clickShipIcon(1000);

        moveShip(2000);

        exitToHome();

        moveToSaka(20000);

        exitBlack(30000);
    }

    static public void releaseRod(int delayTime) {
        robot.delay(delayTime);
        clickMouseRight(1908, 559);
    }

    static public void clickShipIcon(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(28, 148);
    }

    static public void moveShip(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_T);
    }

    static public void exitToHome() {
        robot.delay(60000);
        robot.delay(60000);
        robot.delay(60000);
        robot.delay(60000);
        robot.delay(60000);
        robot.delay(60000);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1335, 408);
        clickKey(KeyEvent.VK_ENTER);
    }

    static public void moveToSaka(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1387, 699);
        clickMouseLeft(1511, 571);
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