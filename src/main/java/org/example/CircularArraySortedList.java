package org.example;

import java.util.Scanner;


public class CircularArraySortedList {

    public int[] array;
    public int capacity;
    // Add other fields here!

    public CircularArraySortedList(int capacity) {
        // initialize the array with the given capacity
        this.capacity = capacity;
        // Add other initialization code below!

    }

    public void add(int x) {
        // first element would be stored at index 0
        // second element either would use bubble sort shifting and be placed at index 0 and previous index 0 would be moved to index 1
        // or it would be compared to the first element and placed at index 1

        // keep track of start and end of the array and use modulo to wrap around the capasity
        // Dont forget to check the size of the array and expand if needed
    }

    public int removeFirst() {
        // Dont forget about throwing an exception if the list is empty
        // Dont forget about modulo to wrap around the array if needed
        // Answer: How would the start be calculated after removing the first element?
        // Recalculating it everytime can allow to do it in O(1) time
        int startVal = 0; // dummy value
        // when ever the value is being removed set the index to zero
        return startVal;
    }

    public int removeLast() {
        // Dont forget about throwing an exception if the list is empty
        // May be you would also need to use modulo here
        int endVal = 0; // dummy value
        // when ever the value is being removed set the index to zero

        return endVal;
    }

    public boolean exists(int x) {
        // If element exists return true, otherwise false


        return false;
    }

    @Override
    public String toString() {
        // You can use StringBuilder to construct the string
        StringBuilder sb = new StringBuilder();
        // If the list is to be printed this method would return a string representation of a list
        // Code here

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
        // example use list.add(10) to add 10 to the list

        // Code here, check the unittests for further information and test the program before pushing.
    }
}
