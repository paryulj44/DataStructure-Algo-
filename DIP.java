package SOLID;

import javax.xml.crypto.Data;

/*D → Dependency Inversion Principle (DIP)

"High-level modules should not depend on low-level modules. Both should depend on abstractions." */
// ❌ Bad: High-level depends on low-level
/*class MySQLDatabase { void save() { } }
class UserService {
    private MySQLDatabase db = new MySQLDatabase();
    void saveUser() { db.save(); }
}*/
// ✅ Good: High-level depends on abstraction
interface Database { void save(); }

//Low-Level Module
class MySQLDatabase implements Database{
public void save() { 
    System.out.println("Saved to MySQL"); 
}
}
//High-Level Module
class UserService {
    private Database db;
    UserService(Database db) { this.db = db; }
    void saveUser() { 
    db.save(); 
    System.out.println("user saved in db!!");
}
        
    
}
public class DIP {
    public static void main(String[] args){
        Database mysql = new MySQLDatabase();   // concrete implementation
        UserService d1 = new UserService(mysql);   // concrete implementation
        d1.saveUser();                               // concrete implementation
    }
}
