import java.util.*;
import java.util.stream.Stream;

public class LearnStream {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(List.of(5, 12, 7, 14));
    // Stream<Integer> s = list.stream();
    // s = s.filter(l -> l > 10);
    // s = s.map(l -> l * 2);
    // s.forEach(System.out::println);


    list.stream()
    .filter(l -> l > 10)
    .map(l -> l * 2)
    .forEach(System.out::println);
  }
}
