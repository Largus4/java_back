import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Bd {
    private static Connection connection = null;
    private static String URL= "jdbc:postgresql://127.0.0.1:5432/j";
    private static String USERNAME= "postgres";
    private static String PASSWORD= "1234";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Statement stat = null;
        ResultSet result =null;
        String login = "";
        System.out.println("Введите логин");
        String login1 = sc.next();
        String pass = "";
        System.out.println("Введите пароль");
        String pass1 = sc.next();
        String SQL ="";
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            SQL = "SELECT id, login, password\n" +
                    "\tFROM public.security WHERE security.login = '" + login1+"'";
            stat = connection.createStatement();
            result= stat.executeQuery(SQL);
            while (result.next()){
                login= result.getString("login");
                System.out.println(login);
                pass= result.getString("password");
                System.out.println(pass);
            }
            if (pass.equals(pass1)) {
                System.out.println("Строки равны");
            } else {
                System.out.println("Строки не равны");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {

        }



    }


}
