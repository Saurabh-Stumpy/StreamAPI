import java.util.*;
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
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x.charAt(0))));

        // 21. Join a List of Strings with Comma
        List<String> words1 = Arrays.asList("Red", "Green", "Blue");
        System.out.println(words1.stream().collect(Collectors.joining(",")));

        // 22. Count Frequency of Each Character in a String
        String str = "banana";
        System.out.println(str.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        // 23. Remove Null or Empty Strings from a List
        List<String> input = Arrays.asList("Java", "", null, "Streams", "", null);
        System.out.println(input.stream().filter(x-> x!=null && x.length()>0).toList());

        // 24. Find the Second Highest Number in a List
        List<Integer> nums1 = Arrays.asList(10, 20, 30, 40);
        System.out.println(nums1.stream().sorted((x,y)->y-x).skip(1).limit(1).toList());

        // 25. Convert List of Integers to a Set of Squares
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 2);
        System.out.println(nums2.stream().map(x->x*x).collect(Collectors.toSet()));


    }
}

