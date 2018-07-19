package 继承;

public class Son extends Father{

    public Son(int age) {
        super(age);
    }

    public void d11(String[] args) {
        this.age = super.age;
    }
}

class SonTest extends Object{
    public static void main(String[] args) {

    }

}
