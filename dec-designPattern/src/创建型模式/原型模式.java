package 创建型模式;

public class 原型模式 {


    // 创建一个实现了 Clonable 接口的抽象类。
    abstract class Shape implements Cloneable {

        private String id;
        protected String type;

        abstract void draw();

        public String getType(){
            return type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object clone() {
            Object clone = null;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return clone;
        }
    }

    // 创建扩展了上面抽象类的实体类。
    class Rectangle extends Shape {

        public Rectangle(){
            type = "Rectangle";
        }

        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }

    class Square extends Shape {

        public Square(){
            type = "Square";
        }

        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }

    class Circle extends Shape {

        public Circle(){
            type = "Circle";
        }

        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }
}

