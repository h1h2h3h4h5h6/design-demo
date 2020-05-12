package com.example.designdemo.main;

import sun.applet.Main;

/**
 * 代理模式
 *  场景：孩子小，吃奶洗衣服由大人负责
 *  抽象角色：通过接口或抽象类生命真是角色的实现的业务方法。
 *  代理角色：实现抽象角色，是真实角色的代理，通过真实角色的业务逻辑方法实现抽象方法，并可以附加额外操作。
 *  真实角色：实现抽象角色，定义真实角色所需要的业务逻辑，供代理角色调用。
 */
public class ProxyPatterb {


    public static void main(String[] args) {
        Baby baby = new Baby();
        LaoWang laoWang = new LaoWang();
        baby.setAgency(laoWang);
        baby.eat();
        baby.washCloth();
    }

    /**
     * 代理接口
     */
    interface Agency{
        void eat();

        void washCloth();
    }

    /**
     * 真实角色
     */
    static class Baby{
        private Agency agency;

        public Agency getAgency() {
            return agency;
        }

        public void setAgency(Agency agency) {
            this.agency = agency;
        }

        void eat(){
            //喂饭
            agency.eat();
        }

        void washCloth(){
            //洗衣
            agency.washCloth();
        }

    }

    /**
     * 代理实现类
     */
    static class LaoWang implements Agency{

        @Override
        public void eat() {
            System.out.println("老王可以帮孩子洗衣服~~~");
        }

        @Override
        public void washCloth() {
            System.out.println("老王可以帮孩子吃奶~~~~");
        }
    }

}
