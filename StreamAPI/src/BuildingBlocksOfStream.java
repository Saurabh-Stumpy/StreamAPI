import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class BuildingBlocksOfStream {
    public static void main(String[] args) {

        // 1.Predicate - Returns Boolean value (test)

        Predicate<Integer> isEven =  x -> (x % 2) == 0;
        System.out.println(isEven.test(4));

        Predicate<String> startsWithS = x -> x.toUpperCase().startsWith("S");
        System.out.println(startsWithS.test("saurabh"));

        Predicate<String> endingWithH = x->x.toUpperCase().endsWith("H");
        System.out.println(endingWithH.test("Saurabh"));

        // Combine predicate

        System.out.println(startsWithS.and(endingWithH).test("Saurabh"));
        System.out.println(startsWithS.or(endingWithH).test("saurabh"));
        System.out.println(startsWithS.negate().test("Saurabh"));


        // 2.Function - works on something and returns something. (apply)

        Function<Integer, Integer> doubleIt = x -> x*2;
        System.out.println(doubleIt.apply(2));

        Function<Integer, Integer> tripleIt = x -> x*3;
        System.out.println(tripleIt.apply(100));

        //Compose
        System.out.println(doubleIt.compose(tripleIt).apply(10));
        System.out.println(doubleIt.andThen(tripleIt).apply(10));

        // Identity in function -  returns the same value
        Function<Integer,Integer> identity = Function.identity();
        System.out.println(identity.apply(10));

        // Consumer - Accepts but does not return anything. (accept)

        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(5);

        List<Integer> list = Arrays.asList(1,2,3,4);
        Consumer<List<Integer>> printList = x -> {
            for (int i=0; i<x.size(); i++){
                x.set(i,i);
            }
        };
        printList.accept(list);
        System.out.println(list);

        // Supplier - returns some values but accepts nothing (get)

        Supplier<String> helloWorld = ()->"Hello World!";

        System.out.println(helloWorld.get());


        // Takes 2 arguments

        BiPredicate<Integer,Integer> biPredicate = (a,b) -> a>b;
        System.out.println(biPredicate.test(1,2));


    }
}
