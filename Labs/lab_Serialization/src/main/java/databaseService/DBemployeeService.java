package databaseService;
import databaseService.DBconnector;
import employee.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBemployeeService {

    DBconnector dBconnector;
    private final String INSERT_NEW_EMPLOYEE="INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?)";

    public DBemployeeService(){
        dBconnector=new DBconnector();
    }

    public void addEmployee(Employee employee, int id) throws SQLException {

        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement(INSERT_NEW_EMPLOYEE);

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,employee.getFirstName());
        preparedStatement.setString(3,employee.getSecondName());
        preparedStatement.setDate(4, Date.valueOf(employee.getDateOfBirth()));
        preparedStatement.setDate(5,Date.valueOf(employee.getFirstDayAtWork()));
        preparedStatement.setString(6,employee.getPhoneNumber());
        preparedStatement.setString(7,employee.getEmailAddress());
        preparedStatement.setString(8,employee.getWorkingPosition());
        preparedStatement.setDouble(9,employee.getSalary());
        preparedStatement.setInt(10,1);
        preparedStatement.execute();
        preparedStatement.close();
    }


    public Employee getEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("SELECT * FROM employee WHERE id_employee='"+id+"';");
        ResultSet resultSet=preparedStatement.executeQuery();
        Employee employee=new Employee();
        while(resultSet.next()){
            employee.setFirstName(resultSet.getString(2));
            employee.setSecondName(resultSet.getString(3));
            employee.setDateOfBirth(resultSet.getDate(4).toLocalDate());
            employee.setFirstDayAtWork(resultSet.getDate(5).toLocalDate());
            employee.setPhoneNumber(resultSet.getString(6));
            employee.setEmailAddress(resultSet.getString(7));
            employee.setWorkingPosition(resultSet.getString(8));
            employee.setSalary(resultSet.getDouble(9));
        }
        preparedStatement.close();
        return employee;
    }

    public void updateEmployee(Employee employee1, int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("UPDATE employee SET employee.firstName=  '"+employee1.getFirstName()+"', " +
                        "employee.secondName= '"+employee1.getSecondName()+"'," +
                        "employee.emailAddress= '"+employee1.getEmailAddress()+ "'," +
                        "employee.dateOfBirth= '"+Date.valueOf(employee1.getDateOfBirth())+"'," +
                        "employee.fisrtDayAtWork= '"+Date.valueOf(employee1.getFirstDayAtWork()) + "'," +
                        "employee.phoneNumber = '" + employee1.getPhoneNumber() + "'," +
                        "employee.workingPostion = '" + employee1.getWorkingPosition() + "'," +
                        "employee.salary = " + employee1.getSalary()  +
                        " WHERE employee.id_employee= " + id + ";" );
        preparedStatement.execute();
    }

/*    public Employee getEmployeeBySalary(double find_salary) throws SQLException {
        Employee employee=new Employee();
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("SELECT * FROM employee WHERE salary= " + find_salary + ";");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            employee.setFirstName(resultSet.getString(2));
            employee.setSecondName(resultSet.getString(3));
            employee.setDateOfBirth(resultSet.getDate(4).toLocalDate());
            employee.setFirstDayAtWork(resultSet.getDate(5).toLocalDate());
            employee.setPhoneNumber(resultSet.getString(6));
            employee.setEmailAddress(resultSet.getString(7));
            employee.setWorkingPosition(resultSet.getString(8));
            employee.setSalary(resultSet.getDouble(9));
        }
        preparedStatement.close();
        dBconnector.closeConnection();
        return employee;
    }*/

    public void deleteEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement("DELETE FROM employee WHERE id_employee=" + id + ";");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void closeConnector() throws SQLException {
        dBconnector.closeConnection();
    }

}
