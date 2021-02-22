package CreateThead;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExceutorFramworkLearn {

    static BlockingQueue<Integer> market = new ArrayBlockingQueue<>(10);
    static Random r = new Random(1);

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        Runnable producer = () -> {
            while(true){
                try {
                    market.put(r.nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(market.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while(true){
                try {
                    System.out.println(market.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        executor.execute(producer);
        executor.execute(consumer);




    }

}
