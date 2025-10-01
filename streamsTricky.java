import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Emplyee{
    String empNm;
    int id;
    double salry;

    public Emplyee(int id, String empNm, double salry){
        this.id = id;
        this.empNm = empNm;
        this.salry = salry;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", name='" + empNm + "', salary=" + salry + "}";
    }
}


public class streamsTricky {
    public static void main(String[] args){
       List<Emplyee> employees = Arrays.asList(
            new Emplyee(101, "Alice", 45000),
            new Emplyee(102, "Bob", 55000),
            new Emplyee(103, "Charlie", 75000),
            new Emplyee(104, "David", 60000),
            new Emplyee(105, "Eve", 50000)
        );

        Emplyee highestPaid = employees.stream().max(Comparator.comparingDouble(emp -> emp.salry))
                .get();

        System.out.println("Employee with highest salary: " + highestPaid);

        //Ques Ek list of transactions filter karo jisme amount > 1000 ho aur unko descending order me sort karo.
        List<Integer> lst = Arrays.asList(1100,980,3490,278,6789);
        List<Integer> res = lst.stream().sorted(Comparator.reverseOrder()).filter(n -> n > 1000).collect(Collectors.toList());
        System.out.println(res);
    }
}
