package com.oxiane.katas.fizzbuzz;

public class FizzBuzz {
  public static String fizzBuzz(int input) {
    if(isFizzBuzz(input)) return "FizzBuzz";
    if(isFizz(input)) return "Fizz";
    if(isBuzz(input)) return "Buzz";
    return Integer.toString(input);
  }

  private static boolean isFizzBuzz(int input) {
    return isFizz(input) && isBuzz(input);
  }

  private static boolean isBuzz(int input) {
    return input % 5 == 0;
  }

  private static boolean isFizz(int input) {
    return input % 3 == 0;
  }
}
