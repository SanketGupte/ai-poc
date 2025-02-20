import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by spaces: ");
        String input = sc.nextLine();

        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());

        List<Integer> missingNumbers = IntStream.rangeClosed(Collections.min(numbers), Collections.max(numbers))
                .filter(num -> !numbers.contains(num)).boxed().collect(Collectors.toList());

        System.out.println("Missing numbers: " + missingNumbers);

        sc.close();
    }
}
