package 创建型模式;

public class 抽象工厂模式 {

    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();
        Shape shape = factoryProducer.getFactory("shape").getShape("square");
        shape.draw();
    }

}
//=====================================================
/**
 * 为形状创建一个接口。
 * */
interface Shape {
    void draw();
}

//创建实现接口的实体类。
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

//=====================================================
/**
 *  为颜色创建一个接口。
 */
interface Color {
    void fill();
}

//创建实现接口的实体类。
class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}

//=====================================================
/**
 * 为 Color 和 Shape 对象创建抽象类来获取工厂。
 * */
abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}

//创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
class ShapeFactory extends AbstractFactory {

    @Override
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

    @Override
    public Color getColor(String color) {
        return null;
    }

}

class ColorFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shape) {
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equals("RED")){
            return new Red();
        } else if(color.equals("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
//    创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
class FactoryProducer{
    public AbstractFactory getFactory(String choice) {
        if (choice == null) {
            return null;
        }
        if (choice.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
