import java.util.*;
import java.util.function.*;

public class Lambda {
  public static void main(String args[]) {
    // Arrow function wala kaam kiye hai.
    Greeting g = () -> {
      System.out.println("Hello Deepak");
    };
    g.sayHello();

    //
    Calculation c = (a, b) -> {
      return a + b;
    };
    System.out.println(c.add(10, 20));

    //
    Square sq = num -> num * num;
    System.out.println(sq.calculate(5));

    // ==================================================
    // 1. PREDICATE<T> -> boolean test(T t)
    // Sawaal puchho: true ya false?
    // Use: stream.filter(), list.removeIf()
    // ==================================================
    Predicate<Integer> isEven = n -> n % 2 == 0;
    Predicate<Integer> isPositive = n -> n > 0;

    System.out.println(isEven.test(10)); // true
    System.out.println(isEven.and(isPositive).test(10)); // true (dono true)
    System.out.println(isEven.or(isPositive).test(-3)); // false (dono false)
    System.out.println(isEven.negate().test(7)); // true (ulta)

    // ==================================================
    // 2. CONSUMER<T> -> void accept(T t)
    // Cheez lo, use karo, kuch return mat karo
    // Use: list.forEach()
    // ==================================================
    Consumer<String> printer = s -> System.out.println("Hello " + s);
    printer.accept("Deep"); // Hello Deep

    Consumer<String> upper = s -> System.out.println(s.toUpperCase());
    Consumer<String> lower = s -> System.out.println(s.toLowerCase());
    upper.andThen(lower).accept("Java"); // JAVA, java

    // ==================================================
    // 3. SUPPLIER<T> -> T get()
    // Input kuch nahi, bas value do
    // Use: Optional.orElseGet(), lazy value, factory
    // ==================================================
    Supplier<String> greeting = () -> "Namaste";
    Supplier<Double> randomValue = () -> Math.random();

    System.out.println(greeting.get()); // Namaste
    System.out.println(randomValue.get()); // random number

    // ==================================================
    // 4. FUNCTION<T, R> -> R apply(T t)
    // Ek type lo, doosra type banao (converter)
    // Use: stream.map()
    // ==================================================
    Function<String, Integer> length = s -> s.length();
    System.out.println(length.apply("Bhilai")); // 6

    Function<Integer, Integer> doubleIt = x -> x * 2;
    Function<Integer, Integer> addTen = x -> x + 10;

    // andThen: pehle doubleIt, phir addTen
    System.out.println(doubleIt.andThen(addTen).apply(5)); // 20
    // compose: pehle addTen, phir doubleIt
    System.out.println(doubleIt.compose(addTen).apply(5)); // 30

    // ==================================================
    // TEENO EK SAATH (Stream me)
    // ==================================================
    List<String> names = List.of("Deep", "Ravi", "Anita", "Sam");

    names.stream() //source
        .filter(n -> n.length() > 3) // Predicate \ Intermediate Operation
        .map(n -> n.toUpperCase()) // Function    /
        .forEach(n -> System.out.println(n)); // Consumer // Terminal Operation

  }
}

@FunctionalInterface
interface Calculation {
  int add(int a, int b);
}

@FunctionalInterface
interface Greeting {
  void sayHello();
}

@FunctionalInterface
interface Square {
  int calculate(int num);
}