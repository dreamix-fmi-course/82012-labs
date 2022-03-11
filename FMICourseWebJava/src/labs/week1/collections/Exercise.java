package labs.week1.collections;

import labs.week1.collections.entity.Dog;
import labs.week1.collections.entity.Leg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise {
    public static void main(String[] args) {
        // task 0
        // T0) Write a method to insert an element into the array list at the first position
        List<String> elements = new ArrayList<>();
        elements.add("one");
        elements.add(0, "two");
        elements.add("three");
        System.out.println(elements);

        // task 1
        // T1) Write a method to retrieve an element (at a specified index) from a given list.
        System.out.println(elements.get(1));

        // task 2
        // T2) Write a method to remove the third element from an array list.
        removeElement(elements, 2);
        System.out.println(elements);

        // task 3
        // T3) Write a method to search an element in a list.
        System.out.println(elements.contains("one"));

        // task 4
        // T4) Write a method to sort a given array list. (list of String/Integer/Dog).
        // Implement Dog class with attribute breed and weight, sort the array by weight property.
        // Tip: implement the task with Comparator and Comparable
        Dog dog1 = new Dog("pesho", 2, 35);
        Dog dog2 = new Dog("pencho", 3, 25);
        System.out.println(dog1.compareTo(dog2));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        System.out.println(dogs);
        Collections.sort(dogs);
        System.out.println(dogs);

        // comparing by age
        dogs.sort(Comparator.comparingInt(Dog::getAge));
        System.out.println(dogs);

        // task 5
        // T5) Write a method to replace the second element of a ArrayList with the specified element.
        System.out.println(elements);
        elements.remove(1);
        elements.add(1, "new element");
        System.out.println(elements);

        // T6)?? Write a Java program to count the number of key-value (size) mappings in a map.
        Map<String, Dog> dogMap = new HashMap<>();
        dogMap.put("key1", dog1);
        dogMap.put("key2", dog2);

        int count = 0;
        for (Map.Entry<String, Dog> entry : dogMap.entrySet()) {
            count++;
        }
        System.out.println(count);
        System.out.println(dogMap.size());
        System.out.println(dogMap.entrySet().stream().count());

        // T7) Write the following structure against aircraft tail number associate
        // list of leg information (fromAirport, toAirport, date).
        // Fill test information
        // Extract legs inside list/set that have from/to airport for a specific airport
        // (Example: All legs for airport LBSF)
        List<Leg> legs = List.of(
                new Leg("Sofia", "London", LocalDate.of(2021, 12, 12)),
                new Leg("London", "Paris", LocalDate.of(2022, 12, 9)),
                new Leg("Paris", "Athens", LocalDate.now()));

        List<Leg> londonLegs = legs.stream()
                .filter(leg -> leg.getFromAirport().equals("London") || leg.getToAirport().equals("London"))
                .toList();

    }

    public static void removeElement(List<String> list, int index) {
        list.remove(index);
    }
}
