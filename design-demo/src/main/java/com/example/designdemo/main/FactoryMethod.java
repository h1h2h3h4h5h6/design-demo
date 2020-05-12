package com.example.designdemo.main;

/**
 * 工厂方法模式
 *
 *  描述：有四个角色，抽象工厂模式，具体工厂模式，抽象产品模式，具体产品模式。
 *  不再是由一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品
 *
 *  场景：消费者不关心它所要创建对象的类(产品类)的时候。
 *  消费者知道它所要创建对象的类(产品类)，但不关心如何创建的时候，产品单一
 */
public class FactoryMethod {

    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        VehicleFactory factory2 = new PlaneFactory();

        Moveable m = factory.create();
        m.run();

        Moveable m2 = factory2.create();
        m2.run();
    }


    /**
     * 抽象产品
     */
    interface Moveable{
        void run();
    }

    /**
     * 具体产品
     */
    static class Plane implements Moveable{

        @Override
        public void run() {
            System.out.println("plane....");
        }
    }

    static class Broom implements Moveable {
        @Override
        public void run() {
            System.out.println("broom.....");
        }
    }

    // 抽象工厂
    static abstract class VehicleFactory {
        abstract Moveable create();
    }

    // 具体工厂
    static class PlaneFactory extends VehicleFactory {

        public Moveable create() {
            return new Plane();
        }
    }

    static class BroomFactory extends VehicleFactory {
        public Moveable create() {
            return new Broom();
        }
    }
}
