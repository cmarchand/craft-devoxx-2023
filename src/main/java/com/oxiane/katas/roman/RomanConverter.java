package com.oxiane.katas.roman;

public class RomanConverter {
  public static String convertToRoman(int arabic) {
    String result = "";
    while (arabic > 0) {
      if(arabic>=5) {
        result +="V";
        arabic -= 5;
      } else if(arabic>=4) {
        result += "IV";
        arabic -= 4;
      } else {
        result += "I";
        arabic--;
      }
    }
    return result;
  }
}
