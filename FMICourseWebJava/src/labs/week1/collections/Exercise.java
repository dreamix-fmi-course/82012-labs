package labs.week1.collections;

import labs.week1.collections.entity.Dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise {

    // T0) Write a method to insert an element into the array list at the first position

    // T1) Write a method to retrieve an element (at a specified index) from a given list.

    // T2) Write a method to remove the third element from an array list.

    // T3) Write a method to search an element in a list.

    // T4) Write a method to sort a given array list. (list of String/Integer/Dog).
    // Implement Dog class with attribute breed and weight, sort the array by weight property.
    // Tip: implement the task with Comparator and Comparable

    // T5) Write a method to replace the second element of a ArrayList with the specified element.

    // T6)?? Write a Java program to count the number of key-value (size) mappings in a map.

    // T7) Write the following structure against aircraft tail number associate
    // list of leg information (fromAirport, toAirport, date).
    // Fill test information
    // Extract legs inside list/set that have from/to airport for a specific airport
    // (Example: All legs for airport LBSF)

    public static void main(String[] args) {
        // task 0
        List<String> elements = new ArrayList<>();
        elements.add("one");
        elements.add(0, "two");
        elements.add("three");
        System.out.println(elements);

        // task 1
        System.out.println(elements.get(1));

        // task 2
        removeElement(elements, 2);
        System.out.println(elements);

        // task 3
        System.out.println(elements.contains("one"));

        // task 4
        Dog dog1 = new Dog("pesho", 2, 35);
        Dog dog2 = new Dog("pencho", 3, 25);
        System.out.println(dog1.compareTo(dog2));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        System.out.println(dogs);
        Collections.sort(dogs);
        System.out.println(dogs);

        // task 5
    }

    public static void removeElement(List<String> list, int index) {
        list.remove(index);
    }
}
