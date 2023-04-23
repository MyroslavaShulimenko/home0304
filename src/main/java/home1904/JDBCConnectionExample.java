package home1904;

import java.sql.*;

public class JDBCConnectionExample {
    public static void main(String[] args)  {
     // Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","3123Mira");
             Statement statement=connection.createStatement();) {

            statement.setFetchSize(20);// кол-во элементов за один проход
            //ResultSet resultSet = statement.executeQuery("select now()");
            ResultSet resultSet = statement.executeQuery("select * from countrylanguage ");
            int columnCount = resultSet.getMetaData().getColumnCount();
            //boolean execute = statement.execute("select now()");
        //    ResultSet resultSet = statement.getResultSet(); //можно с его помощю доставать результат
            //resultSet.next() - это итератор
          while (resultSet.next()){
              for (int i = 1; i <=columnCount ; i++) {
                  System.out.print(resultSet.getString(i)+" "); //colum
              }
              System.out.println("\n");
          }
//resultSet.close();
          statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
