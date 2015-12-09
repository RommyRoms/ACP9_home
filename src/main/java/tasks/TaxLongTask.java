package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mayun8 on 09.12.2015.
 */
public class TaxLongTask {
    private static List<Map<Tax,Long>> maps;
    private static Map<Tax,Long> taxLongMap;

    public static void main(String[] args) {
        Map<Tax,Long> m1 = new HashMap<>();
        m1.put(new Tax(1),100L);
        m1.put(new Tax(2),200L);
        m1.put(new Tax(3),300L);

        Map<Tax,Long> m2 = new HashMap<>();
        m2.put(new Tax(1),100L);
        m2.put(new Tax(3),300L);
        m2.put(new Tax(4),400L);


        Map<Tax,Long> m3 = new HashMap<>();
        m3.put(new Tax(1),100L);
        m3.put(new Tax(2),200L);
        m3.put(new Tax(4),400L);

        maps = new ArrayList<>();
        maps.add(m1);
        maps.add(m2);
        maps.add(m3);

        taxLongMap = new HashMap<>();

        for (Map<Tax, Long> map : maps) {
            map.entrySet().forEach(entry ->{
                 if (!taxLongMap.containsKey(entry.getKey())){
                     taxLongMap.put(entry.getKey(),entry.getValue());
                 }else taxLongMap.put(entry.getKey(),taxLongMap.get(entry.getKey())+entry.getValue());
            });
        }

        System.out.println(taxLongMap);
    }
}
