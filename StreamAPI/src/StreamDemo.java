import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        // Feature introduced in Java 8
        // Source ,intermediate operations and terminal operation
        // What is stream?
        // A sequence of elements supporting functional and declarative programming

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = numbers.stream();

        // Count even numbers
        long count = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count);

        // Creating Streams
        // 1. Collections
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream1 = list.stream();

        // 2. Arrays
        String[] array = {"a","b"};
        Stream<String> stream2 = Arrays.stream(array);

        // 3. using Stream.of()
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        // 4. Infinite Stream
        Stream<Integer> limit = Stream.generate(() -> 1).limit(19);
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1).limit(100);




    }
}
