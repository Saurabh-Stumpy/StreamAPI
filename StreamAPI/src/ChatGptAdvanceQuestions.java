import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChatGptAdvanceQuestions {
    public static void main(String[] args) {

        // 16. Partition Even and Odd Numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(nums.stream().collect(Collectors.partitioningBy((x->x%2==0))));

        // 17. Find All Employee Names from "IT" Department
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("David", "Finance")
        );
        System.out.println(employees.stream().filter(x->x.department.equals("IT")).toList());

        // 18. Sort a Map by Values in Descending Order
        Map<String, Integer> map = Map.of("A", 5, "B", 2, "C", 8);
        System.out.println(map.entrySet().stream().sorted((x,y)-> y.getValue()-x.getValue()).toList());

        // 19. Find Common Elements Between Two Lists
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        List<List<Integer>> list3 = Arrays.asList(
                list1,list2
        );
//        System.out.println(list3);

        Map<Integer, Long> collect = list3.stream().flatMap(x -> x.stream()).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect.entrySet().stream().filter(x->x.getValue()>1).map(Map.Entry::getKey).toList());

        // 20. Group Strings by First Character
        List<String> words = Arrays.asList("Apple", "Amazon", "Google", "GitHub");
        System.out.println(words.stream().collect(Collectors.toMap(x->x.charAt(0),x->x,String::concat)));

        // 21. Join a List of Strings with Comma
        List<String> words1 = Arrays.asList("Red", "Green", "Blue");
        System.out.println(words1.stream().collect(Collectors.joining(",")));

        // 22. Count Frequency of Each Character in a String
        String str = "banana";


    }
}

