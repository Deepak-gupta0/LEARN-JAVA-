import java.util.*;
import java.util.stream.Stream;

public class LearnStream {
  public static void main(String[] args) {
    // List<Integer> list = new ArrayList<>(List.of(5, 12, 7, 14));
    // Stream<Integer> s = list.stream();
    // s = s.filter(l -> l > 10);
    // s = s.map(l -> l * 2);
    // s.forEach(System.out::println);

    // list.stream()
    // .filter(l -> l > 10)
    // .map(l -> l * 2)
    // .forEach(System.out::println);

    // Streams in java

    // List<Integer> list = new ArrayList<>(List.of(1, 4, 11, 13, 34));
    // list.stream()
    // .filter(x -> x % 2 == 0)
    // .forEach(System.out::println);

    List<Integer> list2 = new ArrayList<>(List.of(1, 9, 5, 7, 0, 7, 9, 5));

    list2.stream()
        .map(x -> x * x)
        .sorted((x, y) -> y - x)
        .distinct()
        .forEach(System.out::println);
  }
}
