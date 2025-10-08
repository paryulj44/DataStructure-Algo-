import java.util.Objects;

class worker{
    private String name;
    private int id;

    public worker(int id, String nm){
        this.id = id;
        this.name = nm;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, id); // Java utility method
    }
    /* Internal working of Objects.hash
     * public static int hash(Object... values) {
            return Arrays.hashCode(values);
        }
       and inside Arrays.hashCode(Object[] a):
       public static int hashCode(Object[] a) {
            if (a == null)
                return 0;

            int result = 1;
            for (Object element : a)
                result = 31 * result + (element == null ? 0 : element.hashCode());
             return result;
        }
         int hash = Objects.hash(10, "John", true);
        Internally:

        result = 1
        result = 31 * 1 + 10.hashCode()           → 41
        result = 31 * 41 + "John".hashCode()      → 31*41 + 2314539 = 2327248
        result = 31 * 2327248 + Boolean.TRUE.hashCode() → 72044779 (not random, derived mathematically).
     */

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof worker)) return false;
        worker w = (worker) o;
        return id == w.id && Objects.equals(name, w.name);
    }
}

public class hashcode {
    public static void main(String[] args){
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        worker w1 = new worker(1, "pj");
        worker w2 = new worker(2, "sj");

        System.out.println(w1.equals(w2));
        System.out.println(w1.hashCode());
        System.out.println(w2.hashCode());
        worker w3 = new worker(1, "pj");
        System.out.println(w3.equals(w1));
    }
}
