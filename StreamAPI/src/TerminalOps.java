import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 4);

        // 1. Collect
        List<Integer> collect = list.stream().skip(1).collect(Collectors.toList());
        List<Integer> collectToList = list.stream().skip(1).toList();

        // 2. forEach
        list.stream().forEach(System.out::println);

        // 3. reduce - combines elements to produce single element
        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
        Integer optionalIntegerNw = list.stream().reduce(Integer::sum).orElse(1);
        System.out.println(optionalInteger.get());
        System.out.println(optionalIntegerNw);

        // 4. count

        // 5. anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean b1 = list.stream().allMatch(x -> x > 1);
        System.out.println(b1);
        boolean b2 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b2);

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findAny().get());

        // 7. toArray()

        Object[] array = Stream.of(1, 2, 3, 4).toArray();

        // 8. min/max
        System.out.println("max:" + Stream.of(1,43,32,65,76,34,12).max(Comparator.naturalOrder()).get());
        System.out.println("min:" + Stream.of(1,43,32,65,76,34,12).min(Comparator.naturalOrder()).get());

        // 9. ForEachOrdered
        List<Integer> numbers0 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Using forEach with Parallel stream");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("-----");
        numbers0.parallelStream().forEachOrdered(System.out::println);


        // Examples
        // 1. All names with length more than 3
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David");
        List<String> collect1 = names.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
        System.out.println(collect1);

        // Squaring and sorting numbers
        List<Integer> numbers = Arrays.asList(4, 1, 3, 2, 10, 5);
        List<Integer> collect2 = numbers.stream().map(x -> x * x).sorted().collect(Collectors.toList());
        System.out.println(collect2);

        // Summing values
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(nums.stream().reduce(Integer::sum).get());

        // Counting occurrences of character
        String sentence = "Hello world";
        System.out.println(sentence.chars().filter(x->x=='l').count());

        // Stateful and stateless operations
        // Stateful - all operations which are linked to all elements
        // e.g. sort, distinct
        // stateless - operations which only operate on current element
        // e.g. map, filter





    }
}
