package generics;

import interfaces.Tiger;

public class WrappingPresents {

    public static void main(String... args) {
        Box<String> stringBox = new Box<>();
//        Box.staticContent; //Object
        stringBox.setContent("chocolate");

        var tigerBox = new Box<Tiger>();
        tigerBox.setContent(new Tiger());
        var content = tigerBox.getContent();
    }
}
