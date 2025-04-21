import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        // Collectors is an Utility class
        // provides a set of methods to create common collectors

        // 1. Collecting to list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> collect = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(collect);

        // 2. Collecting to set
        List<Integer> nums = Arrays.asList(1, 6, 3, 8, 3, 6, 8);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. Collecting to a specific collection
        ArrayDeque<String> collect1 = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // 4. Joining Strings - Concatenated stream elements into a single string
        String collect2 = names.stream().map(String::toUpperCase).collect(Collectors.joining());
        System.out.println(collect2);

        // 5. Summarizing Data - Generates statistical summary
        // count, sum, min, average, max

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count " +stats.getCount());
        System.out.println("Sum " +stats.getSum());
        System.out.println("Min " +stats.getMin());
        System.out.println("Max " +stats.getMax());
        System.out.println("Average " +stats.getAverage());

        // 6. Calculating Averages
        Double collect3 = numbers.stream().collect(Collectors.averagingInt(x->x));
        System.out.println(collect3);

        // 7. Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println(count);

        // 8. Grouping elements
        List<String> words = Arrays.asList("Hello", "world", "java", "stream", "collecting");
        Map<Integer, List<String>> collect4 = words.stream().collect(Collectors.groupingBy(x -> x.length()));
        System.out.println(collect4);
        Map<Integer, String> collect5 = words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(",")));
        System.out.println(collect5);

        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        // 9. Partitioning Elements - Partitions elements into two groups (true and false) based on predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x->x.length()>5)));

        // 10. Mapping and collecting - Applies a mapping function before collecting
        List<String> collect6 = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(collect6);


        // Examples
        // 1. Collecting names by length
        List<String> names1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian");
        System.out.println(names1.stream().collect(Collectors.groupingBy(x -> x.length())));

        // 2. Counting word occurances
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        // 3. Partitioning even and odd numeber
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(nums1.stream().collect(Collectors.partitioningBy(x->x%2==0,Collectors.counting())));

        // 4. Summing values in a Map
        HashMap<String, Integer> items = new HashMap<>();
        items.put("Apple",10);
        items.put("Banana",20);
        items.put("Orange",15);

        Optional<Integer> reduce = items.values().stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());
        Integer collect7 = items.values().stream().collect(Collectors.summingInt(x -> x));
        System.out.println(collect7);

        // 5. Creating a Mapfrom stream Elements

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase,String::length)));

        // Count the fruits
        List<String> fruits2 = Arrays.asList("apple", "banana", "apple", "orange");
        fruits2.stream().collect(Collectors.toMap(x->x,y->1,Integer::sum));


    }
}
