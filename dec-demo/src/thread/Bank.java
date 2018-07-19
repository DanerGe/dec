package thread;

// 例子1：银行存取钱问题

public class Bank {
    private static int money;

    public int getMoney(){
        return money;
    }

    public void saveMoney(int m){
        synchronized (this){
            System.out.println("存钱后得金额:" + (money+=m));
        }
    }

    public void drawMoney(int m){
        synchronized (this){
            Bank bank = new Bank();
            if(bank.getMoney()>0){
                System.out.println("取钱后得金额:" + (money-=m));
            }else{
                System.out.println("余额不足");
            }
        }
    }

    public static void main(String[] args) {
        Man m1 = new Man();
        Women w = new Women();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        Thread t3 = new Thread(m1);
        Thread t4 = new Thread(w);
        Thread t5 = new Thread(w);
        Thread t6 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

class Man implements Runnable{
    private Bank bank = new Bank();

    @Override
    public void run() {
        int m = 100;
        int i = 0;
        while (i < 5){
            bank.drawMoney(m);
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            i++;
        }
    }
}

class Women implements Runnable{
    private Bank bank = new Bank();

    @Override
    public void run() {
        int m = 100;
        int i = 0;
        while (i < 5){
            bank.drawMoney(m);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            i++;
        }
    }
}
