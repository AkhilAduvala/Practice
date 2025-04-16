import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FITester {

    public static void main(String[] args){
        Greetings greetings = new Greetings() {
            @Override
            public void greet() {
                System.out.println("Hello, this is from anonymous impl");
            }
        };

        greetings.greet();

        Greetings greeting = () -> System.out.println("Hello, from lambda expressions");

        greeting.greet();

        //Sort a list of strings in ascending order using Comparator<String> in three different ways.

        List<String> names = Arrays.asList("Ntr", "Akhil", "Boss", "Bhaai", "Bob", "Cherry");

        //anonymous impl
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(names);

        List<String> hero = Arrays.asList("Ntr", "Akhil", "Boss", "Bhaai", "Bob", "Cherry");

        //lambda
        Collections.sort(hero, (x,y) -> x.compareTo(y));

        System.out.println(hero);

        List<String> theBoys = Arrays.asList("Ntr", "Akhil", "Boss", "Bhaai", "Bob", "Cherry");

        //method reference
        Collections.sort(theBoys, String::compareTo);

        System.out.println(theBoys);

        //Iterate over a list of integers and print each value.

        List<Integer> numbers = Arrays.asList(3,5,8,4,7,1,9);

        //anonymous impl
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        List<Integer> rankings = Arrays.asList(5,3,8,1,6,4,7,2);

        //lambda
        rankings.forEach((i) -> System.out.println(i));

        List<Integer> integers = Arrays.asList(8,1,6,7,2,5,3,4);

        //method reference
        integers.forEach(System.out::println);

        // Create a class Employee with a constructor and instantiate an object.
        //anonymous
        Function<String, Employee> createEmployee = new Function<String, Employee>() {
            @Override
            public Employee apply(String s) {
                return new Employee(s);
            }
        };

        Employee e1 = createEmployee.apply("Akhil Aduvala");
        e1.display();

        //lambda
        Function<String, Employee> createEmp = (s) -> new Employee(s);

        Employee e2 = createEmp.apply("Akhil");
        e2.display();

        //method reference
        Function<String, Employee> createEmpObj = Employee::new;
        Employee e3 = createEmpObj.apply("AA");
        e3.display();


        //Create a StringModifier functional interface to convert a string to uppercase.
        //Anonymous  impl

        StringModifier upperCaseImpl = new StringModifier() {
            @Override
            public String upperCase(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println("after conversion " + upperCaseImpl.upperCase("akhil"));

        //lambda
        StringModifier modifierImpl = (s) -> s.toUpperCase();

        System.out.println("after conversion using lambda " + upperCaseImpl.upperCase("akhil"));

        //method reference
        StringModifier modifier = String::toUpperCase;
        System.out.println("after conversion using method reference " + upperCaseImpl.upperCase("akhil"));

        //Create a MaxFinder functional interface to return the maximum of two numbers.
        //anonymous impls
        MaxFinder max1 = new MaxFinder() {
            @Override
            public int findMax(int x, int y) {
                return Math.max(x, y);
            }
        };

        System.out.println("out of 5 & 10 using anonymous, we have mas :" + max1.findMax(5,10));

        //lambda
        MaxFinder max2 = (x,y) -> Math.max(x, y);
        System.out.println("out of 15 & 10 using lambda, we have mas :" + max2.findMax(15,10));

        //method reference
        MaxFinder max3 = Math::max;
        System.out.println("out of 15 & 20 using method reference, we have mas :" + max3.findMax(15,20));

        //Create a NumberChecker functional interface to check if a number is even.
        //anonymous impl
        NumberChecker numCheck = new NumberChecker() {
            @Override
            public boolean isEven(int x) {
                return x % 2 == 0;
            }
        };

        System.out.println(numCheck.isEven(5));

        //lambda
        NumberChecker numberCheck = (x) -> x % 2 == 0 ;

        System.out.println(numberCheck.isEven(4));

        //method reference
        NumberChecker numberChecker = NumberCheckerImpl::isEven;
    }
}
