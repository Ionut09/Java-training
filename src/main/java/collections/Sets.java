package collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import interfaces.Tiger;

public class Sets {

    public static void main(String... args) {
        User u1 = new User(1, "John");
        User u2 = new User(2, "Joe");
        User u3 = new User(2, "Joe");
        User u4 = new User(2, "Joe");

        Set<User> users = new HashSet<>();
        boolean add = users.add(u1);
        boolean add1 = users.add(u2);
        boolean add2 = users.add(u3);
        boolean add3 = users.add(u4);
        System.out.println(add + "" + add1 + "" + add2 + "" + add3);
        print(users);

        //creation
        Set<Integer> setImmutable = Set.of(1, 2, 3);

        //read
        boolean contains3 = setImmutable.contains(3);
        System.out.println("contains3 = " + contains3);
        boolean containsANewEqualUser = users.contains(new User(2, "Joe"));
        System.out.println("containsANewEqualUser = " + containsANewEqualUser);

        System.out.println(users.contains(new Tiger()));
        System.out.println(users.contains(new Buser(2, "Joe")));

        //delete
        users.remove(u1);
        print(users);
        System.out.println("=========");

        //SortedSets
        //1,2,5,6
        //add 3 --> 1,2,3,5,6
        NavigableSet<User> userSortedSet = new TreeSet<>();
        userSortedSet.add(u1);
        userSortedSet.add(u2);
        userSortedSet.add(u3);
        userSortedSet.add(u4);

        User e = u1;
        ((Comparable) e).compareTo(u2); //implement Comparable in your objects

        Comparator<User> userComparator = (user1, user2) -> Integer.valueOf(user1.getId()).compareTo(user2.getId());
        Comparator<User> userComparator1 = Comparator.comparing(User::getName)
                                                     .thenComparing(Comparator.comparing(User::getId));

        userSortedSet = new TreeSet<>(userComparator1);
        userSortedSet.add(u1);
        userSortedSet.add(u2);
        userSortedSet.add(u3);
        User joeWithId3 = new User(3, "Joe");
        userSortedSet.add(joeWithId3);
        print(userSortedSet);

        //sorted items --> >,<,<=,>=
        userSortedSet.higher(joeWithId3); //User(id=1, name=John)
        userSortedSet.lower(joeWithId3); //User(id=2, name=Joe)
        userSortedSet.ceiling(joeWithId3);
        userSortedSet.floor(joeWithId3);
        System.out.println(userSortedSet.subSet(u2, true, joeWithId3, true));

    }


    static void print(Set<?> set) {
        for (Object o : set) {
            System.out.println(o);
        }
    }
}

class Buser {

    private int id;

    private String name;

    public Buser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buser)) return false;
        Buser buser = (Buser) o;
        return id == buser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}