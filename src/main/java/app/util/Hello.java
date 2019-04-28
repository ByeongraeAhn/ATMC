package app.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Hello extends Common{

    public static void main(String[] args) throws AWTException {

      Robot robot = new Robot();

        while (true) {
          clickKey(KeyEvent.VK_F5);
        }
      }
    
    }
    