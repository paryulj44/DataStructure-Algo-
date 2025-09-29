import java.util.*;
import java.util.stream.Collectors;

class User {
    private String name;
    private int age;
    String dept;

    // Constructor
    public User(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public User(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " (" + age + ")" + dept;
    }
}

public class StreamExample {
    public static void main(String[] args) {
        // Sample list of users
        List<User> users = Arrays.asList(
            new User("Alice", 30, "HR"),
            new User("Bob", 20, "IT"),
            new User("Charlie", 25, "HR"),
            new User("David", 19, "HR"),
            new User("Eve", 40, "IT")
        );

        // Stream operations:
        List<String> result = users.stream()
            .filter(user -> user.getAge() >= 21)        // Keep users age 21 and above
            .sorted(Comparator.comparing(User::getAge)) // Sort by age
            .map(User::getName)                          // Get only names
            .collect(Collectors.toList());               // Collect into a List

        List<User> userDept = Arrays.asList(
            new User("Alice", "HR"),
            new User("Bob", "IT"),
            new User("Charlie", "HR"),
            new User("David", "HR"),
            new User("Eve", "IT")
        );
            Map<String, List<User>> groupByDept = userDept.stream().collect(Collectors.groupingBy(u -> u.dept));
            groupByDept.forEach((dept , usrlist)->
                System.out.println(dept + ":" + usrlist)
            );
            // Output result
        System.out.println("Users age 21+ sorted by age:");
        result.forEach(System.out::println);
    }
}
