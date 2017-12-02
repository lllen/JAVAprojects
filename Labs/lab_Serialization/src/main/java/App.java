import databaseApp.DBconnector;

import java.sql.*;


public class App {

    private static final String INSER_NEW="INSERT INTO employee VALUES(?,?,?,?,?,?,?,?)";
    private static final String GET_ALL="SELECT * FROM employee";
    private static final String DELETE="DELETE FROM employee";


    public static void main(String[] args) throws SQLException {

       DBconnector dBconnector=new DBconnector();
       PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement(DELETE);

       preparedStatement.executeUpdate();

        /*ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Employee employee = new Employee();
            employee.setFirstName(resultSet.getString(2));
            employee.setSecondName(resultSet.getString(3));
            employee.setEmailAddress(resultSet.getString(7));
            employee.setPhoneNumber(resultSet.getString(6));


            System.out.println(employee.getFirstName());
            System.out.println(employee.getSecondName());
            System.out.println(employee.getFirstDayAtWork());
            System.out.println(employee.getDateOfBirth());
            System.out.println(employee.getWorkingPosition());
            System.out.println(employee.getPhoneNumber());
            System.out.println(employee.getEmailAddress());

        }
*/

/*

       preparedStatement.setInt(1,5);
       preparedStatement.setString(2,"Misha");
       preparedStatement.setString(3,"Rozhko");
       preparedStatement.setDate(4, Date.valueOf(LocalDate.of(2000,11,10)));
       preparedStatement.setDate(5,Date.valueOf(LocalDate.of(1998,10,5)));
       preparedStatement.setString(6,"+380992773667");
       preparedStatement.setString(7,"olena@gmail.ua");
       preparedStatement.setString(8,"admin");
*/



        // / String request="select * from employee";
       /* statement.execute("INSERT INTO  employee(firstName,secondName)VALUES ('Lenok','Rozhok');");
        statement.execute("INSERT INTO  employee(firstName,secondName)VALUES ('Lenok','Rozhok');");*/

        //statement.execute("INSERT INTO  simpletable(name,age)VALUES ('Lenok',25);");
        //statement.executeUpdate("UPDATE simpletable SET name='newlenok' where age=25;");
        //statement.executeQuery("SELECT * FROM simpletable;");
      /*  statement.addBatch("INSERT INTO  simpletable(name,age)VALUES ('batch1',31);");
        statement.addBatch("INSERT INTO  simpletable(name,age)VALUES ('batch2',32);");
        statement.addBatch("INSERT INTO  simpletable(name,age)VALUES ('batch3',33);");

        statement.executeBatch();
        statement.clearBatch();*/

       /* System.out.println(statement.isClosed());
        statement.getConnection();
        statement.close();*/

    }
}
