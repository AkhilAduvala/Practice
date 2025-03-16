import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(3,1,8,7,2,3,9,4,6,5,1,2,7,6,9,2,0,5,7,1);
        List<String> heros = Arrays.asList("Bob", "Ntr", "Bhaai", "Venky", "Nag", "Boss", "Charan", "Prabhas");
        List<String> cities = Arrays.asList("wgl", "hnk", "pkl", "wgl", "khmn", "wgl", "hnk", "hyd", "wgl");
        List<String> names = Arrays.asList(null, "", null, "", "", "AkHi", "Ash");
        List<Employee> employees = new ArrayList<>();
        Employee e = new Employee(1, "A");
        Employee e1 = new Employee(2, "AB");
        Employee e2 = new Employee(3, "ABC");
        Employee e3 = new Employee(4, "AkHi");
        Employee e4 = new Employee(5, "Akhil");
        employees.add(e);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        List<List<Integer>> numLists = Arrays.asList(
                Arrays.asList(1,2,3,4), Arrays.asList(2,5,8), Arrays.asList(9,7,3)
        );
        String chars = "ababscjhda";


        //some basic streams problems

        //filtering even numbers
        List<Integer> evensNumbers = numbers.stream()
                .filter(x -> x%2 == 0)
                .toList();

        System.out.println("Here are the even numbers form the list : " + evensNumbers);

        //convert list of strings to uppercase
        List<String> herosUpperCase = heros.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Here are the uppercase converted list of heros : " + herosUpperCase);

        //find the first element that starts with "N"
        Optional<String> firstN = heros.stream()
                .filter(x -> x.startsWith("N"))
                .findFirst();

        System.out.println("Here are the first hero with N, got using findFirst() : " + firstN);

        List<String> nFirst = heros.stream()
                .filter(x -> x.startsWith("N"))
                .limit(1)
                .collect(Collectors.toList());

        System.out.println("Here are the first hero with N, got using limit() : " + nFirst);

        //sum of all elements
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println("sum of all the elements : " + sum);

        //count words with length > 3
        long count = heros.stream()
                .filter(s -> s.length() > 3)
                .count();

        System.out.println("no of heros with name length > 3 : " + count);

        //sorting numbers in desc
        List<Integer> numbersDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Numbers stored in desc : " + numbersDesc);

        //remove duplicates from list
        List<Integer> distinctNumbers = numbers.stream()
                .distinct().toList();

        System.out.println("Distinct numbers list : " + distinctNumbers);

        //convert list of strings to a single comma-seperated string using reduce
        Optional<String> appendedString = heros.stream()
                .reduce((a,b) -> a + ',' + b);

        System.out.println("Appended String using reduce : " + appendedString);

        //convert list of strings to a single comma-seperated string using Collectors.joining
        String stringAppended = heros.stream()
                .collect(Collectors.joining(","));

        System.out.println("Appended String using Collectors.joining : " + stringAppended);

        //find the max value
        Optional<Integer> maxValue = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Max value from the list : " + maxValue);

        //check if any string start with "A"
        boolean startsWithA = heros.stream()
                .anyMatch(s -> s.startsWith("A"));

        System.out.println("Check if any string starts with A : " + startsWithA);

        //intermediate streams problems

        //find the second highest number from the list

        List<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .skip(1)
                .toList();

        System.out.println(secondHighest);

        //count occurrences of each word in a list

        Map<String, Long> occurence = cities.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(occurence);

        //Remove null and empty values from a list
        List<String> valuedList = names.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .toList();

        System.out.println(valuedList);

        //find the lomgest word in a list
        List<String> longest = heros.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(1)
                .collect(Collectors.toList());

        System.out.println(longest);

        Optional<String> longestName = heros.stream()
                .max(Comparator.comparingInt(String::length));


        System.out.println(longestName);

        //convert a list of Strings to a map

        Map<String, Integer> herosMap = heros.stream()
                .collect(Collectors.toMap(s -> s, String::length));

        //convert a list of object to a map
        Map<Integer, String> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getEmployeeId, Employee::getEmployeeName));

        System.out.println(employeeMap);

        //flatten a list of lists into a single list
        List<Integer> numList = numLists.stream()
                .flatMap(List::stream)
                .toList();

        //list the empolyee whos id is greater than 2
        List<Employee> lateJoiners = employees.stream()
                .filter(x -> x.getEmployeeId() > 2)
                .toList();

        //group a list of numbers into even and odd
        Map<Boolean, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(evenOddMap);

        //List Employee Names Who Have Salary Greater Than the Average
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0); // Handle empty case

        List<String> highEarners = employees.stream()
                .filter(emp -> emp.getSalary() > avgSalary)
                .map(Employee::getEmployeeName)
                .collect(Collectors.toList());

        //List Employees and Role Who Work from Hyderabad Location
        Map<String, String> hydEmployees = employees.stream()
                .filter(emp -> "Hyderabad".equalsIgnoreCase(emp.getLocation()))
                .collect(Collectors.toMap(Employee::getEmployeeName, Employee::getRole));


        // Find ID, Employee, and Salary of the Employee Who Has the Highest Salary at Each Location
        Map<String, Optional<Employee>> topEarnersByLocation = employees.stream()
                .collect(Collectors.groupingBy(Employee::getLocation,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        Map<String, Employee> topEarners = topEarnersByLocation.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(null)));


    }
}
