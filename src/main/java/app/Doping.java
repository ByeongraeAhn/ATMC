package app;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import app.util.Common;

public class Doping extends Common {

    public static void main(String[] args) throws Exception {

      Robot robot = new Robot();

        while (true) {
          robot.delay(3000);
          clickKey(KeyEvent.VK_7);
          robot.delay(11000);
          clickKey(KeyEvent.VK_9);
          Thread.sleep(900000);
        }
      }
    
    }
    