
package app;

import java.util.ArrayList;
import java.util.*;

@FunctionalInterface

interface Calc { // 함수형 인터페이스의 선언

    public int min(int x, int y);

}

public class Test extends Thread {
    int seq;
    public Test(int seq) {
        this.seq = seq;
    }
    public void run() {
        System.out.println(this.seq+" thread start.");
        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }
        System.out.println(this.seq+" thread end.");
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<Thread>();
        for(int i=0; i<10; i++) {
            Thread t = new Test(i);
            t.start();
            threads.add(t);
        }
    
        for(int i=0; i<threads.size(); i++) {
            Thread t = threads.get(i);
            try {
                t.join();
            }catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}