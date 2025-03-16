import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintExample {

    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(2,3,6,1,8,4,0,11,67,21,35);

        //anonymous implementation
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //lambda expression
        numbers.forEach(x -> System.out.println(x));

        //method reference
        numbers.forEach(System.out::println);
    }
}
