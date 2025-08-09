package Hackerrank_Practice;

import java.util.Arrays;
import java.util.List;

public class Hackerrank_test_1 {
    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = arr.stream().mapToLong(Integer::longValue).sum();
        int minVal = arr.stream().min(Integer::compare).orElse(0);
        int maxVal = arr.stream().max(Integer::compare).orElse(0);
        long minSum = totalSum - maxVal;
        long maxSum = totalSum - minVal;
        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        miniMaxSum(arr);
    }
}
