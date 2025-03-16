import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsConcept {

    public static void main(String[] args){

        //creating stream from any collection

        List<String> names = Arrays.asList("Akhil", "Ashwidhi", "Chaitanya", "Srinivas", "Sridevi");
        Stream<String> namesStream = names.stream();
        Stream<String> namesParellelStream = names.parallelStream();

        Map<String, Integer> ranking = new HashMap<>();
        ranking.put("bob", 10000);
        ranking.put("NTR", 8000);
        ranking.put("Boss", 6000);

        Stream<String> heros = ranking.keySet().stream();

        Stream<Integer> salary = ranking.values().stream();

        Stream<Map.Entry<String, Integer>> entryStream = ranking.entrySet().stream();

        //creating stream from known values
        Stream<String> family = Stream.of("Akhil", "Ashwidhi", "Chaitanya", "Srinivas", "Sridevi");

        //creating stream from array
        int[] array = {1,2,3,4,5};
        //Stream<Integer> numbers = (Stream<Integer>) Arrays.stream(array);

        String[] city = {"wgl", "hyd", "tg", "ap"};
        Stream<String> cityStreams = Arrays.stream(city);

        //create infinite stream using iterate
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        Stream<Integer> limitedStream = infiniteStream.limit(5);
        limitedStream.forEach(System.out::println);

        //create infinite stream using generate
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(3);
        randomNumbers.forEach(System.out::println);

        //create empty stream
        Stream<String> emptyStream = Stream.empty();

        //create stream from i/o
        Path filePath = Paths.get("data.txt");
        try (Stream<String> fileStream = Files.lines(filePath)) {
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //INTERMEDIATE OPERATIONS
        //filter() → Used for Filtering Elements
        List<String> neighbours = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Filter names that start with "A"
        List<String> filteredNeighbours = neighbours.stream()
                .filter(s -> s.startsWith("A")).
                collect(Collectors.toList());

        System.out.println(filteredNeighbours);

        //map() → Used for Transformation
        List<Integer> numerics = Arrays.asList(1,2,3,4,5,6);

        // transform all the values to square & roots
        List<Integer> sqr = numerics.stream().map(x -> x*x).collect(Collectors.toList());

        System.out.println(sqr);

        List<Double> sqrt = numerics.stream().map(Math::sqrt).toList();

        System.out.println(sqrt);

        // flatMap() → Used for Flattening Streams

        List<List<String>> namesList = Arrays.asList(
                Arrays.asList("Alice", "Bob"),
                Arrays.asList("Charlie", "David")
        );

        // Flatten the list of lists, Used when working with nested structures
        // (e.g., lists inside lists). It flattens multiple elements into a single stream.

        List<String> faltenedList = namesList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(faltenedList);

        //distinct() → Removes Duplicates

        List<Integer> nums = Arrays.asList(1, 2, 3, 2, 4, 3, 5);

        //remove duplicates

        List<Integer> distinctNumber = nums.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctNumber);

        //sorted() → Sorting Elements

        List<String> namesDummy = Arrays.asList("David", "Alice", "Charlie", "Bob");

        //sorted in natural order
        List<String> sortedNames = namesDummy.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames);

        //sorted in reverse order
        List<String> reverseOrder = namesDummy.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(reverseOrder);

        //sorted in custom comparing
        List<String> sortedByLen = namesDummy.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        System.out.println(sortedByLen);

        //peek() → Used for Debugging
        //Performs debugging/logging without modifying the stream elements.

        List<String> debug = namesDummy.stream()
                .peek(s -> System.out.println(s))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //limit() → Used for Truncating the Stream

        List<String> naturalNames = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        //get first 3 names
        List<String> limited = naturalNames.stream()
                .limit(3)
                .toList();

        System.out.println(limited);

        //skip() → Used for Skipping Elements

        //skip first 3 and get remaining 3
        List<String> skippedLimitted = naturalNames.stream()
                .skip(2)
                .limit(3)
                .toList();

        System.out.println(skippedLimitted);

        //TERMINAL OPERATORS
        //collect() → Convert Stream to List, Set, or Map
        List<String> namesAgain = Arrays.asList("Alice", "Bob", "Charlie", "Bob");

        //convert and collect as list
        List<String> nameList = namesAgain.stream().collect(Collectors.toList());
        System.out.println(nameList);

        //convert and collect as set
        Set<String> namesSet = namesAgain.stream().collect(Collectors.toSet());
        System.out.println(namesSet);

        //convert and collect as map
        Map<String, Integer> namesMap = namesAgain.stream().collect(Collectors.toMap(s -> s, String::length, (existing, replacement) -> existing));
        System.out.println(namesMap);

        //toList() (Java 16+) → Simpler Way to Convert to a List (immutable)
        //more concise way for .collect(Collectors.toList())
        List<String> listNames = namesAgain.stream().toList();
        System.out.println(listNames);

        //forEach() → Perform Action on Each Element
        namesAgain.stream().forEach(System.out::println);

        //reduce() → Combine Elements to a Single Value
        List<Integer> num = Arrays.asList(1,3,4,5,8,9,2);
        int sum = num.stream().reduce(0, Integer::sum);
        int max = num.stream().reduce(0, Integer::max);

        System.out.println(sum);
        System.out.println(max);

        //count() → Get Number of Elements, returns no of elements after applying filters
        long count = namesAgain.stream()
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(count);

        //findFirst() → Get First Element (Optional)
        Optional<String> firstElement = namesAgain.stream().findFirst();

        //findAny() → Get Any Element (Useful for Parallel Streams)
        Optional<String> any = namesAgain.stream().findAny();
        Optional<String> anyThing = namesAgain.parallelStream().findAny();

        //allMatch(), anyMatch(), noneMatch() → Condition Checking
        List<Integer> nos = Arrays.asList(10, 20, 30, 40);

        //allMatch() -> check if all elements are greater than 5
        boolean allGreater = nos.stream()
                .allMatch(x -> x>5);

        //noneMatch() -> check if no element mataches
        boolean allSmall = nos.stream()
                .noneMatch(x -> x<5);

        //anyMatch() -> check if atleast one matches
        boolean anyMatch = nos.stream().anyMatch(x -> x == 10);

        // min() & max() → Find Minimum and Maximum
        Optional<Integer> minimum = nos.stream().min(Integer::compareTo);
        Optional<Integer> maximum = nos.stream().max(Integer::compareTo);

        //toArray() → Convert Stream to Array
        String[] createdArray = namesAgain.stream().toArray(String[]::new);

    }
}
