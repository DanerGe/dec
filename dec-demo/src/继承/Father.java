package 继承;

public class Father {
    public int age;
    private String name;

    void say(){
        System.out.println("I'm father!");
    }

    private void myMothed(){
        System.out.println("=====");
    }

    public Father(int age) {
        this.age = age;
    }
}
