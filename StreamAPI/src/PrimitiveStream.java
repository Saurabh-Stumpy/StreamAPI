import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStream {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        IntStream stream = Arrays.stream(numbers);

        System.out.println(IntStream.range(1,5).boxed().toList());
        System.out.println(IntStream.rangeClosed(1,5).boxed().toList());

        IntStream.of(1,3,4);
        DoubleStream doubles = new Random().doubles(5);
        IntStream ints = new Random().ints(5);
        System.out.println(ints.sum());

    }
}
