import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChatGptQuestions {
    public static void main(String[] args) {

        // 1. Find even numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().filter(x->x%2==0).toList());

        // 2. Convert strings to upper case
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        System.out.println(fruits.stream().map(String::toUpperCase).toList());

        // 3. Filter Strings Starting With 'A'
        List<String> fruits2 = Arrays.asList("Apple", "Banana", "Avocado", "Berry", "Apricot");
        System.out.println(fruits2.stream().filter(fruit->fruit.startsWith("A")).toList());

        // 4. Count Strings with Length > 5
        System.out.println(fruits2.stream().filter(x->x.length()>5).count());

        // 5. Remove Duplicates from a List
        List<Integer> dupInt = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        System.out.println(dupInt.stream().distinct().toList());

        // 6. Find First Non-Repeated Character
        String words = "swiss";
        LinkedHashMap<Character, Long> collect = words.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(x->x, LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).findFirst().get());

        // 7. Sort a List of Strings by Length
        List<String> animals = Arrays.asList("dog", "elephant", "cat", "deer");
        System.out.println(animals.stream().sorted((x,y)->x.length()-y.length()).toList());

        // 8. Find Max and Min Value in a List
        List<Integer> list8 = Arrays.asList(7, 2, 10, 4, 9);
        System.out.println(list8.stream().max(Comparator.naturalOrder()).get());
        System.out.println(list8.stream().min(Comparator.naturalOrder()).get());

        // 9. Group Strings by Their Length
        List<String> list9 = Arrays.asList("apple", "banana", "pear", "fig");
        System.out.println(list9.stream().collect(Collectors.groupingBy(x->x.length())));

        // 10. Sum of Squares of Even Numbers
        List<Integer> list10 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list10.stream().filter(x->x%2==0).map(x->x*x).collect(Collectors.summingInt(x->x)));

        // 11. Find Duplicate Elements in a List
        List<Integer> list11 = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
        System.out.println(list11
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()>1)
                .map(x->x.getKey())
                .collect(Collectors.toList()));

        // 12. Group Employees by Department
        List<Employee> list12 = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "HR"),
                new Employee("David", "IT")
        );

        System.out.println(list12.stream().collect(Collectors.groupingBy(emp-> emp.department)));

        // 13. Get Top 3 Highest Paid Employees
        List<Employee2> list13 = Arrays.asList(
                new Employee2("A", 50000),
                new Employee2("B", 80000),
                new Employee2("C", 60000),
                new Employee2("D", 75000)
        );

        System.out.println(list13.stream().sorted((x,y)->y.salary-x.salary).limit(3).toList());

        // 14. Count Word Frequency in a Sentence
        String str = "apple banana apple cherry banana apple";
        System.out.println(Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting())));

        // 15. Flatten a List of Lists

        List<List<Integer>> list15 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        System.out.println(list15.stream().flatMap(x->x.stream()).toList());


    }
}

class Employee {
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    String name;
    String department;

    @Override
    public String toString() {
        return name;
    }
}

class Employee2 {

    String name;
    int salary;

    public Employee2(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name;
    }
}
