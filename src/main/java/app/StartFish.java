package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.Common;

public class StartFish extends Common {

    private static final Logger logger = LoggerFactory.getLogger(StartFish.class);

    private static Robot robot;
    private static Color color;

    private static int startPointX = 2190;
    private static int startPointY = 360;

    private static final int X_GAP = 46;
    private static final int Y_GAP = 46;

    private static int pageIndex = 1;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {

        startBlack(1000);

        doWork(1000);

        openInventory(500);

        closeInventory(500);

        openInventory(500);

        arrangeItem(1000, startPointX, startPointY);

        closeInventory(1000);

        changeRod(1000);

        exitBlack(1000);
    }

    static public void doWork(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_CONTROL);
        robot.delay(500);
        clickMouseLeft(182, 149);
        robot.delay(500);
        clickMouseLeft(2208, 801);
        robot.delay(500);
        clickMouseLeft(1943, 502);
        robot.delay(500);
        clickMouseLeft(2327, 802);
        robot.delay(500);
        clickKey(KeyEvent.VK_ESCAPE);
    }

    static public void arrangeItem(int delayTime, int startPointX, int startPointY) {
        robot.delay(delayTime);

        System.out.println("PageIndex : " + pageIndex);

        int x = startPointX;
        int y = startPointY;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                robot.delay(50);
                robot.mouseMove(x, y);
                color = getColorInfo(x, y);

                // yellow : [r=150,g=136,b=127] [r=147,g=135,b=110] [r=160,g=145,b=110]
                // red : [r=130,g=85,b=91] [r=135,g=87,b=90]
                // blue : [r=101,g=132,b=152] [r=100,g=132,b=152] [r=97,g=141,b=167]
                // [r=88,g=146,b=179] [r=76,g=150,b=190]

                if (!(i == 0 && j < 2 && pageIndex == 1)) { //Exclude Beer
                    // check green
                    if (color.getRed() < 140 && (color.getGreen() > 95 && color.getGreen() < 150) && color.getBlue() < 110) {
                        robot.mouseMove(x, y + 15);
                        robot.delay(100);
                        Color colorYumul = getColorInfo(2025, 289);
                        Color colorSilverKey = getColorInfo(2052, 534);
                        if (colorYumul.getGreen() < 150 && colorSilverKey.getRed() < 150) {
                            System.out.println((i + 1) + "Row, " + (j + 1) + "Column is Green");
                            deleteItem(300, x, y);
                        }
                    }

                }

                x += X_GAP;
            }
            x = startPointX;
            y += Y_GAP;
        }

        if (pageIndex < 3) {
            scrollToNextInventory(1000);
            arrangeItem(1000, startPointX, startPointY);
        }
    }

    static public void scrollToNextInventory(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(startPointX, startPointY);
        scrollWheel(8);
        pageIndex++;
    }

    static public void changeRod(int delayTime) {
        robot.delay(delayTime);
        clickKey(KeyEvent.VK_I);
        color = getColorInfo(startPointX, startPointY);
        robot.delay(500);
        if (!((color.getRed() > 120 && color.getRed() < 160) && (color.getGreen() > 30 && color.getGreen() < 60)
                && (color.getBlue() > 50 && color.getBlue() < 80))) {
            clickMouseRight(2189, 379);
            robot.delay(500);
            clickKey(KeyEvent.VK_SPACE);
        }
        robot.delay(500);
        clickKey(KeyEvent.VK_I);
    }

    // static public void checkFish(int delayTime) {
    // robot.delay(delayTime);
    // Color color1 = getColorInfo(1202, 47);
    // Color color2 = getColorInfo(1202, 77);

    // // [r=217,g=181,b=57]
    // // [r=192,g=160,b=50]
    // if ((color1.getRed() > 185 && color1.getRed() < 230) && (color1.getGreen() >
    // 150 && color1.getGreen() < 195)
    // && (color1.getBlue() > 40 && color1.getBlue() < 65)
    // || (color2.getRed() > 185 && color2.getRed() < 230)
    // && (color2.getGreen() > 150 && color2.getGreen() < 195)
    // && (color2.getBlue() > 40 && color2.getBlue() < 65)) {
    // clickKey(KeyEvent.VK_SPACE);
    // }
    // robot.delay(3000);
    // }

}