package thread;

import java.util.ArrayList;
import java.util.Date;

public class ArrayThread implements Runnable{
    static int i = 1000000;
    static long old = 0L;
    static ArrayList list = new ArrayList();

    @Override
    public void run() {
        while (i>0){
//            System.out.println(i + "===" + Thread.currentThread().getName());
            synchronized (ArrayThread.class){
                if(i==1){
                    long now = new Date().getTime();
                    System.out.println("耗时:" + (now - this.old) + "ms");
                }
                list.add(i);
                i--;
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public ArrayThread(Long l){
        this.old = l;
    }
}

class DemoArrayThreadMain{

    static int i = 1000000;
    static long old = 0L;
    static ArrayList list = new ArrayList();


    void start(){
        while (i>0){
//            System.out.println(i + "===" + Thread.currentThread().getName());
            if(i==1){
                long now = new Date().getTime();
                System.out.println("耗时:" + (now - this.old) + "ms");
            }
            list.add(i);
            i--;
        }
    }

    public DemoArrayThreadMain(long l){
        this.old = l;
    }
}

class ArrayThreadTest{
    public static void main(String[] args) {

        DemoArrayThreadMain d1 = new DemoArrayThreadMain(new Date().getTime());
        d1.start();

//        ArrayThread arrayThread = new ArrayThread(new Date().getTime());
//        Thread t1 = new Thread(arrayThread,"1");
//        Thread t2 = new Thread(arrayThread,"2");
//        Thread t3 = new Thread(arrayThread,"3");
//        Thread t4 = new Thread(arrayThread,"4");
//        Thread t5 = new Thread(arrayThread,"5");
//        Thread t6 = new Thread(arrayThread,"6");
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
//        t6.start();
    }
}