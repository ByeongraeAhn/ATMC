package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class App {

    private static Robot robot;
    private static Color color;

    private static int startPointX = 2190;
    private static int startPointY = 360;


    public static void main(String[] args) throws Exception {
        robot = new Robot();

        // startBlack(1000);

        // openInventory(1000);

        releaseRod();

        clieckShipIcon();

        clieckShipIcon();


        // closeInventory(1000);

        // exitBlack(1000);

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


    static private Color getColorInfo(int x, int y) {
        color = robot.getPixelColor(x, y);
        // System.out.println("X Position : " + x);
        // System.out.println("Y Position : " + y);
        // System.out.println("RGB : " + color.toString());
        return color;
    }

    static private void closeInventory(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.delay(50);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
    }

    static private void exitBlack(int delayTime) {
        robot.delay(delayTime);
        robot.keyPress(KeyEvent.VK_ESCAPE);
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