//a immutable class in java is class whose object cannot be changed once created.
//advantage is thread safety, easy debugging. All wrapper class(Integer,Boolean, Byte etc) and String are immutable class
/*Rules - 1. class must declare Final --> ensure no child class can created
 * 2. data members private and final  --> ensure no direct access and can't changed
 * 3. only getters method , no setter method is allowed --> ensure no object can change variable
 * 4. parameterized constructor should initialize all the fields --> ensures deep copy and can't changed with obj reference
 */

final class MyImmutble {
  final private String name;
  final private int id;

  public MyImmutble(String name , int id){
    this.name = name;
    this.id = id;
  }
  
  public String getNm(){
    return "Hi, " + name;
  }

  public int getId(){
    return id;
  }
}

public class immutble{
  public static void main(String[] args){
    MyImmutble m = new MyImmutble("Alice", 1);
    System.out.println(m.getNm());
    System.out.println(m.getId());
  }
}