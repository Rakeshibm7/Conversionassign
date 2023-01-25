package com.romanconversion.conversion.service.impl;

import com.romanconversion.conversion.service.conversions;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class conversionimpl implements conversions {
    @Override
    public Integer romanToDigit(String input) {
        Map<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);
        roman.put("MM", 2000);
        int sum = 0;
        int n = input.length();
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && roman.get(String.valueOf(input.charAt(i))) <
                    roman.get(String.valueOf(input.charAt(i + 1)))) {
                sum += roman.get(String.valueOf(input.charAt(i + 1))) -
                        roman.get(String.valueOf(input.charAt(i)));
                i++;
            } else {
                sum += roman.get(String.valueOf(input.charAt(i)));
            }
        }
        return sum;
    }

    @Override
    public String digitToRoman(Integer number) {

        TreeMap<Integer, String> treemap = new TreeMap<>();
        treemap.put(1000, "M");
        treemap.put(900, "CM");
        treemap.put(500, "D");
        treemap.put(400, "CD");
        treemap.put(100, "C");
        treemap.put(90, "XC");
        treemap.put(50, "L");
        treemap.put(40, "XL");
        treemap.put(10, "X");
        treemap.put(9, "IX");
        treemap.put(5, "V");
        treemap.put(4, "IV");
        treemap.put(1, "I");

        int l = treemap.floorKey(number);

        if (number >= 0) {
            if (number == l) {
                return treemap.get(number);
            }
            return treemap.get(l) + digitToRoman(number - l);
        } else {
            throw new RuntimeException(number + "is not valid, Enter valid number");
        }

    }
}
