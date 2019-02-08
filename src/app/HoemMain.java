package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HoemMain {

    private static Robot robot;
    private static Color color;

    // private static int startPointX = 2335;
    // private static int startPointY = 255;
    private static int startPointX = 2190;
    private static int startPointY = 360;

    // private static final int X_GAP = 65;
    // private static final int Y_GAP = 65;
    private static final int X_GAP = 46;
    private static final int Y_GAP = 46;

    private static int pageIndex = 1;

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
        robot.mouseMove(2344, 1057);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(300);
        robot.mouseMove(2344, 972);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("Start Black");
    }

    static private void openInventory(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_I);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_I);
        System.out.println("Open Inventory");
    }

    static private void releaseRod(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(9999999, 9999999);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }
    
    static private void closeInventory(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
    }

    static private void clickShipIcon(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(9999999, 9999999);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    static private void moveShip(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_T);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_T);
    }

    static private void exitToHome(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.delay(1000);
        robot.mouseMove(9999999, 9999999);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    static private void moveToSaka(int delayTime) {

    }

    static private void exitBlack(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.delay(1000);
        robot.mouseMove(1387, 699);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseMove(1353, 611);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

}