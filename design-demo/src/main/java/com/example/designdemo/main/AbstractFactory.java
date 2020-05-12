package com.example.designdemo.main;

/**
 * 抽象工厂模式
 *  描述：与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品，而抽象工厂模式中的工厂生产多个产品
 *  场景：多种产品
 */
public class AbstractFactory {

    public static void main(String[] args) {
        AbFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.run();
        Food a = f.createFood();
        a.run();
    }


    /**
     * 抽象产品类
     */
    interface Vehicle {
        void run();
    }
    interface Weapon {
        void run();
    }
    interface Food {
        void run();
    }

    /**
     * 具体产品类
     */
    static class Car implements Vehicle{
        @Override
        public void run() {
            System.out.println("小汽车");
        }
    }

    static class AK47 implements Weapon{
        @Override
        public void run() {
            System.out.println("哒哒哒");
        }
    }

    static class Apple implements Food{
        @Override
        public void run() {
            System.out.println("苹果");
        }
    }

    /**
     * 抽象工厂类
     */
    static abstract class AbFactory {
        public abstract Vehicle createVehicle();
        public abstract Weapon createWeapon();
        public abstract Food createFood();
    }

    /**
     * 具体工厂类
     */
    static class DefaultFactory extends AbFactory{
        @Override
        public Food createFood() {
            return new Apple();
        }
        @Override
        public Vehicle createVehicle() {
            return new Car();
        }
        @Override
        public Weapon createWeapon() {
            return new AK47();
        }
    }
}
