package com.example.designdemo.main;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *  场景： 对象为一对多的依赖关系，当一个对象的状态改变时，所有依赖于它的对象都得到通知并被自动更新
 */
public class Observer {

    public static void main(String[] args) {
        XiaoMei xiaoMei = new XiaoMei();
        LaoWang laoWang = new LaoWang();
        XiaoWang xiaoWang = new XiaoWang();

        //添加依赖关系
        xiaoMei.addPerson(laoWang);
        xiaoMei.addPerson(xiaoWang);

        //发送改变通知
        xiaoMei.notifyPerson();
    }

    //消息接口
    interface Person{
        //老王跟小王通过接口接收小美发送的消息
        void getMessage(String message);
    }

    /**
     * 依赖对象 1
     */
    static class LaoWang implements Person{

        private String name = "老王本王";

        public LaoWang() {
        }

        @Override
        public void getMessage(String message) {
            System.out.println(name+"接到了小美邀请，内容是："+message);
        }
    }

    /**
     * 依赖对象 2
     */
    static class XiaoWang implements Person{

        private String name = "老王唯一的子嗣";

        public XiaoWang() {
        }

        @Override
        public void getMessage(String message) {
            System.out.println(name+"也接到了小美邀请，内容是："+message);
        }
    }

    /**
     * 被依赖对象
     */
    static class XiaoMei{
        List<Person> list = new ArrayList<Person>();

        public XiaoMei() {
        }

        public void addPerson(Person Person){
            list.add(Person);
        }

        //发送通知
        public void notifyPerson(){
            for(Person person:list){
                person.getMessage("你们过来吧，谁先过来就能陪我一起玩游戏");
            }
        }
    }

}
