package Email_Managment;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection dbconnection() throws Exception
    {
    
         Connection con;
         Class.forName("com.mysql.jdbc.Driver");
//         Class.forName("com.mysql.cj.jdbc.Driver");
         con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "admin");
        
       return(con);
    }

   
    
}