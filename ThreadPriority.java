package CreateThead;

public class ThreadPriority {

    public static void main(String[] args) {
        System.out.println("Main Thread start");
        Thread t = new Thread(() -> {
            System.out.println("Thread start"+Thread.currentThread().getName());
            Thread t2 = new Thread(() -> {
                System.out.println("Thread start"+Thread.currentThread().getName());
                execute();
            }, "Thread 2");
//            t2.setDaemon(true);
            t2.start();
            execute();
        }, "Thread 1");
        t.setDaemon(true);
        t.start();
//        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread end");

    }

    public static void execute(){
        for(int i = 0;i<10;i++){
            System.out.println(i+Thread.currentThread().getName());
        }
    }
}
