package 创建型模式;

public class 工厂模式 {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new 工厂模式().new ShapeFactory();

        //获取 Circle 的对象，并调用它的 draw 方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //调用 Circle 的 draw 方法
        shape1.draw();

        //获取 Rectangle 的对象，并调用它的 draw 方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //调用 Rectangle 的 draw 方法
        shape2.draw();

        //获取 Square 的对象，并调用它的 draw 方法
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //调用 Square 的 draw 方法
        shape3.draw();
    }


    //创建一个统一接口
    interface Shape{
        void draw();
    }
    //创建实现接口的实体类。
    class Rectangle implements Shape{

        @Override
        public void draw() {
            System.out.println("Inside Rectangle::draw() method.");
        }
    }
    //创建实现接口的实体类。
    class Square implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Square::draw() method.");
        }
    }
    //创建实现接口的实体类。
    class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Inside Circle::draw() method.");
        }
    }
    //创建一个工厂类
    class ShapeFactory {

        //使用 getShape 方法获取形状类型的对象
        public Shape getShape(String shapeType){
            if(shapeType == null){
                return null;
            }
            if(shapeType.equalsIgnoreCase("CIRCLE")){
                return new Circle();
            } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                return new Rectangle();
            } else if(shapeType.equalsIgnoreCase("SQUARE")){
                return new Square();
            }
            return null;
        }
    }
}
