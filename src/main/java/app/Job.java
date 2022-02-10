package app;

import java.awt.*;
import java.awt.event.KeyEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.util.Common;

public class Job extends Common {

    private static final Logger logger = LoggerFactory.getLogger(Job.class);

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        int[] arr = {KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3};


        while (true) {
            int tabNum = shuffle(arr);
            int delay1 = (int)(Math.random() * (10000*6));
            int delay2 = (int)(Math.random() * (10000*6));
            int delay3 = (int)(Math.random() * (10000*6));
            System.out.println("탭 : " + tabNum +" // " + (delay1+delay2+delay3)/1000 + "초");

            robot.delay(delay1);
            robot.delay(delay2);
            robot.delay(delay3);

            robot.keyPress(KeyEvent.VK_META);
            robot.delay(100);
            robot.keyPress(tabNum);
            robot.delay(100);
            robot.keyRelease(tabNum);
            robot.delay(2000);
            clickKey(KeyEvent.VK_R);
            robot.keyRelease(KeyEvent.VK_META);

        }
    }

    public static int shuffle(int[] arr){
        for(int x=0;x<arr.length;x++){
            int i = (int)(Math.random()*arr.length);
            int j = (int)(Math.random()*arr.length);

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr[0];
    }
}