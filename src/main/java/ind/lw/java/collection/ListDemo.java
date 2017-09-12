package ind.lw.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class ListDemo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {

        System.out.println(tableSizeFor(257));





        ArrayList<String> arrayList = new ArrayList(1);

        arrayList.add("test1");
        arrayList.add("test2");
        arrayList.add("test3");
        arrayList.add("test4");
        arrayList.add("test5");
        arrayList.add("test6");


        LinkedList linkedList = new LinkedList();

        Vector<String> vector = new Vector<>();

        ConcurrentHashMap concurrentHashMap;
        Hashtable hashtable;

        TreeMap treeMap = new TreeMap();

        treeMap.put("java","good");
        treeMap.put("c","ok");
        treeMap.put("python","wo");
        treeMap.put("scala","en");


        NavigableSet keySet = treeMap.descendingKeySet();

        Iterator it = keySet.iterator();

        while (it.hasNext()){
            System.out.println(treeMap.get(it.next()));
        }

        NavigableMap newTreeMap = treeMap.descendingMap();


        newTreeMap.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("k:"+o+",v:"+o2);
            }
        });

        treeMap.forEach(new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                System.out.println("k:"+o+",v:"+o2);
            }
        });

    }


}
