import java.util.function.*;

public class FunctionalInterfaceTester {

    public static void main(String[] args){

        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isEven.test(5));

        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Akhil"));

        Supplier<Double> generator = () -> Math.random();
        System.out.println(generator.get());

        Consumer<Integer> print = x -> System.out.println(x);

        print.accept(15);

        BinaryOperator<Integer> add = (a,b) -> a+b;

        add.apply(10,12);

        Flyable flying = new Flyable() {
            @Override
            public void fly() {
                System.out.println("Flight");
            }
        };

        Flyable flyable = () -> System.out.println("We are flying");

        flyable.fly();

        FlyableImpl f = new FlyableImpl();
        f.fly();
    }
}
