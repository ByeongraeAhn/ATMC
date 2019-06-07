package app;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import app.util.Common;

public class Doping extends Common {

  public static void main(String[] args) throws Exception {

    Runnable r = new secondDoping();
    Thread thread = new Thread(r);
    thread.start();

    Robot robot = new Robot();
    while (true) {
      robot.delay(3000);
      clickKey(KeyEvent.VK_7);
      // 15분
      Thread.sleep(900000);
    }
  }
}

class secondDoping extends Common implements Runnable {

  @Override
  public void run() {

    try {
      Robot robot = new Robot();
      while (true) {
        robot.delay(5000);
        clickKey(KeyEvent.VK_9);
        // 20분
        Thread.sleep(1200000);
      }
    } catch (Exception e) {
    }
  }
}
