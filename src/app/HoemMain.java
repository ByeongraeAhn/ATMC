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

        clickShipIcon(1000);

        clickShipIcon(1000);

        moveShip(3000);

        exitToHome(15000);

        moveToSaka(1000);

        exitBlack(1000);
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
        clickMouseRight(9999999, 9999999);
    }
    
    static private void closeInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
    }

    static private void clickShipIcon(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(9999999, 9999999);
    }

    static private void moveShip(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_T);
    }

    static private void exitToHome(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(9999999, 9999999);
        clickKey(KeyEvent.VK_ENTER);
    }

    static private void moveToSaka(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1387, 699);




    }

    static private void exitBlack(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1387, 699);
        clickMouseLeft(1353, 611);
    }



//////////////////////////////////////////////////////////////////////

    static private void clickMouseLeft(int x, int y) {
        robot.mouseMove(1387, 699);
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
    }

    static private void clickMouseRight(int x, int y) {
        robot.mouseMove(1387, 699);
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(200);
    }

    static private void clickKey(int keyCode) {
        robot.keyPress(keyCode);
        robot.delay(50);
        robot.keyRelease(keyCode);
        robot.delay(200);
    }

}