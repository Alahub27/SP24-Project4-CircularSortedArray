package org.example;

import java.util.Scanner;


public class CircularArraySortedList {

    int capacity;
    static int[] array;
    static int size;
    static int first;
    static int last;

    // Add other fields here!

    public CircularArraySortedList(int capacity) {
        // initialize the array with the given capacity
        this.capacity = capacity;
        array = new int[capacity];
        // Add other initialization code below!
        size = 0;
        first = 0;
        last = -1;

    }

    public void add(int x) {

        if (size == capacity) {
            System.out.println("List is full.");
            return;

        }
        // first element would be stored at index 0
        if (size == 0) {
            last = 0;
            array[last] = x;
            size++;
            return;
        }

        // second element either would use bubble sort shifting and be placed at index 0 and previous index 0 would be moved to index 1
        // or it would be compared to the first element and placed at index 1

        // keep track of start and end of the array and use modulo to wrap around the capasity
        // Dont forget to check the size of the array and expand if needed

        int index = last;
        while (index >= 0 && array[index] > x) {
            array[(index + 1) % capacity] = array[index];
            index = (index - 1 + capacity) % capacity;
        }
        array[(index + 1) % capacity] = x;
        last = (last + 1) % capacity;
        size++;
    }



    public int removeFirst() {
        // Dont forget about throwing an exception if the list is empty
        //credits: https://www.youtube.com/watch?v=89m4kF2x4Yg
        if (size == 0) {
            throw new IllegalStateException("List empty.");
        }
        int firstValue = array[first];
        array[first] = 0;
        first++;
        size--;
        return firstValue;
        // Dont forget about modulo to wrap around the array if needed
        // Answer: How would the start be calculated after removing the first element?
        // Recalculating it everytime can allow to do it in O(1) time
        // dummy value
        // when ever the value is being removed set the index to zero

    }

    public int removeLast() {
        // Don't forget about throwing an exception if the list is empty
        if (size == 0) {
            throw new IllegalStateException("List empty.");
        }
        int lastVal = array[last];
        array[last-1] = 0;
        last--;
        size--;
        return lastVal;
        // May be you would also need to use modulo here
        // dummy value
        // when ever the value is being removed set the index to zero


    }

    public boolean exists(int x) {
        // If element exists return true, otherwise false
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        // You can use StringBuilder to construct the string
        StringBuilder sb = new StringBuilder();
        // If the list is to be printed this method would return a string representation of a list
        //appending string if conditions are met
        //credit:https://www.geeksforgeeks.org/stringbuilder-append-method-in-java-with-examples/
        // Code here
        int index = first;
        for (int i = 0; i < array.length; i++) {
            sb.append(array[index]);
            sb = sb.append(" ");
            index = (index + 1) % capacity;
        }

        return sb.toString().trim();
    }

    // You can have a custom method to print the full array for debugging purposes


    public static void main(String[] args) {
        System.out.println("Programming Fundamentals");
        System.out.println("NAME: <your name>");    // replace with your name
        System.out.println("PROGRAMMING ASSIGNMENT 4");
        System.out.println("Welcome to Circular Array!\n");
        Scanner scanner = new Scanner(System.in);
        CircularArraySortedList list = new CircularArraySortedList(5);

        // To help you started Above line is creating a Circular Array list Object of capacity 5
        while (true) {
            System.out.println("Enter a command: ");
            String command = scanner.next();

            if (command.equals("q")) {
                System.out.println("Good Bye!");
                break;
            }
            //Lab 4
            //using list.add()
            switch (command) {
                case "a":
                    int valueAdd = scanner.nextInt();
                     list.add(valueAdd);
                    System.out.println("Current list: " + list);
                    break;
                case "rf":
                    //illegal state expression: try and catch method
                    try {
                        int removed = list.removeFirst();
                        System.out.println("Removed: " + removed);
                        System.out.println("Current list: " + list);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "rl":
                    //illegal state expression: try and catch method
                    try {
                        int removed = list.removeLast();
                        System.out.println("Removed: " + removed);
                        System.out.println("Current list: " + list);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    int valuesExist = scanner.nextInt();
                    boolean exists = list.exists(valuesExist);
                    System.out.println("Exists: " + exists);
                    break;
                default:
                    System.out.println("Invalid command");
            }


            // Code here, check the unittests for further information and test the program before pushing.
        }
        scanner.close();
    }
}