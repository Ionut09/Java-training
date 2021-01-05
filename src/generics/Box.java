package generics;

public class Box<T> {

    private T content;
//    private static T staticContent;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {//in Java everything is an Object
        content.toString();
//        T t = new T();
        this.content = content;
    }
    //? super Integer
    //Number
} 

         
