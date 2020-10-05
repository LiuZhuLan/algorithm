package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 输入: [1,3,2]
 * 输出: "firstsecondthird"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
 * 正确的输出是 "firstsecondthird"。
 *
 * 解题方式：
 * 1、原子类
 * 2、带volatile关键字的变量
 * @author LiuZhulan
 */
public class PrintByOrder extends Thread{


    Runnable first = () -> System.out.println("first");
    Runnable second = () -> System.out.println("second");
    Runnable third = () -> System.out.println("third");

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public void first(Runnable runnable) {

        runnable.run();
        atomicInteger.incrementAndGet();
    }

    public void second(Runnable runnable) {
        while (atomicInteger.get() != 1) {
        }
        runnable.run();
        atomicInteger.incrementAndGet();
    }

    public void third(Runnable runnable) {

        while (atomicInteger.get() != 2) {
        }
        runnable.run();
    }

    /**
     *  表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法
     *  无论哪个线程先执行，都是按first、second、third的顺序输出
     */
    public void startThread (){
        new Thread(() -> first(first)).start();
        new Thread(() -> third(third)).start();
        new Thread(() -> second(second)).start();
    }

    public static void main(String[] args) {

        PrintByOrder p = new PrintByOrder();
        p.startThread();

    }
}
