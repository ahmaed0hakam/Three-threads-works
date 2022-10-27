import java.io.*;
import java.util.Scanner;

public class Computation implements Runnable {

    public Computation() throws IOException {
    }

    @Override
    public void run() {
        FileWriter myWriter = null;
        FileReader myObj = null;
        Scanner myReader = null;
        try {
            myObj = new FileReader("nums.txt");
            myReader = new Scanner(myObj);
            String s = null;
            Main.m.lock();
            System.out.println("-----------------------------------------------------------\n"+Thread.currentThread().getName()+" is doing a computation");
            while (myReader.hasNext()){
                s= myReader.next();
            }
            myReader.close();
            int n= Integer.parseInt(s);
            ++n;
            int sum=0;
            for (int i=1; i<=1000000; i++){
                sum+=i;
            }
            System.out.println("the sum of numbers between 1 and 1000000 is : "+sum);
            myWriter = new FileWriter("nums.txt", true);
            myWriter.append('\n');
            if (Thread.currentThread().getName().equals("thread : 1"))
                myWriter.append("1 ");
            else if (Thread.currentThread().getName().equals("thread : 2"))
                myWriter.append("2 ");
            else myWriter.append("3 ");
            String nn= ""+n;
            myWriter.append(nn);
            myWriter.close();
            System.out.print(Thread.currentThread().getName()+" worked\n-----------------------------------------------------------");
            System.out.println();
            Main.m.unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

