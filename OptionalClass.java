import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalClass {
  public static void main(String[] args) {
    // Optional<String> name = Optional.of("Deepak");
    System.out.println("Step 1");

    Optional<String> name = Optional.of("Deepak");
    // name.ifPresent(System.out::println);
    // System.out.println("Step 2");

    // String unknown = name.orElse("Deepak");
    // System.out.println(unknown);

    // String randomStr = name.orElseGet(() -> "GG");
    // System.out.println(randomStr);
    // System.out.println(name.get());

    Optional<String> name2 = name.map(x -> x.toUpperCase());
    System.out.println(name2.get());

  }
}
