package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 新华三 现场笔试题目中的
 * 使用 ReentrantLock 和 Condition实现一个阻塞队列
 */
public class BlockingQueue {

    //数据对象
    private Object[] data;
    //当前数据对象含有多少个数据
    private int count = 0;
    //当前add数据的索引位置
    private int addPosition = 0;
    //当前take数据的索引位置
    private int takePosition = 0;

    //线程锁
    private Lock lock = new ReentrantLock();

    //添加条件
    private Condition addCondition = lock.newCondition();
    //取出条件
    private Condition takeCondition = lock.newCondition();

    public BlockingQueue(int size){
        data = new Object[size];
    }

    public void add(Object value){
        lock.lock();
        try{
            while(count == data.length){
                try {
                    addCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(addPosition == data.length){
                addPosition = 0;
            }
            data[addPosition] = value;

            System.out.println("add:" + value + "add index:" + addPosition + " thread name:" + Thread.currentThread().getName());

            addPosition++;
            count++;

            takeCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public Object take(){
        lock.lock();
        Object value = null;

        try{
            while (count == 0){
                try {
                    takeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (takePosition == data.length){
                takePosition = 0;
            }
            value = data[takePosition];
            System.out.println("take:" + value + "take index:" + takePosition + "thread name:" + Thread.currentThread().getName());

            takePosition++;
            count--;
            addCondition.signalAll();

        }finally {
            lock.unlock();
        }
        return value;
    }


    public static void main(String[] args) {

            final BlockingQueue blockingQueue = new BlockingQueue(2);

            for (int i = 0; i< 5;i++){
                new Thread(){
                    @Override
                    public void run() {
                        double random = Math.random();
                        blockingQueue.add(random);
                    }
                }.start();
            }

            //休息5秒之后 ，开启新的线程从阻塞队列取数据
            try {
                Thread.sleep(5000);
            }catch(Exception e){
                e.printStackTrace();
            }

            new Thread(){
                @Override
                public void run() {
                    Object take = blockingQueue.take();
                }
            }.start();
        }

    }