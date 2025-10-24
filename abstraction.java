package OOPs;

//hiding implementation details and only exposing essential feature

//abstract class
abstract class vehicle{
     abstract void start(); // abstract method
}
//concrete class
class Car extends vehicle{
    @Override
     void start(){
        System.out.println("car is started");
    }
}
public class abstraction {
    public static void main(String[] args){
        vehicle obj = new Car();
        obj.start();
    }
}
