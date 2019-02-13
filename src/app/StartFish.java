package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class StartFish {

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

        checkFish(1000);

        openInventory(1000);

        closeInventory(500);

        openInventory(500);

        arrangeItem(1000, startPointX, startPointY);

        closeInventory(1000);

        exitBlack(1000);

    }

    static private void startBlack(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(2344, 1057);
        clickMouseLeft(2344, 972);
        System.out.println("Start Black");
    }

    static private void checkFish(int delayTime) {
        robot.delay(delayTime);
        color = getColorInfo(1202, 47);
        //System.out.println(color.toString());

        //[r=217,g=181,b=57]
        if ((color.getRed() > 210 && color.getRed() < 225)  && (color.getGreen() > 170 && color.getGreen() < 190) && (color.getBlue() > 50 && color.getBlue() < 65)) {
            clickKey(KeyEvent.VK_SPACE);
        }
        robot.delay(3000);
    }

    static private void openInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_I);
        System.out.println("Open Inventory");
    }


    static private void arrangeItem(int delayTime, int startPointX, int startPointY) {
        robot.delay(delayTime);

        System.out.println("PageIndex : " + pageIndex);

        int x = startPointX;
        int y = startPointY;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                robot.delay(50);
                robot.mouseMove(x, y);
                color = getColorInfo(x, y);
                // if (color.getGreen() > 150 && color.getRed() < 140 ) {
                if((color.getGreen()>100 && color.getGreen()<150) && color.getRed() < 140 && color.getBlue() <110 ) {
                    robot.mouseMove(x, y+15);
                    robot.delay(100);
                    color = getColorInfo(2025, 289);
                    if(color.getGreen()<150) {
                        System.out.println((i+1)+"Row, " + (j+1) + "Column is Green");
                        deleteItem(1000, x , y);
                    }
                }
                x += X_GAP;
            }
            x = startPointX;
            y += Y_GAP;
        }
        
        if (pageIndex < 3) {
            scrollNextPage(1000);
            arrangeItem(1000, startPointX, startPointY);
        }

        
    }

    static private Color getColorInfo(int x, int y) {
        color = robot.getPixelColor(x, y);
        return color;
    }

    static private void deleteItem(int delayTime, int x, int y) {
        robot.delay(delayTime);
        robot.mouseMove(x, y+15);
        robot.delay(100);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(100);
        robot.mouseMove(2507, 794);
        robot.delay(300);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(300);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(300);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        clickKey(KeyEvent.VK_F);
        clickMouseLeft(2429,1031);
        clickKey(KeyEvent.VK_ENTER);
    }

    static private void scrollNextPage(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(startPointX, startPointY);
        scrollWheel(8);
        pageIndex++;
    }

    static private void closeInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        System.out.println("Close Inventory");
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