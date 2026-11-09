import java.util.Optional;

public class OptionalObj {
  public static void main(String[] args) {
    // Optional<String> name = Optional.of("Deepak");
    // name.ifPresent(System.out::println);

    // Optional<String> name = Optional.empty();
    // name.ifPresent(System.out::println);

    // Optional<String> name = Optional.empty();
    // String s = name.orElse("Unknown person");
    // System.out.println(s);

    // name.ifPresentOrElse(System.out::println, () ->
    // System.out.println("Unknown"));

    Optional<User> user = getUser();
    user.map(x -> x.address)
    .map(y -> y.city)
    .ifPresent(System.out::println);

  }

  private static Optional<User> getUser() {
    Address a = new Address("Bhilai");
    User u = new User(a);

    return Optional.of(u);
  }

}

class User {
  public Address address;

  User(Address address) {
    this.address = address;
  }

}

class Address {
  public String city = "Bhilai";

  Address(String city) {
    this.city = city;
  }
}