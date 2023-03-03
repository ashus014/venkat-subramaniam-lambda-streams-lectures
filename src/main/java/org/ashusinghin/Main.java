package org.ashusinghin;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // external iterators
        // the more you control, the more your have to change, when you have to change what you control
//        for(int i=0; i< numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }

        // external iterator
//        for(int e : numbers) {
//            System.out.println(e);
//        }

        // internal iterator
//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

        // simply replacing the above anonymous class
//        numbers.forEach(x -> System.out.println(x));

        // using method reference syntax
//        numbers.forEach(System.out::println);

        // while lambdas are really cute, keep them that way
        // avoid urge of writing large lambdas

//        numbers.stream()
//                .map(String::valueOf)
//                .forEach(System.out::println);

        // two parameters as an argument
        int sum = numbers.stream()
                .reduce(0, (total, e) -> Integer.sum(total , e));

        String ans = numbers.stream()
                .map(String::valueOf)
                .reduce("", (carry, str) -> carry.concat(str));

        System.out.println(ans);
    }
}