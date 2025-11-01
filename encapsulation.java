package OOPs;
// wrap data(fields) & methods together while restricting the direct access (getter & setter methods)
class bankAccount{
    private int balance;

    public void deposit(int amt){
        balance += amt;
    }

    public int getBalance(){
        return balance;
    }
}

public class encapsulation {
    public static void main(String[] args){
        bankAccount obj = new bankAccount();
        obj.deposit(200);
        System.out.println("balance is: "+ obj.getBalance());
        obj.deposit(500);
        System.out.println("new balance is: "+ obj.getBalance());
    }
}
