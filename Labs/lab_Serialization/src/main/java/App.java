import databaseService.DBconnector;
import databaseService.DBdepartmentService;
import databaseService.DBemployeeService;
import department.Department;
import employee.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class App {


    public static void main(String[] args) throws SQLException {


        Employee empl1 = Employee.newEmployeeBuilder()
                .setFirstName("Chris")
                .setSecondName("Shwark")
                .setEmailAddress("ChrisSHW@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setDateOfBirth(LocalDate.of(2000,12,05))
                .setFirstDayAtWork(LocalDate.of(2016,11,12))
                .setPhoneNumber("+380506612713")
                .setSalary(7100)
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setFirstName("Tovm")
                .setSecondName("Kolins")
                .setEmailAddress("TKolins@yandex.ua")
                .setWorkingPosition("admin")
                .setDateOfBirth(LocalDate.of(1990,01,07))
                .setFirstDayAtWork(LocalDate.of(2013,10,02))
                .setPhoneNumber("+380506812811")
                .setSalary(8580)
                .build();

        Employee empl3 =Employee.newEmployeeBuilder()
                .setFirstName("Vera")
                .setSecondName("Trolt")
                .setEmailAddress("veravera@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setDateOfBirth(LocalDate.of(1995,9,15))
                .setFirstDayAtWork(LocalDate.of(2016,3,10))
                .setPhoneNumber("+380996612817")
                .setSalary(8459)
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setFirstName("Lilly")
                .setSecondName("Cowblack")
                .setEmailAddress("lilly@yandex.ua")
                .setWorkingPosition("data base developer")
                .setDateOfBirth(LocalDate.of(1994,11,22))
                .setFirstDayAtWork(LocalDate.of(2011,11,23))
                .setPhoneNumber("+380956612799")
                .setSalary(12580)
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setFirstName("Julia")
                .setSecondName("Roberts")
                .setEmailAddress("Juli@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setDateOfBirth(LocalDate.of(1992,12,05))
                .setFirstDayAtWork(LocalDate.of(2013,11,12))
                .setPhoneNumber("+380666612713")
                .setSalary(5085)
                .build();

        Employee empl6 =Employee.newEmployeeBuilder()
                .setFirstName("Andrew")
                .setSecondName("Zabur")
                .setEmailAddress("zabur11@yandex.ua")
                .setWorkingPosition("Main director")
                .setDateOfBirth(LocalDate.of(1998,10,9))
                .setFirstDayAtWork(LocalDate.of(2017,11,12))
                .setPhoneNumber("+380999912713")
                .setSalary(10000)
                .build();
        List<Employee> employeeSet=new ArrayList<Employee>();

        employeeSet.add(empl1);
        employeeSet.add(empl2);
        employeeSet.add(empl3);
        employeeSet.add(empl4);
        employeeSet.add(empl5);
        employeeSet.add(empl6);


        DBdepartmentService dBdepartmentService=new DBdepartmentService();
        Department department= new Department();
        department.setEmployees(employeeSet);
        department.setDepartmentName("Test");
        dBdepartmentService.addDepartment(department,2221);
        //Department departmentExpected=dBdepartmentService.getDepartment(2221);
        //dBdepartmentService.deleteDepartment(2221);
        dBdepartmentService.closeConnector();

    }
}
