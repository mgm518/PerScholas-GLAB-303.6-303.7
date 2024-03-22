package com.perscholas.arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * In this Assignment, we test your knowledge of using arrays in Java.
 */
public class ArrayManipulation {

  public static void main(String[] args) {
    new ArrayManipulation().pa_303_7_1();
  }

  private void pa_303_7_1() {
    System.out.println("""
        **************************************************
        PA 303.5.1 - Iteration Statements (Loops)
        **************************************************""");
    task1();
    System.out.println();
    task2();
    System.out.println();
    task3();
    System.out.println();
    task4();
    System.out.println();
    task5();
    System.out.println();
    task6();
    System.out.println();
    task7();
    System.out.println();
    task8();
    System.out.println();
    task9();
    System.out.println();
    task10();
    System.out.println();
    task11();
    System.out.println();
    subarray();
  }

  private void subarray() {
    String input = "5\n1 -2 4 -5 1\n";
    Scanner sc =
        new Scanner(input);
//    new Scanner(System.in);
    int limit = Integer.parseInt(sc.next().trim());
    int[] array = new int[limit];
    for (int i = 0; i < array.length; i++) {
      array[i] = sc.nextInt();
    }
    sc.close();
    int negativeSums = 0;
    int[] temp;
    for (int size = 1; size <= array.length; size++) {
      for (int start = 0; start+size <= array.length; start++) {
        temp = Arrays.copyOfRange(array, start, start+size);
        if (Arrays.stream(temp).sum() < 0) {
          negativeSums++;
        }
      }
    }
    System.out.println(negativeSums);
  }

  /**
   * Task 1: Write a program that creates an array of integers with a length of 3. Assign the values
   * 1, 2, and 3 to the indexes. Print out each array element.
   */
  private void task1() {
    System.out.print(" 1.\t");
    int[] array = new int[3];
    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1;
    }
    System.out.print("Printing elements with array { ");
    for (int num : array) {
      System.out.print("'" + num + "' ");
    }
    System.out.println("}");
    System.out.print("As a bonus, I also used streams to print out { ");
    Arrays.stream(array).forEach(num -> System.out.printf("'%d' ", num));
    System.out.println("}");
  }

  /**
   * Task 2: Write a program that returns the middle element in an array. Give the following values
   * to the integer array: {13, 5, 7, 68, 2} and produce the following output: 7
   */
  private void task2() {
    System.out.print(" 2.\t");
    long streamSize = ThreadLocalRandom.current().nextLong(1, 20);
    int[] array = ThreadLocalRandom.current().ints(streamSize, -100, 100).toArray();
//        {4, 2, 9, 13, 1, 0};  // Will print '9' and '13'
//        {13, 5, 7, 68, 2};    // Will print '7'
    System.out.print("Middle element(s) of the provided array { ");
    Arrays.stream(array).forEach(num -> System.out.printf("'%d' ", num));
    if (array.length % 2 == 0) {
      System.out.printf("} are '%d' & '%d'\n", array[(array.length - 1) / 2],
          array[(array.length) / 2]);
    } else {
      System.out.printf("} is '%d'\n", array[(array.length - 1) / 2]);
    }

  }

  /**
   * Task 3: Write a program that creates an array of String type and initializes it with the
   * strings “red,” “green,” “blue,” and “yellow.” Print out the array length. Make a copy using the
   * clone( ) method. Use the Arrays.toString( ) method on the new array to verify that the original
   * array was copied.
   */
  private void task3() {
    System.out.print(" 3.\t");
    String[] array1 = {"red", "green", "blue", "yellow"};
    System.out.printf("The length of 'array1' is %d\n", array1.length);
    System.out.printf("array1(@%h) = %s\n", Arrays.hashCode(array1), Arrays.toString(array1));
    String[] array2 = array1.clone();
    System.out.printf("array2(@%h) = %s\n", Arrays.hashCode(array2), Arrays.toString(array2));
  }

  /**
   * Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers). The
   * numbers can be any integers. Print out the value at the first index and the last index using
   * length - 1 as the index. Now try printing the value at index = length (e.g.,
   * myArray[myArray.length] ). Notice the type of exception which is produced. Now try to assign a
   * value to the array index 5. You should get the same type of exception.
   */
  private void task4() {
    System.out.print(" 4.\t");
    int[] array = ThreadLocalRandom.current().ints(5, -100, 100).toArray();
    System.out.printf("The first and last elements are '% 2d' & '% 2d'\n",
        array[0], array[array.length - 1]);
    System.out.print("Can we print the element at array[array.length]? ");
    try {
      System.out.print(array[array.length]);
      System.out.println("Yes, we can! It's a miracle!");
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Apparently not.  Below is the IndexOutOfBoundsException: ");
      System.out.println(e);
    }
    System.out.println("Now trying to assign 123 to the array index 5");
    try {
      array[5] = 123;
      System.out.printf("Seems that worked: %d\n", array[5]);
    } catch (IndexOutOfBoundsException e) {
      System.out.println("Apparently, this also trips an IndexOutOfBoundsException: ");
      System.out.println(e);
    }
  }

  /**
   * Task 5: Write a program where you create an integer array with a length of 5. Loop through the
   * array and assign the value of the loop control variable (e.g., i) to the corresponding index in
   * the array.
   */
  private void task5() {
    System.out.print(" 5.\t");
    int[] array = new int[5];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }
    System.out.println(Arrays.toString(array));
  }

  /**
   * Task 6: Write a program where you create an integer array of 5 numbers. Loop through the array
   * and assign the value of the loop control variable multiplied by 2 to the corresponding index in
   * the array.
   */
  private void task6() {
    System.out.print(" 6.\t");
    int[] array = new int[5];
    for (int i = 0; i < array.length; i++) {
      array[i] = 2 * i;
    }
    System.out.println(Arrays.toString(array));
  }

  /**
   * Task 7: Write a program where you create an array of 5 elements. Loop through the array and
   * print the value of each element, except for the middle (index 2) element.
   */
  private void task7() {
    System.out.print(" 7.\t");
    int[] array = ThreadLocalRandom.current().ints(5, -100, 100).toArray();
    System.out.printf("Initial array: %s\n", Arrays.toString(array));
    System.out.print("[ ");
    for (int i = 0; i < array.length; i++) {
      if (i != (array.length - 1) / 2) {
        System.out.printf("% 2d ", array[i]);
      }
    }
    System.out.println("]");
  }

  /**
   * Task 8: Write a program that creates a String array of 5 elements and swaps the first element
   * with the middle element without creating a new array.
   */
  private void task8() {
    System.out.print(" 8.\t");
    String[] strings = new String[5];
    for (int i = 0; i < strings.length; i++) {
      strings[i] = generateRandomString();
    }
    System.out.println("Initial array of Strings:\n" + Arrays.toString(strings));
    String temp = strings[0];
    strings[0] = strings[(strings.length - 1) / 2];
    strings[(strings.length - 1) / 2] = temp;
    System.out.println("After the swap:\n" + Arrays.toString(strings));
  }

  /**
   * Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. Print
   * the array in ascending order, and print the smallest and the largest element of the array. The
   * output will look like the following:
   * <ul>
   *   <li>Array in ascending order: 0, 1, 2, 4, 9, 13</li>
   *   <li>The smallest number is 0</li>
   *   <li>The biggest number is 13</li>
   * </ul>
   */
  private void task9() {
    System.out.print(" 9.\t");
    int[] array = {4, 2, 9, 13, 1, 0};
    System.out.println("Starting with the following array: " + Arrays.toString(array));
    Arrays.sort(array);
    System.out.println("Array in ascending order: " + Arrays.toString(array));
    System.out.printf("The smallest number is %d\n", array[0]);
    System.out.printf("The biggest number is %d\n", array[array.length - 1]);
  }

  /**
   * Task 10: Create an array that includes an integer, 3 strings, and 1 double. Print the array.
   */
  private void task10() {
    System.out.print("10.\t");
    Object[] array = new Object[5];
    array[0] = ThreadLocalRandom.current().ints(1, -100, 100)
        .boxed().findAny().orElse(null);
    for (int i = 1; i < array.length - 1; i++) {
      array[i] = generateRandomString();
    }
    array[array.length - 1] = ThreadLocalRandom.current().doubles(1, -100, 100)
        .boxed().findAny().orElse(null);
    System.out.println("Generated array of Objects: " + Arrays.toString(array));
  }

  /**
   * Task 11: Write some Java code that asks the user how many favorite things they have. Based on
   * their answer, you should create a String array of the correct size. Then ask the user to enter
   * the things and store them in the array you created. Finally, print out the contents of the
   * array.
   */
  private void task11() {
    System.out.print("11.\tFavorite Things\n");
    Scanner scanner = new Scanner(System.in);
    System.out.println("How many favorite things would you like to list?");
    int limit = Integer.parseInt(scanner.next());
    String[] favorites = new String[limit];
    for (int i = 0; i < limit; i++) {
      System.out.print("Enter your thing: ");
      favorites[i] = scanner.next();
    }
    System.out.println("Your favorite things are:");
    for (int i = 0; i < limit; i++) {
      System.out.print(favorites[i] + " ");
    }
  }

  /**
   * Helper method used to generate a random alphanumeric string consisting of 8 - 12 characters.
   *
   * @return random alphanumeric string
   */
  private String generateRandomString() {
    int ranLength = ThreadLocalRandom.current().nextInt(8, 12);
    return ThreadLocalRandom.current()
        .ints('0', 'z')
        .filter(c -> (c <= 57 || c >= 65) && (c <= 90 || c >= 97))
        .limit(ranLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
  }
}
