import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {

    public static void main(String[] args){
        List<String> names = Arrays.asList("John", "Alice", "Bob");

        //anonymous impl
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(String name : names){
            System.out.println(name);
        }

        //lambda expressions
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        for(String name : names){
            System.out.println(name);
        }

        //method reference
        Collections.sort(names, String::compareTo);
        for(String name : names){
            System.out.println(name);
        }
    }
}
