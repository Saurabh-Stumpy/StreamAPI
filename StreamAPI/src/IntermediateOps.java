import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations
        // Transform a stream into another stream
        // They are lazy meaning they don't work until a terminal operation is invoked.

        // 1. filter - to filter out using predicate
        List<String> list = Arrays.asList("Ram","Sham","Ankit");
        Stream<String> s = list.stream().filter(x -> x.toUpperCase().startsWith("S"));
        // No filtering upto this point
        System.out.println(s.count());

        // 2. map - to execute some operations on the element
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        // 3. sorted - to sort in natural order
        Stream<String> sortedStream = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator = list.stream().sorted((a,b)->a.length()-b.length());

        // 4. distinct
        long count = list.stream().filter(x -> x.startsWith("S")).distinct().count();

        // 5.  limit
        Stream<Integer> limit = Stream.iterate(1, x -> x + 1).limit(100);

        // 6. skip
        System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

        // 7. peek - performs an action on each element as it is consumed
        Stream.iterate(1,x->x+1).skip(10).limit(100).peek(System.out::println).count();

        // 8. flatMap - Handle streams of collections, lists, or arrays where each element is itself a collection
        // Flatten nested structures (e.g. lists within lists) so that they can be processed as a single sequence of elements
        // Transform and flatten at the same time
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grape"));
        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

        List<String> sentances = Arrays.asList(
                "Hello World",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentances.stream().flatMap(x->Arrays.stream(x.split(" "))).map(String::toUpperCase).toList());

    }
}
