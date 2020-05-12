package com.example.designdemo.main;

/**
 * 装饰者模式
 *  场景：对已存在的业务逻辑进一步封装，使其增加额外功能，例如io流，使用者可任意组装
 */
public class Decorator {


        public static void main(String[] args) {
            Food food = new Bread(new Vegetable(new Cream(new Food("肘子"))));
            System.out.println(food.make());
        }

    /**
      * 已存在业务
      */
    static class Food{
        private String name;

        public Food() {
        }

        public Food(String name) {
            this.name = name;
        }

        public String make(){
            return name;
        }
    }

    /**
     * 封装1
     */
    static class Bread extends Food{
        private Food basic_food;

        public Bread(Food basic_food) {
            this.basic_food = basic_food;
        }

        public String make(){
            return basic_food.make()+"面包";
        }
    }

    /**
     * 封装2
     */
    static class Cream  extends Food{
        private Food basic_food;

        public Cream(Food basic_food) {
            this.basic_food = basic_food;
        }

        public String make(){
            return basic_food.make()+"奶油";
        }
    }


    /**
     * 封装3
     */
    static class Vegetable extends Food {

        private Food basic_food;

        public Vegetable(Food basic_food) {
            this.basic_food = basic_food;
        }

        public String make(){
            return basic_food.make()+"蔬菜";
        }
    }
}
