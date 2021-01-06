package collections;

import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class Maps {

    public static void main(String... args) {
        //creating maps
        Map<String, String> names = new HashMap<>();
        //add
        names.put("John", "Doe");
        names.put("Joe", "Doe");
        names.put("Joe", "Dow"); //override the existing key

        //String apply(String key)     R apply(T t);
        names.computeIfAbsent("Paul", key -> key + "Schiller");
        names.computeIfPresent("Paul", (key, value) -> value + " The One");
        System.out.println(names);

        //read
        String joe = names.get("Joe"); //value
        System.out.println("joe = " + joe);

        Set<Map.Entry<String, String>> entries = names.entrySet();
        entries.forEach(System.out::println);

        System.out.println(names.getOrDefault("4567", "Anonymous"));
        boolean jOhn = names.containsKey("JOhn");
        boolean containsValueDoe = names.containsValue("Doe"); //O(n)

        //update
        names.replace("Paul", "Schiller");
        names.replace("Paul", "Schiller");
        System.out.println(names);

//       String apply(String key, String value)
        names.replaceAll((k, v) -> v.toUpperCase());
        System.out.println(names);

        //DELETE
        String joe1 = names.remove("Joe");
        System.out.println(joe1);


        //TreeMaps
        NavigableMap<String, String> names1 = new TreeMap<>(Comparator.reverseOrder());
        names1.put("John", "Doe");
        names1.put("Joe", "Doe");
        names1.put("Joe", "Dow");

        System.out.println(names1);

        names.size();       // if (names.size() == 0)
        names.isEmpty();    // if(names.isEmpty())

        if (CollectionUtils.isEmpty(names)) {  //avoids NPE

        }
    }
}
