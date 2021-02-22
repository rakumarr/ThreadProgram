package CreateThead;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerProblem {

    static List<Integer> market = new ArrayList();

    static Random r = new Random(10);

    public static void main(String[] args) {
        System.out.println("Learn Producer Consumer Problem");
        /*
        1. Producer - One Thread
        2. Consumer - One Thread
        3. Market - List (Inventory)
         */
        Thread Producer = new Thread(() -> {
            //Produced items drop in Market

            synchronized (market) {
                while (true) {
                    market.add(r.nextInt());
                    try {
                        System.out.println("Going to wait " + Thread.currentThread().getName());
                        market.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(market.size() + " " + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }

            }

        }, "Producer");
        Runnable consumer = () -> {
            //consumer buy from the Market
            //Market can be empty
            while (true) {
                synchronized (market) {
                    if (market.isEmpty()) {
                        try {
                            System.out.println("go to home" + " " + Thread.currentThread().getName());
                            market.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //wait or go home

                    } else {
                        System.out.println(market.remove(0) + " " + Thread.currentThread().getName());
                        market.notifyAll();
//                        try {
//                            market.wait();
//                            System.out.println("I'm I waiting");
//                            //any 100 of lines
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }

            }

        };

        for (int i = 0; i < 3; i++) {
            Thread Consumer = new Thread(consumer, "Consumer-" + i);
            Consumer.start();
        }

        Producer.start();


    }
}
