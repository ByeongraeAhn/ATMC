package app.util;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Common {

    public static Robot robot;
    public static Color color;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static public void startBlack(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(2344, 1057);
        clickMouseLeft(2344, 972);
        System.out.println("Start Black");
    }

    static public void openInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_I);
        System.out.println("Open Inventory");
    }

    static public Color getColorInfo(int x, int y) {
        color = robot.getPixelColor(x, y);
        return color;
    }

    static public void closeInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
    }

    static public void exitBlack(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1387, 699);
        clickMouseLeft(1353, 611);
    }

    static public void clickMouseLeft(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
    }

    static public void clickMouseRight(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(200);
    }

    static public void clickKey(int keyCode) {
        robot.delay(300);
        robot.keyPress(keyCode);
        robot.delay(50);
        robot.keyRelease(keyCode);
        robot.delay(200);
    }

    static public void scrollWheel(int num) {
        robot.delay(300);
        for (int i = 0; i < num; i++) {
            robot.delay(100);
            robot.mouseWheel(1);
            robot.delay(200);
        }
    }

}