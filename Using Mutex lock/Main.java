import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import sun.awt.Mutex;

public class Main {

    public static Mutex m= new Mutex();
    public static void main(String[] args) throws IOException, InterruptedException {
        Computation runnable1= new Computation();
        Thread t1= new Thread(runnable1);
        t1.setName("thread : 1");

        Computation runnable2= new Computation();
        Thread t2= new Thread(runnable2);
        t2.setName("thread : 2");

        Computation runnable3= new Computation();
        Thread t3= new Thread(runnable3);
        t3.setName("thread : 3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}
