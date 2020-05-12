package com.example.designdemo.main;

/**
 * 生产者/消费者模式
 *  场景：超市购物
 *  描述：生产者-仓储-消费者 ,生产者消费者为两个独立并发体，通过缓存区作为桥梁连接
 *   1、生产者仅仅在仓储未满时候生产，仓满则停止生产。
     2、消费者仅仅在仓储有产品时候才能消费，仓空则等待。
     3、当消费者发现仓储没产品可消费时候会通知生产者生产。
     4、生产者在生产出可消费产品时候，应该通知等待的消费者去消费
 */
public class ProducerConsumer {


    public static void main(String[] args) {
        SyncStack stack = new SyncStack();
        Consumer p = new Consumer(stack);
        Producter c = new Producter(stack);
        new Thread(p).start();
        new Thread(c).start();

    }

    /**
     * 仓储 - 共享数据区域
     */
    static class SyncStack{

        private String[] str = new String [10];

        private int index;//记录数

        //供生产者调用
        public synchronized void push(String sst){
            if(sst.length() == index){
                 try {
                     wait();//阻塞
                 }catch (Exception e){
                     e.printStackTrace();
                 }
            }
            this.notify();//唤醒单线程
            str[index] = sst;
            index++;
        }

        //供消费者调用
        public synchronized String pop(){
            if(0 == index){
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            this.notify();
            index--;
            return str[index];
        }

        //返回String[] 引用
        public String[] pro(){
            return str;
        }
    }

    /**
     * 创建生产者
     */
    static class Producter implements Runnable{
        private SyncStack stack;

        public Producter(SyncStack stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            for(int i = 0;i <stack.pro().length;i++){
                String producter = "冰淇淋" +i;
                stack.push(producter);
                System.out.println("新做的" + producter);
                try {
                    Thread.sleep(200);//休眠
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者
     */

    static class Consumer implements Runnable{

        private SyncStack stack;

        public Consumer(SyncStack stack) {
            this.stack = stack;
        }

        @Override
        public void run() {
            for(int i =0;i<stack.pro().length;i++){
                String consumer = stack.pop();
                System.out.println("吃掉了" + consumer );
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
