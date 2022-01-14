import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
  static List<String> servers = new ArrayList<>();

  static {
    servers.add("jacky");
    servers.add("mommy");
    servers.add("bruce");
    servers.add("android");
    servers.add("mary");
  }

  public static void main(String[] args) {
    //    joining();
    //    groupingBy();
    //    partitioningBy();
    //    collectingAndThen();
    //    mapping();
    //    reducing();
  }

  private static void joining() {
    System.out.println(servers.stream().collect(Collectors.joining()));
    System.out.println(servers.stream().collect(Collectors.joining(",")));
    System.out.println(servers.stream().collect(Collectors.joining(",", "[", "]")));
  }

  private static void groupingBy() {
    Map<Integer, List<String>> collect =
        servers.stream()
            .collect(
                Collectors.groupingBy(String::length)); // groupingBy 第二個參數預設是 Collectors.toList()
    collect.forEach(
        (a, b) -> {
          System.out.println("a=" + a);
          System.out.println("b=" + b);
        });
  }

  private static void partitioningBy() {
    Predicate<String> p = str -> str.length() > 5;
    Map<Boolean, List<String>> collect =
        servers.stream()
            .collect(Collectors.partitioningBy(p)); // partitioningBy 第二個參數預設是 Collectors.toList()

    collect.forEach(
        (a, b) -> {
          System.out.println("a=" + a);
          System.out.println("b=" + b);
        });
  }

  private static void collectingAndThen() {
    String collect =
        servers.stream()
            .collect(Collectors.collectingAndThen(Collectors.joining(","), String::toUpperCase));
    System.out.println(collect);
    System.out.println("-----------------");
    System.out.println(servers.stream().map(String::toUpperCase).collect(Collectors.joining(",")));
  }

  private static void mapping() {
    List<String> collect =
        servers.stream().collect(Collectors.mapping(s -> s.substring(1), Collectors.toList()));
    System.out.println(collect);
    System.out.println("-----------------");

    List<String> collect1 = servers.stream().map(s -> s.substring(1)).collect(Collectors.toList());
    System.out.println(collect1);
  }

  private static void reducing() {
    List<Animal> list = new ArrayList<>();
    list.add(new Animal(111, "jacky"));
    list.add(new Animal(87, "mary"));
    list.add(new Animal(111, "bruce"));
    list.add(new Animal(33, "dragon"));
    list.add(new Animal(111, "dolphin"));

    Map<Integer, Optional<Animal>> collect =
        list.stream()
            .collect(
                Collectors.groupingBy(
                    Animal::getId,
                    Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(a -> a.name)))));
    collect.forEach((a, b) -> System.out.println("b=" + b.get().name));
  }

  static class Animal {
    private int id;
    private String name;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Animal(int id, String name) {
      this.id = id;
      this.name = name;
    }
  }
}
