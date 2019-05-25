package app.util;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.StartFish;

public class Common {

    private static final Logger logger = LoggerFactory.getLogger(StartFish.class);

    public static Robot robot;
    public static Color color;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    static public void startBlack(int delayTime) {
        robot.delay(delayTime);
        clickMouseLeft(2344, 1057);
        clickMouseLeft(2344, 972);
    }

    static public void openInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_I);
    }

    static public Color getColorInfo(int x, int y) {
        color = robot.getPixelColor(x, y);
        return color;
    }

    static public void closeInventory(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
    }

    static public void exitBlack(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_ESCAPE);
        clickMouseLeft(1449, 728); //moveToBaza 좌표 같이 변경해야됨
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

    static public void deleteItem(int delayTime, int x, int y) {
        robot.delay(delayTime);
        robot.mouseMove(x, y + 15);
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
        clickMouseLeft(2429, 1031);
        clickMouseLeft(1233, 460);
    }

}