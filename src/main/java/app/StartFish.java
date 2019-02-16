package app;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
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

        checkFish(1000);

        openInventory(500);

        closeInventory(500);

        openInventory(500);

        arrangeItem(1000, startPointX, startPointY);

        closeInventory(1000);

        exitBlack(1000);
    }

    static public void checkFish(int delayTime) {
        robot.delay(delayTime);
        Color color1 = getColorInfo(1202, 47);
        Color color2 = getColorInfo(1202, 77);

        //[r=217,g=181,b=57]
        //[r=192,g=160,b=50]
        if ((color1.getRed() > 185 && color1.getRed() < 230)  && (color1.getGreen() > 150 && color1.getGreen() < 195) && (color1.getBlue() > 40 && color1.getBlue() < 65) 
        || (color2.getRed() > 185 && color2.getRed() < 230)  && (color2.getGreen() > 150 && color2.getGreen() < 195) && (color2.getBlue() > 40 && color2.getBlue() < 65)) {
            clickKey(KeyEvent.VK_SPACE);
        }
        robot.delay(3000);
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

                //yellow : [r=150,g=136,b=127] [r=147,g=135,b=110] [r=160,g=145,b=110]
                //red : [r=130,g=85,b=91] [r=135,g=87,b=90]
                //blue : [r=101,g=132,b=152] [r=100,g=132,b=152] [r=97,g=141,b=167] [r=88,g=146,b=179] [r=76,g=150,b=190]

                //check green
                if((color.getGreen() > 100 && color.getGreen() < 150) && color.getRed() < 140 && color.getBlue() < 110) {
                    robot.mouseMove(x, y+15);
                    robot.delay(100);
                    color = getColorInfo(2025, 289);
                    if(color.getGreen() < 150) {
                        System.out.println((i+1)+"Row, " + (j+1) + "Column is Green");
                        deleteItem(1000, x , y);
                    }
                }
                
                //check blue
                // if ((color.getRed() > 70 && color.getRed() < 110)  && (color.getGreen() > 120 && color.getGreen() < 160) && (color.getBlue() > 140 && color.getBlue() < 200) ) {
                //     robot.mouseMove(x, y+15);
                //     robot.delay(100);
                //     color = getColorInfo(1977, 288);
                //     System.out.println(color.toString());
                //     if(color.getBlue() < 230) {
                //         System.out.println((i+1)+"Row, " + (j+1) + "Column is Blue");
                //         deleteItem(1000, x , y);
                //     }
                // }

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

    static public void deleteItem(int delayTime, int x, int y) {
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

    static public void scrollToNextInventory(int delayTime) {
        robot.delay(delayTime);
        robot.mouseMove(startPointX, startPointY);
        scrollWheel(8);
        pageIndex++;
    }

}