import java.util.*;

class Student1 implements Comparable<Student1> {
    String name;
    int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Natural ordering: by name
    public int compareTo(Student1 other) {
        return this.name.compareTo(other.name);
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}

public class comparable {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Alice", 24));
        list.add(new Student1("Bob", 22));
        list.add(new Student1("Charlie", 23));

        Collections.sort(list);  // Uses Comparable

        System.out.println(list);
        
    }
}
