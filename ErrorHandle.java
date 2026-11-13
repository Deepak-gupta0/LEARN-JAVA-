public class ErrorHandle {
  public static void main(String[] args) {
    // try catch

    try {
      int a = 9;
      int b = 0;

      System.out.println(a / b);
      System.out.println(b / a);
    } catch (Exception e) {
      throw new ArithmeticException("Division with zero is not allowed.");
    }
  }
}
