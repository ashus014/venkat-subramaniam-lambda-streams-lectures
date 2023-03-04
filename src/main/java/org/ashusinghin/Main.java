package org.ashusinghin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


class Person {
    String name;
    String gender;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Main {

    public static List<Person> getData() {

        return Arrays.asList(
                new Person("sara", "FEMALE", 20),
                new Person("sara", "FEMALE", 22),
                new Person("bob", "MALE", 20),
                new Person("paula", "FEMALE", 32)
        );
    }

    public static void main(String[] args) {

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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
//        int sum = numbers.stream()
//                .reduce(0, (total, e) -> Integer.sum(total , e));

//        String ans = numbers.stream()
//                .map(String::valueOf)
//                .reduce("", (carry, str) -> carry.concat(str));

//        System.out.println(ans);

        // given numbers, double the even numbers and total
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        int result = 0;
//        Integer sum = numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .reduce(0, Integer::sum);
//        System.out.println(sum);

        // double the values and put them in a list
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//
//        List<Integer> double2 = numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .collect(Collectors.toList());
//
//        System.out.println(double2);

//        List<Person> people = getData();
//
//        Map<String, List<Integer>> collect = people.stream()
//                .collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
//
//        System.out.println(collect);


        // given an ordered list find the double of the first even number greater than 3
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

//        Optional<Integer> first = numbers.stream()
//                .filter(e -> e > 3)
//                .filter(e -> e % 2 == 0)
//                .map(e -> e * 2)
//                .findFirst();
//
//        System.out.println(first);
        // Below is the optimized code for the above

//        Optional<Integer> first = numbers.stream()
//                .filter(Main::isGT3)
//                .filter(Main::isEven)
//                .map(Main::doubleIt)
//                .findFirst();

        // above is an example of lazy evaluation

        // lazy evaluation is possible if the function don't have any side effect
        // don't go and start printing in your functions

//        System.out.println(first);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
//
//        numbers.stream()
//                .filter(e -> e % 2 == 0)
//                .distinct()
//                .forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(100, e -> e + 1);
        System.out.println(iterate);
    }

    public static boolean isGT3(int number) {
        System.out.println("isGT3 : " + number);
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("isEven : " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        System.out.println("doubleIt : " + number);
        return number * 2;
    }
}