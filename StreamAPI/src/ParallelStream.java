import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // A type of stream that enables parallel processing of elements
        // Allowing multiple threads to process parts of the stream simultaneously
        // This can significantly improve performance for large data sets
        // workload is distributed across multiple threads

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Integer> collect = list.stream().map(ParallelStream::fact).toList();
        System.out.println(System.currentTimeMillis()-startTime);
        startTime = System.currentTimeMillis();
        collect = list.parallelStream().map(ParallelStream::fact).toList();
        System.out.println(System.currentTimeMillis()-startTime);

        // Parallel streams are most effective for CPU-internsive or large dataset where task are independent
        // They may add overhead for simple tasks or small datasets

        // Cumulative sum

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        AtomicInteger temp = new AtomicInteger(0);
        List<Integer> list1 = nums.stream().map(temp::addAndGet).toList();
        System.out.println(list1);

    }

    public static int  fact(int num){
        if(num == 1) return 1;
        return num * fact(num-1);
    }
}
