package tasks;

import java.util.*;

/**
 * Created by mayun8 on 14.12.2015.
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");


        List list = new ArrayList<>(map.entrySet());
        System.out.println(list);
    }
}
