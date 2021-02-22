package CreateThead;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingProducerConsumer {

    static BlockingQueue<Integer> market = new ArrayBlockingQueue<Integer>(10);

    static Random r = new Random(1);

    public static void main(String[] args) {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        market.put(r.nextInt());
                        System.out.println(market.size()+ " "+ Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Producer");

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        System.out.println(market.take()+ " "+ Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, "Consumer");

        consumer.start();
        producer.start();

    }

}
