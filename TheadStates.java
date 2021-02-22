package CreateThead;

public class TheadStates {


        /*
        New object Thread
        started - as a program, just start a thread - JVM controls state
        What properties you can give to the Thread?
        1. Daemon
        2. Give Priority
        3. Set Name of the Thread
        4.

         */

    //2ways of creating thread
    // Extending the Thread class
    //Another pass a Task to a Thread Object;

    //.
    static class Test extends Thread {
        @Override
        public void run() {
            System.out.println("I'm new thread");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Learn Thread States");
//        Test t = new Test();
//        t.start();

        Runnable r = () -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("I'm inside the Thread "+Thread.currentThread().getName());
            }
        };

        Thread t1 = new Thread(() -> {} , "New Thread-1");
        Thread t2 = new Thread(r, "New Thread-2");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t1.join();
        t2.start();

        t2.join();
        System.out.println("Learn Thread States End");
    }
}
