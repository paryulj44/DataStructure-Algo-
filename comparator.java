import java.util.*;

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

public class comparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Alice", 24));
        list.add(new Student("Bob", 22));
        list.add(new Student("Charlie", 23));

        // Sort by age using Comparator
        list.sort(Comparator.comparingInt(s -> s.age));

        System.out.println(list);
    }
}
