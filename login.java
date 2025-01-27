import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;


public class login {
   private final  static String url="jdbc:mysql://localhost:3306/medicalinventorydatab";
   private  final static   String username = "root";
   private  final static  String password = "kanishka";
   private final static String query = "Select * from staff WHERE Username=? AND PasswordHash=?";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        System.out.println("Enter your username");
         String username2 = sc.next();
         System.out.println("Enter the password ");
        String password2= sc.next();
        if(check(username2, password2)){
                    System.out.println("Login Successful!!!");
                }
                else{
                    System.out.println("Login Failed");
                }
               
            
        }
             static boolean check(String username2, String password2) {
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                 
                    }
                    catch(ClassNotFoundException e){
                       
                    }
                try{
                    Connection con = DriverManager.getConnection(url, username, password);
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                                   preparedStatement.setString(1,username2);
                                   preparedStatement.setString(2 , password2);
                ResultSet  rs = preparedStatement.executeQuery();
                     return rs.next();
                }
                catch(SQLException e){
                   
                }
                return false;
        }
    }
