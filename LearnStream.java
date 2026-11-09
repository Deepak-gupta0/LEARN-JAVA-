import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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

    // List<Integer> list2 = new ArrayList<>(List.of(1, 9, 5, 7, 0, 7, 9, 5));

    // List<Integer> list3 = list2.stream()
    // .map(x -> x * x)
    // .sorted((x, y) -> y - x)
    // .distinct()
    // .collect(Collectors.toList());

    // List<Integer> list = new ArrayList<>(List.of(1, 9, 7, 6));

    // Optional<Integer> listOptional = list.stream()
    // .reduce((a, b) -> a + b);

    // System.out.println(listOptional.get());

    // List<Integer> list = new ArrayList<>(List.of(1, 2, 8, 6, 7, 4));
    // Integer num = list.stream()
    // .reduce(1, (a, b) -> a * b);

    // System.out.println(num);

    // long num = list.stream()
    // .filter(x -> x > 5)
    // .count();

    // System.out.println(num);

    // Optional<Integer> num = list.stream()
    // .filter(x -> x > 5)
    // .findFirst();

    // System.out.println(num.get());

    // boolean num = list.stream()
    // .filter(x -> x > 5)
    // .anyMatch(x -> x % 2 == 0);

    // System.out.println(num);

    // int sum = list.stream()
    // .filter(x -> x > 5)
    // .filter(x -> x % 2 == 0)
    // .mapToInt(x -> x)
    // .sum();

    // System.out.println(sum);

    // List<String> list = new ArrayList<>(List.of("AA", "BBB", "CCCC", "DD", "EEE"));
    // Map<Integer, String> mapList = list.stream()
    //     .collect(Collectors.toMap(x -> x.length(), x -> x));

    // System.out.println(mapList);

    // Map<Integer,List<String>> mapList = list.stream()
    // .collect(Collectors.groupingBy(x -> x.length()));

    // System.out.println(mapList);

    // List<Integer> myList = new ArrayList<>(List.of(1, 14, 11, 9));

    // Map<Boolean, List<Integer>> map = myList.stream()
    // .collect(Collectors.partitioningBy(x -> x % 2 == 0));

    // System.out.println(map);

    List<String> myList = new ArrayList<>(List.of("AA", "BBB", "CCCC", "DD"));

    String s = myList.stream()
    .collect(Collectors.joining("-"));

    System.out.println(s);

  }
}
