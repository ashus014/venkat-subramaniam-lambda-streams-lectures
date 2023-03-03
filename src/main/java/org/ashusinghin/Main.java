package org.ashusinghin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;


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

        List<Person> people = getData();

        Map<String, List<Person>> collect = people.stream()
                .collect(groupingBy(Person::getName));

        System.out.println(collect);

    }
}