package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class App {

    private static Robot robot;
    private static Color color;

    private static int startPointX = 2335;
    private static int startPointY = 255;

    private static final int X_GAP = 65;
    private static final int Y_GAP = 65;

    private static int pageIndex = 1;

    public static void main(String[] args) throws Exception {
        robot = new Robot();

        // startBlack(1000);

        // openInventory(3000);

        arrangeItem(1000, startPointX, startPointY);

        // closeInventory(1000);

        // exitBlack(1000);

    }

    static private void startBlack(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(500, 500);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseMove(400, 400);
        robot.delay(500);
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

    static private void arrangeItem(int delayTime, int startPointX, int startPointY) {
        robot.delay(delayTime);

        System.out.println("PageIndex : " + pageIndex);

        int x = startPointX;
        int y = startPointY;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                robot.delay(200);
                robot.mouseMove(x, y);
                color = getColorInfo(x, y);
                if (color.getGreen() > 150 && color.getRed() < 140 ) {
                    System.out.println((i+1)+"Row, " + (j+1) + "Column is Green");
                    deleteItem(1000, x , y-5);
                }
                x += X_GAP;
            }
            x = startPointX;
            y += Y_GAP;
        }
        
        if (pageIndex < 1) {
            scrollNextPage(1000);
            arrangeItem(1000, startPointX, startPointY);
        }

        
    }

    static private Color getColorInfo(int x, int y) {
        color = robot.getPixelColor(x, y);
        // System.out.println("X Position : " + x);
        // System.out.println("Y Position : " + y);
        // System.out.println("RGB : " + color.toString());
        return color;
    }

    static private void deleteItem(int delayTime, int x, int y) {
        // robot.delay(delayTime);
        // robot.mouseMove(x, y);
        // robot.delay(1000);
        // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // robot.delay(1000);
        // robot.mouseMove(1872, 800);
        // robot.delay(1000);
        // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // robot.delay(1000);
        // robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        // robot.delay(1000);
        // robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        // robot.delay(1000);
        // robot.keyPress(KeyEvent.VK_ENTER);
        // robot.keyRelease(KeyEvent.VK_ENTER);
    }

    static private void scrollNextPage(int delayTime) {
        // robot.delay(delayTime);
        // robot.mouseMove(startPointX, startPointY);
        // for (int i = 0; i < 8; i++) {
        //     robot.delay(100);
        //     robot.mouseWheel(1);
        // }
        pageIndex++;
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
        robot.mouseMove(600, 800);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseMove(400, 400);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(50);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

}