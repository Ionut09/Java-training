package collections;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@ToString       //all lombok annotations that deal with properties have option of inclusion
@Getter
@Setter
public class User implements Comparable<User>{

    //  @EqualsAndHashCode.Include
    private int id;

    @EqualsAndHashCode.Exclude
    private String name;

    public int compareTo(User other) {
        return name.compareTo(other.name); //because we are in the class
    }
}