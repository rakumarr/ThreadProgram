package CreateThead;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapLearn {

    static Random r = new Random(1);

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
//        Map<Integer, Integer> map = new HashMap();
//
        new Thread(() -> {
            while (true) {
                map.put(r.nextInt(), r.nextInt());
            }

        }).start();
        new Thread(() -> {
            map.get(r.nextInt());
            for (Integer i : map.keySet()) {
                System.out.println(map.get(i));
            }
        }).start();

    }

}
