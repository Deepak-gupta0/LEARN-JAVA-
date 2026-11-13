import java.util.*;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practise {
  public static void main(String[] args) {
    // example why streams uses
    List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60));

    // verbose code. difficult to understand
    // for (Integer integer : list) {
    // if (integer > 30) {
    // System.out.println(integer);
    // }
    // }

    // easy to read and understand.
    // list.stream()
    // .filter(x -> x > 30)
    // .forEach(System.out::println);

    // List<Integer> numbers = list.stream()
    // .map(x -> x * x)
    // .sorted((a, b) -> b - a)
    // .peek(System.out::println)
    // .skip(2)
    // .limit(3)
    // .peek(System.out::println)
    // .collect(Collectors.toList());

    // System.out.println(numbers);

    // Integer product = list.stream()
    // .reduce(1, (a, b) -> a * b);

    // System.out.println(product);

    List<Employee> employees = new ArrayList<>(
    List.of(
    new Employee("Deepak", "IT", 25000),
    new Employee("Sachin", "CS-IT", 15000),
    new Employee("Chandan", "IT", 17000),
    new Employee("Priyanshu", "EEE", 18000),
    new Employee("Rahul", "IT", 5000),
    new Employee("Aman", "HR", 3000),
    new Employee("Rohit", "IT", 6000),
    new Employee("Priya", "HR", 4000),
    new Employee("Neha", "Sales", 3500)));

    Map<String, List<Employee>> separateByDepart = employees.stream()
    .collect(Collectors.groupingBy(p -> p.department));
    System.out.println(separateByDepart);

    // Optional<Integer> num = list.stream()
    // .filter(x -> x > 40)
    // .findAny();
    // System.out.println(num.get());


  }
}

class Employee {
  String name;
  String department;
  int salary;

  Employee(String name, String department, int salary) {
    this.name = name;
    this.department = department;
    this.salary = salary;
  }

  @Override 
  public String toString(){
    return this.name;
  }

}
