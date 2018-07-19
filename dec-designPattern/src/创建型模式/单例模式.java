package 创建型模式;

import javax.sound.midi.Soundbank;

public class 单例模式 {

    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        SingleObject instance = SingleObject.getInstance();
        System.out.println(singleObject == instance);
    }

}
// 饿汉式
class SingleObject{

    private double lock = Math.random();

    // 创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    // 获取唯一可用的对象
     static SingleObject getInstance(){
        return instance;
    }

    // 构造方法私有化
    private SingleObject(){

    }

    //
    public double testObject(){
        return lock;
    }
}

//懒汉式，线程不安全
class Singleton{
    private static Singleton instance;

    private Singleton(){}

    static Singleton getInstance(){
        if(instance == null){
            return new Singleton();
        }
        return instance;
    }
}

//懒汉式，线程安全
class SingletonSafe{
    private static SingletonSafe instance;

    private SingletonSafe(){}

    static synchronized SingletonSafe getInstance(){
        if(instance == null){
            return new SingletonSafe();
        }
        return instance;
    }
}