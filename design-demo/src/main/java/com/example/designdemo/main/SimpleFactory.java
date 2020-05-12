package com.example.designdemo.main;

/**
 * 简单工厂模式
 *  描述： 只提供固定参数
 *  场景： 一个抽象接口，多个抽象接口实现类，一个工厂类用来实例化抽象的接口
 */
public class SimpleFactory {

    public static void main(String[] args) {
        Car c = Factory.getCarInstance("Benz");
        if (c != null) {
            c.run();
            c.stop();
        } else {
            System.out.println("造不了这种汽车。。。");
        }

    }

    /**
     * 抽象产品类
     */
    static abstract class Car {
        public abstract void run();

        public abstract void stop();
    }

    /**
     * 实现类
     */
    static class  Benz extends Car {

        @Override
        public void run() {
            System.out.println("Benz开始启动了。。。。。");
        }

        @Override
        public void stop() {
            System.out.println("Benz停车了。。。。。");
        }
    }

    static class Ford extends Car{

        @Override
        public void run() {
            System.out.println("Ford启动了。。。。。");
        }

        @Override
        public void stop() {
            System.out.println("Ford停车了。。。。。");
        }
    }

    /**
     * 工厂类
     */
    static class Factory {
        public static Car getCarInstance(String type) {
            Car c = null;
            if ("Benz".equals(type)) {
                c = new Benz();
            }
            if ("Ford".equals(type)) {
                c = new Ford();
            }
            return c;
        }
    }
}
