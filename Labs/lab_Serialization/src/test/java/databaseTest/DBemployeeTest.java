package databaseTest;

import databaseService.DBconnector;
import databaseService.DBemployeeService;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBemployeeTest {

    Employee employee=Employee.newEmployeeBuilder()
            .setFirstName("Miley")
            .setSecondName("Cyrus")
            .setEmailAddress("mileycRay@gmail.com")
            .setPhoneNumber("+380992876367")
            .setWorkingPosition("HR manager")
            .setSalary(7850.0)
            .setFirstDayAtWork(LocalDate.of(2013,10,10))
            .setDateOfBirth(LocalDate.of(1991,9,21))
            .build();

    Employee employeeUPDATE=Employee.newEmployeeBuilder()
            .setFirstName("Miley")
            .setSecondName("Cyrus")
            .setEmailAddress("mileyc@gmail.com")
            .setPhoneNumber("+380952876367")
            .setWorkingPosition("HR manager")
            .setSalary(9586.0)
            .setFirstDayAtWork(LocalDate.of(2013,10,10))
            .setDateOfBirth(LocalDate.of(1991,9,21))
            .build();


    @DataProvider
    Object[][] DBemployeeProvider() throws SQLException {
        DBemployeeService dBemployeeService=new DBemployeeService();
        DBconnector dBconnector=new DBconnector();
        String countEmployees= "SELECT COUNT(*) FROM employee";
        PreparedStatement preparedStatement=dBconnector.getConnection().prepareStatement(countEmployees);
        ResultSet resultSet1=preparedStatement.executeQuery();
        int count1=6,count2=4;
        while (resultSet1.next()) {
            count1 = resultSet1.getInt(1);
        }
        dBemployeeService.addEmployee(employee,22);
        dBemployeeService.deleteEmployee(22);

        ResultSet resultSet2=preparedStatement.executeQuery();
        while (resultSet2.next()) {
            count2 = resultSet2.getInt(1);
        }
        dBemployeeService.closeConnector();
        return new Object[][]{{count1,count2}};
    }

    @Test(dataProvider ="DBemployeeProvider" )
    public void add_delete_EmployeeDBtest(int count1, int count2) throws SQLException {
        Assert.assertEquals(count1,count2);
    }

    @DataProvider
    Object[][] getEmployeeProvider() throws SQLException {
        DBemployeeService dBemployeeService=new DBemployeeService();
        dBemployeeService.addEmployee(employee, 335);
        Employee employeeREZULT=dBemployeeService.getEmployee(335);
        dBemployeeService.deleteEmployee(335);
        dBemployeeService.closeConnector();
        return new Object[][]{{employee,employeeREZULT}};
    }

    @Test(dataProvider = "getEmployeeProvider")
    public void getEmployeeDBTest(Employee employee_expected, Employee employee_rezult){
        Assert.assertEquals(employee_expected,employee_rezult);
    }

    @DataProvider
    Object[][] updateEmployeeProvider() throws SQLException {
        DBemployeeService dBemployeeService=new DBemployeeService();
        dBemployeeService.addEmployee(employee, 778);
        dBemployeeService.updateEmployee(employeeUPDATE,778);
        Employee employeeREZULT=dBemployeeService.getEmployee(778);
        dBemployeeService.deleteEmployee(778);
        dBemployeeService.closeConnector();
        return  new Object[][]{{employeeUPDATE,employeeREZULT}};
    }

    @Test(dataProvider = "updateEmployeeProvider")
    public void updateEmployeeDBTest(Employee employee_expected, Employee employee_rezult){
        Assert.assertEquals(employee_expected,employee_rezult);
    }

}
