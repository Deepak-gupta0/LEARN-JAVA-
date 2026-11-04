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

    List<List<Integer>> list2 = new ArrayList<>(List.of(
        List.of(4, 2),
        List.of(3, 1)));

    list2.stream()
        .flatMap(x -> x.stream().map(y -> y * 2))
        .sorted()
        .forEach(System.out::println);
  }
}
