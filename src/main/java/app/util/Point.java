package app.util;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.Color;

public class Point {

    public static void main(String[] args) throws AWTException {

        Robot robot = new Robot();
    
        PointerInfo pi;
    
        while (true) {
          robot.delay(300);
    
          pi = MouseInfo.getPointerInfo();
          Color color = robot.getPixelColor(pi.getLocation().x, pi.getLocation().y);
          System.out.println("x point : " + pi.getLocation().x);
          System.out.println("y point : " + pi.getLocation().y);
//          System.out.println("red : " + color.getRed());
//          System.out.println("green : " + color.getGreen());
//          System.out.println("blue : " + color.getBlue());
    
        }
      }
    
    }
    