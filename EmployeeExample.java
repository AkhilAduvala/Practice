import java.util.function.BiFunction;
import java.util.function.Function;

public class EmployeeExample {

    public static void main(String[] args){

        //anonymous impl for creating obj using Function & BiFunction

        Function<String, Employee> createEmployee = new Function<String, Employee>() {
            @Override
            public Employee apply(String s) {
                return new Employee(s);
            }
        };

        BiFunction<Integer, String, Employee> createEmp = new BiFunction<Integer, String, Employee>() {
            @Override
            public Employee apply(Integer x, String y) {
                return new Employee(x, y);
            }
        };

        //lambda expression
        Function<String, Employee> create_Employee = s -> new Employee(s);

        BiFunction<Integer, String, Employee> createEmp1 = (x, y) -> new Employee(x, y);

        //method reference
        Function<String, Employee> _Create_Employee = Employee::new;

        BiFunction<Integer, String, Employee> createEmp2 = Employee::new;


        //calling the createemployee function

        Employee e = createEmployee.apply("Akhil");
        e.display();

        Employee e1 = create_Employee.apply("Ash");
        e1.display();

        Employee e2 = _Create_Employee.apply("AkHi");
        e2.display();

        Employee e3 = createEmp.apply(1, "Akhil");
        e3.display();

        Employee e4 = createEmp1.apply(2, "Ash");
        e4.display();

        Employee e5 = createEmp2.apply(3, "AkHi");
        e5.display();

    }
}
