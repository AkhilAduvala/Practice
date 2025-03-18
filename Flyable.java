@FunctionalInterface
public interface Flyable {

    void fly();

    default void print(){
        System.out.println("Inside flyable interface");
    }

    static void high(){
        System.out.println("Flying high");
    }

}
