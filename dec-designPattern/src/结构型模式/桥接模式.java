package 结构型模式;

public class 桥接模式 {
//    桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。
//    这种类型的设计模式属于结构型模式，它通过提供抽象化和实现化之间的桥接结构，来实现二者的解耦。
//    意图：将抽象部分与实现部分分离，使它们都可以独立的变化。

    // 创建桥接实现接口
    interface DrawAPI {
        public void drawCircle(int radius, int x, int y);
    }

    // 创建实现了 DrawAPI 接口的实体桥接实现类。
    class RedCircle implements DrawAPI {
        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: red, radius: "
                    + radius +", x: " +x+", "+ y +"]");
        }
    }
    class GreenCircle implements DrawAPI {
        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: green, radius: "
                    + radius +", x: " +x+", "+ y +"]");
        }
    }

    // 使用 DrawAPI 接口创建抽象类 Shape。
    abstract class Shape {
        protected DrawAPI drawAPI;
        protected Shape(DrawAPI drawAPI){
            this.drawAPI = drawAPI;
        }
        public abstract void draw();
    }

    // 创建实现了 Shape 接口的实体类。
    class Circle extends Shape {
        private int x, y, radius;

        public Circle(int x, int y, int radius, DrawAPI drawAPI) {
            super(drawAPI);
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public void draw() {
            drawAPI.drawCircle(radius,x,y);
        }
    }

    // 使用 Shape 和 DrawAPI 类画出不同颜色的圆。
    public static void main(String[] args) {
        Shape redCircle = new 桥接模式().new Circle(100,100, 10, new 桥接模式().new RedCircle());
        Shape greenCircle = new 桥接模式().new Circle(100,100, 10, new 桥接模式().new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}
