package ua.opnu;

import java.util.List;
import java.util.stream.Collectors;

public class EasyTasks {

    // Task 1
    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    // Task 2
    public List<Integer> square(List<Integer> nums) {
        return nums.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Task 3
    public List<String> moreY(List<String> strings) {
        return strings.stream()
                .map(s -> "y" + s + "y")
                .collect(Collectors.toList());
    }

    // Task 4
    public List<Integer> noNeg(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());
    }

    // Task 5 — remove numbers ENDING with 9
    public List<Integer> no9(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 10 != 9)
                .collect(Collectors.toList());
    }

    // Task 6
    public List<String> noZ(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.contains("z"))
                .collect(Collectors.toList());
    }

    // Task 7 — remove duplicates + sort by length DESC
    public List<String> refinedStrings(List<String> strings) {
        return strings.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b.length(), a.length()))
                .collect(Collectors.toList());
    }

    // Task 8 — split by space ONLY when it exists
    public List<String> flatten(List<String> strings) {
        return strings.stream()
                .flatMap(s -> s.contains(" ")
                        ? List.of(s.split(" ")).stream()
                        : List.of(s).stream())
                .collect(Collectors.toList());
    }
}
