package com.test;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    HashMap<A,String> map = new HashMap<>();

    public class A{

//        @Override
//        public int hashCode() {
//            return 2;
//        }
    }

    @Test
    public void testThread(){
        System.out.println(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread a before");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread a");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread b before");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread b");
            }
        }).start();
    }

    @Test
    public void testThread1(){
        A a = new A();
        System.out.println(a.hashCode());
        System.out.println(a.hashCode()%8);
        map.put(a,"helli");
        System.out.println(map.get(a));

        A b = new A();
        System.out.println(b.hashCode());
        System.out.println(b.hashCode()%8);
        map.put(b,"hggg");
        System.out.println(map.get(b));

    }

    /**
     * java中的sleep()和wait()的区别
     */

    @Test
    public void main1() {
        new Thread(new Thread1()).start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

    public class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized (ExampleUnitTest.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    ExampleUnitTest.class.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    public class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized (ExampleUnitTest.class) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                ExampleUnitTest.class.notify();
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }
}