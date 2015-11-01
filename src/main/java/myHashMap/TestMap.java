package myHashMap;

import java.util.Map;

/**
 * Created by ro on 30.09.2015.
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> myMap= new MyHashMap<>();
        myMap.put(1,"One");
        myMap.put(2,"Two");
        myMap.put(3, "Three");

        System.out.println("complite");

        System.out.println(myMap.containsKey(1)+"containskey 1");
        System.out.println(myMap.containsKey(2)+"containskey 2");
        System.out.println(myMap.containsValue("Three")+"containsvalue Three");

        System.out.println(myMap.get(2));
        System.out.println(myMap.get(1));

        System.out.println(myMap.remove(2)+" complete");



    }
}
