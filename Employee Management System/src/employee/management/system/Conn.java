package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection conection ;
    Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeManagementSystem","root","9829697896@Ankit");
            statement = conection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
