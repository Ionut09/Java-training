package generics;

public class MathBox<T extends Number> { //T is limited to classes that extend Number

    private T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {//in Java everything is an Object
        content.toString();
        double doubleValue = content.doubleValue();
        this.content = content;
    }

    public static void main(String... args) {
        MathBox<Integer> integerMathBox = new MathBox<>();
        integerMathBox.getContent();
        integerMathBox.setContent(13456);

//      MathBox<String> st = new MathBox<>();


    }
} 

         
