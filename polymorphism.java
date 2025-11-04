package OOPs;
// same method name but different behaviours
// 2 types :- method overloading (compile-time) & method overriding(runtime)

class Calculator{
    public int sum(int a, int b){
        return a+b;
    }

    public double sum(double a, double b){
      return a+b;  
    } 
}

class Animal{
    void sound(){
        System.out.println("sound from parent class");
    }
}

class Dog extends Animal{
    @Override
    void sound(){
        System.out.println("sound from child class");
    }
}
public class polymorphism {
    public static void  main(String[] args){
        Calculator calObj  = new Calculator();
        //compile time
        System.out.println("sum of int: "+calObj.sum(4,8));
        System.out.println("sum of double: "+calObj.sum(6.2,2.8));
   
        Animal aobj = new Animal();
        aobj.sound();

        //runtime
        Animal dobj = new Dog();
        dobj.sound();
    }
}
