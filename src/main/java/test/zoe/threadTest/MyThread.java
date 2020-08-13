package test.zoe.threadTest;

/**
 * @author Zoe
 * @date 2020/7/2 下午8:26
 */
// Demo1.java的源码
class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i=0;
            // 1. isInterrupted()保证，只要中断标记为true就终止线程。
            while (!isInterrupted()) {
                Thread.sleep(100); // 休眠100ms
                i++;
                System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
            }
        } catch (InterruptedException e) {
            // 2. InterruptedException异常保证，当InterruptedException异常产生时，线程被终止。
            System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
        }
    }
}
