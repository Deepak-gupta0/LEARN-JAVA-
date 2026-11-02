import java.util.*;
import java.util.function.*;

public class Revision {
  public static void main(String[] args) {
    // setDemo();
    mapDemo();
  }

  public static void mapDemo(){
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("Raman", 98);
    hm.put("Deepak", 100);
    hm.put("Clowd", 94);

    System.out.println("Returns old val :" + hm.put("Simon", 94));

    System.out.println(hm);

  }
  public static void setDemo() {
    // Set<Integer> a = new TreeSet<>(List.of(1, 2, 3, 4, 5));
    // Set<Integer> b = new TreeSet<>(List.of(3, 4, 5, 7, 8));

    // Set<Integer> union = new TreeSet<>(a);
    // union.addAll(b);
    // System.out.println(union);

    // retailAll for the common values.
    // Set<Integer> common = new TreeSet<>(a);
    // common.retainAll(b);
    // System.out.println(common);

    // removeAll remove common .
    // Set<Integer> removeCommen = new TreeSet<>(a);
    // removeCommen.removeAll(b);
    // System.out.println(removeCommen);

    TreeSet<Integer> num = new TreeSet<>(List.of(30, 40, 10, 20, 50, 60));
    //first last method 
    // System.out.println("FIRST: " + num.first() + "\nLAST: " + num.last());

    //lower() return just a nearest lower neighbour Lower.
    // System.out.println(num.lower(40));

    // System.out.println(num.headSet(40));
    // System.out.println(num.tailSet(40));

  }
}
