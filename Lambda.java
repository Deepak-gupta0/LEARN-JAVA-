import java.util.*;
import java.util.function.*;

public class Lambda {
  public static void main(String args[]) {
    // Arrow function wala kaam kiye hai.

    // Calculation c = (a, b) -> a + b;
    // System.out.println(c.add(20, 30));

    // Greeting p1 = (name) -> {
    //   String address = "Housing board colony";
    //   int pinCode = 490026;
    //   String format = String.format("Hi My name is : %s \nI am from : %s , %d", name, address, pinCode);

    //   System.out.println(format);
    // };
    // p1.sayHello("Deepak");

    

  }

}

// lets make our own functional interface.

@FunctionalInterface
interface Calculation {
  int add(int a, int b);
}

@FunctionalInterface
interface Greeting {
  void sayHello(String name);
}