import java.util.*;
import java.util.stream.Collectors;

public class AnagramCluster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter words separated by spaces: ");
        String input = sc.nextLine();
        List<String> words = Arrays.asList(input.split("\\s+"));

        List<List<String>> anagrams = new ArrayList<>(words.stream()
                .collect(Collectors.groupingBy(word -> {
                    char[] arr = word.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                })).values());
        System.out.println("\nGrouped Anagrams: " + anagrams);
//        anagrams.values().forEach(System.out::println);

        sc.close();
    }
}
