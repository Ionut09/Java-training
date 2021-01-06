package collections;

@FunctionalInterface //compiler
public interface FunctionalInterfaceCustom {

    default void doNothing() {
    }

    public abstract void abstractMethod();

//    void abstractMethod(int a);
}
