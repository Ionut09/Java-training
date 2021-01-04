package oop;

public class House {

    private String color; //field --> null by default

    int floors; //0 by default
    double price; //0.0 by default
    boolean isVilla; //false by default

    //public,
    // protected,
    // [default], --> it's visible only in the package
    // private --> visible only inside the enclosing class

    public House(String color) {
        if(color.equals("weird")){
            throw new IllegalArgumentException("Weird color");
        }
        this.color = color;
    }


    //legal but not right
//    public void House(String color) {
//        if(color.equals("weird")){
//            throw new IllegalArgumentException("Weird color");
//        }
//        this.color = color;
//    }

    House() {
        //this() can be used only inside another constructor
        this("white");
    }

    /**
     * this refers to current object
     */
    public String getColor() {
        String color;
//        System.out.println("color = " + color);
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
