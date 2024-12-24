package org.example;
import java.util.ArrayList;

import java.util.ArrayList;

class SortedStringArray {
    private ArrayList<String> strings;

    public SortedStringArray() {

        strings = new ArrayList<>();
    }

    public void add(String string) {
        strings.add(string);

        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = 0; j < strings.size() - i - 1; j++) {
                if (strings.get(j).length() > strings.get(j + 1).length()) {
                    String temp = strings.get(j);
                    strings.set(j, strings.get(j + 1));
                    strings.set(j + 1, temp);
                }
            }
        }
    }

    public String getMaxLengthString() {
        if (strings.isEmpty()) {
            return null;
        }
        String maxLengthString = strings.get(0);
        for (String s : strings) {
            if (s.length() > maxLengthString.length()) {
                maxLengthString = s;
            }
        }
        return maxLengthString;
    }

    public double getAverageLength() {

        if (strings.isEmpty()) {
            return 0;
        }
        int totalLength = strings.stream().mapToInt(String::length).sum();
        return (double) totalLength / strings.size();
    }

    public static void main(String[] args) {
        SortedStringArray arr = new SortedStringArray();

        arr.add("BMW");
        arr.add("Ferrari");
        arr.add("Lamborghini");
        arr.add("Mercedes");

        System.out.println("Compare massive: " + arr.strings);

        System.out.println("Max length's string: " + arr.getMaxLengthString());

        System.out.println("Average strings length: " + arr.getAverageLength());
    }
}




