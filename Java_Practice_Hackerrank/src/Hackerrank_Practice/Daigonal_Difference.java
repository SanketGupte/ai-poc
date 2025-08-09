package Hackerrank_Practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Daigonal_Difference {
    public static int diagonalDifference(List<List<Integer>> matrix) {
        int n = matrix.size();

        int primaryDiagonalSum = IntStream.range(0, n)
                .map(i -> matrix.get(i).get(i))
                .sum();

        int secondaryDiagonalSum = IntStream.range(0, n)
                .map(i -> matrix.get(i).get(n - 1 - i))
                .sum();

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );

        System.out.println("Absolute Diagonal Difference: " + diagonalDifference(matrix));
    }
}
