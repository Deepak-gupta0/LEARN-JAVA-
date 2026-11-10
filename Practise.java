import java.util.*;

public class Practise {
  public static void main(String[] args) {
    List<String> fruits = new ArrayList<>(List.of("Apple", "Mango", "Apple",
        "Banana", "Mango", "Apple"));

    Map<String, Integer> fruitsMap = new HashMap<>(Map.of());

    fruitsMap.put(
        fruits,
        fruitsMap.getOrDefault(fruits, 0) + 1);
  }
}
