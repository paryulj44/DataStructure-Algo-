package SOLID;
/*I → Interface Segregation Principle (ISP)

"Clients should not be forced to implement interfaces they don’t use." */
/*interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() { System.out.println("Working"); }
    public void eat() { throw new UnsupportedOperationException(); } // ❌ violates ISP
}*/
// ✅ Good: segregate interfaces
interface Workable { void work(); }
interface Eatable { default void eat(){
    System.out.println("default eatable running ....");
} }

class Human implements Workable, Eatable { 
    public void work(){
    System.out.println("human workable running.....");
}
    @Override
    public void eat(){
        // super();   //Java me super() sirf constructor me call hota hai, method me nahi
        Eatable.super.eat(); // ✅ correct way to call default method from interface
        System.out.println("human eatable running....");
    }
}
class Robot implements Workable { public void work(){
    System.out.println("robot workable running.....");
}}
public class ISP {
    public static void main(String[] args){
        Workable w1 = new Human();
        w1.work();
        
        Human h1 = new Human();
        h1.work();
        h1.eat();

        Eatable e1 = new Human();
        e1.eat();

        Workable w2 = new Robot();
        w2. work();
    }
}
