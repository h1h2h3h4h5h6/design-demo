package com.example.designdemo.main;

/**
 * 适配器模式
 *  场景：将两种不同的事物联系到一起，例如变压器，假设一个手机充电器需要的电压是20V，
 *  但是正常的电压是220V，这时候就需要一个变压器，将220V的电压转换成20V的电压
 *  ，变压器就将20V的电压和手机联系起来了。
 */
public class Adapter {

    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }

    /**
     * 手机类
     */
    static  class  Phone{
        public static final int V= 220;//正常电压，常量

        private VoltageAdapter adapter;

        public void charge(){
            adapter.changeVoltage();
        }

        public void setAdapter(VoltageAdapter adapter){
            this.adapter = adapter;
        }
    }

    /**
     * 适配器 改变原定值
     */
    static class VoltageAdapter{
        public void changeVoltage(){
            System.out.println("正在充电...");
            System.out.println("原始电压：" + Phone.V + "V");
            System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
        }
    }
}
