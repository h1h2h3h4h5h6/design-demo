package com.example.designdemo.main;

/**
 * 单例模式
 *  场景： 类实例对象只有一个，private修饰构造器，无法创建，通过类提供方法获取实例
 */
public class Single {

    static class Lazy{
        /**
         * 懒汉式
         *  synchronized 修饰方法改变线程安全问题
         */
        private static Lazy lazy;

        private Lazy() {
        }

        public static Lazy getLazy(){
            if(null == lazy){
                lazy = new Lazy();
            }
            return lazy;
        }

    }

    static class Hungry{
        /**
         * 饿汉式
         */
        private static Hungry hungry  = new Hungry();

        private Hungry() {
        }

        public static Hungry getHungry(){
            return  hungry;
        }
    }

    static class StaticInner{
        /**
         * 静态内部类
         */
        private static class StaticClass{
            private static final  StaticInner staticInner = new StaticInner();
        }

        private StaticInner() {
        }

        public static final StaticInner getStaticInner(){
            return  StaticClass.staticInner;
        }
    }

}
