package com.oxiane.katas.roman;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanConverter {
  private static Mapping[] mappings = new Mapping[] {
      new Mapping(1000, "M"),
      new Mapping(900, "CM"),
      new Mapping(500, "D"),
      new Mapping(400, "CD"),
      new Mapping(100, "C"),
      new Mapping(90, "XC"),
      new Mapping(50, "L"),
      new Mapping(40, "XL"),
      new Mapping(10, "X"),
      new Mapping(9, "IX"),
    new Mapping(5, "V"),
    new Mapping(4, "IV"),
    new Mapping(1, "I")
  };
  public static String convertToRoman(int arabic) {
    String result = "";
    while (arabic > 0) {
      int finalArabic = arabic;
      Mapping currentMapping = Arrays.stream(mappings)
          .filter(mapping -> mapping.arabic() <= finalArabic)
          .findFirst()
          .orElseThrow();
      result+=currentMapping.roman();
      arabic-= currentMapping.arabic();
    }
    return result;
  }

  public static int convertToArabic(String roman) {
    int result = 0;
    while(!roman.isEmpty()) {
      String finalRoman = roman;
      Mapping current = Arrays.stream(mappings)
          .filter(mapping -> finalRoman.startsWith(mapping.roman()))
          .findFirst()
          .orElseThrow();
      result += current.arabic();
      roman = roman.substring(current.roman().length());
    }
    return result;
  }

  private record Mapping(int arabic, String roman) {}
}
