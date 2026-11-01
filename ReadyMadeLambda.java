import java.util.function.*;

public class ReadyMadeLambda {
  public static void main(String[] args) {

    Calculation c1 = new Calculation() {
      public int subtract(int a, int b) {
        return a - b;
      }
    };
    System.out.println(c1.subtract(23, 17));

  }
}

@FunctionalInterface
interface Calculation {
  int subtract(int a, int b);
}