package generics;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import interfaces.Tiger;

public class RawType extends ArrayList{

    public static void main(String... args) {
        ArrayList list =  new ArrayList();
        Object list1 = list;
        list1 = "asdfghj";
        list1 = 12;

        list.add("one"); //Object
        list.add(100); //Object
        list.add(new Tiger()); //Object
        list.add(new int[0]); //Object

        String o = (String)list.get(0);

//        ArrayList<String> ls =  new ArrayList<String>(); //before Java 7
        ArrayList<String> ls =  new ArrayList<>();          //after Java 7

        //when assigning 2 generics they have to match exactly
        ls.add("one");
//       ls.add(new Tiger());

        String s = ls.get(0);

        List<String> l = new ArrayList();

    }
}
