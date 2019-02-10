package app;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HoemMain {

    private static Robot robot;

    public static void main(String[] args) throws Exception {
        robot = new Robot();

        startBlack(1000);

        openInventory(1000);

        releaseRod(1000);

        closeInventory(1000);

        clickKey(KeyEvent.VK_CONTROL);

        clickShipIcon(1000);

        clickShipIcon(1000);

        moveShip(2000);

        exitToHome(360000);

        moveToSaka(25000);

        exitBlack(25000);
    }

    static private void startBlack(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(2344, 1057);
        clickMouseLeft(2344, 972);
        System.out.println("Start Black");
    }

    static private void openInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_I);
        System.out.println("Open Inventory");
    }

    static private void releaseRod(int delayTime) {
        robot.delay(delayTime);
        clickMouseRight(1908, 559);
    }

    static private void closeInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
    }

    static private void clickShipIcon(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(28, 148);
    }

    static private void moveShip(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_T);
    }

    static private void exitToHome(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1335, 408);
        clickKey(KeyEvent.VK_ENTER);
    }

    static private void moveToSaka(int delayTime) {
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

    static private void exitBlack(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1387, 699);
        clickMouseLeft(1353, 611);
    }

    //////////////////////////////////////////////////////////////////////

    static private void clickMouseLeft(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
    }

    static private void clickMouseRight(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(200);
    }

    static private void clickKey(int keyCode) {
        robot.delay(300);
        robot.keyPress(keyCode);
        robot.delay(50);
        robot.keyRelease(keyCode);
        robot.delay(200);
    }

    static private void scrollWheel(int num) {
        robot.delay(300);
        for (int i = 0; i < num; i++) {
            robot.delay(100);
            robot.mouseWheel(1);
        }
    }

}