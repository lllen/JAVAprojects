package databaseApp;

import employee.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBemployeeApp {

    private final String INSERT_NEW_EMPLOYEE="INSERT INTO employee VALUES(?,?,?,?,?,?,?,?)";

    public DBconnector Connect(){
        DBconnector dBconnector=new DBconnector();
        return  dBconnector;
    }

    public void addEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement(INSERT_NEW_EMPLOYEE);

        preparedStatement.setString(2,employee.getFirstName());
        preparedStatement.setString(3,employee.getSecondName());
        preparedStatement.setDate(4, Date.valueOf(employee.getDateOfBirth()));
        preparedStatement.setDate(5,Date.valueOf(employee.getFirstDayAtWork()));
        preparedStatement.setString(6,employee.getPhoneNumber());
        preparedStatement.setString(7,employee.getEmailAddress());
        preparedStatement.setString(8,employee.getWorkingPosition());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public int getIDemployeeBySecondFirstName(Employee employee) throws SQLException {
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement("SELECT id_employee FROM employee WHERE firstName= employee.firstName, secondName=employee.secondName");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getInt(1);
    }

    public Employee getEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement("SELECT * FROM employee WHERE id_employee=id");
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
        }
        preparedStatement.close();
        return employee;
    }

    public void updateEmployee(int id){

    }

    public Employee getEmployeeBySalary(double find_salary) throws SQLException {
        Employee employee=new Employee();
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement("SELECT * FROM employee WHERE salary=find_salary");
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            employee.setFirstName(resultSet.getString(2));
            employee.setSecondName(resultSet.getString(3));
            employee.setDateOfBirth(resultSet.getDate(4).toLocalDate());
            employee.setFirstDayAtWork(resultSet.getDate(5).toLocalDate());
            employee.setPhoneNumber(resultSet.getString(6));
            employee.setEmailAddress(resultSet.getString(7));
            employee.setWorkingPosition(resultSet.getString(8));
        }
        preparedStatement.close();
        return employee;
    }

    public void deleteEmployee(int id) throws SQLException {
        PreparedStatement preparedStatement=this.Connect().getConnection().prepareStatement("DELETE FROM employee WHERE id_employee=id");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
