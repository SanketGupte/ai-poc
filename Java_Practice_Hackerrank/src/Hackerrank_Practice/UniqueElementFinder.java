package Hackerrank_Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueElementFinder {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 2, 1);
        System.out.println(findUniqueElement(arr));
        System.out.println(findUniqueElement1(arr));
    }
    public static int findUniqueElement(List<Integer> arr) {
        return arr.stream().reduce(0, (a, b) -> a ^ b);
    }

    public static int findUniqueElement1(List<Integer> arr) {
        Map<Integer, Integer> fMap = new HashMap<>();
        for (int num : arr) {
            fMap.put(num, fMap.getOrDefault(num, 0) + 1);
        }
        return fMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No unique element found"));
    }
}
