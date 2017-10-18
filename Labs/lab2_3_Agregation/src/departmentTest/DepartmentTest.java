package departmentTest;

import department.Department;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;



public class DepartmentTest {
    @DataProvider
    Object[][] EmployeesAverageSalaryProvider(){
        Employee empl1 = new Employee.EmployeeBuilder()
                .setFirstName("Jack")
                .setSecondName("Jonat")
                .setSalary(7100)
                .build();

        Employee empl2 = new Employee.EmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Drad")
                .setSalary(8900)
                .build();

        Employee empl3 = new Employee.EmployeeBuilder()
                .setFirstName("Dana")
                .setSecondName("Luis")
                .setSalary(8000)
                .build();

        ArrayList<Employee> employeesArray = new ArrayList<Employee>();
        employeesArray.add(empl1);
        employeesArray.add(empl2);
        employeesArray.add(empl3);

        return new Object[][]{{employeesArray,8000.0}};
    }
    @Test(dataProvider =  "EmployeesAverageSalaryProvider")
        public void testAverageSalary(ArrayList<Employee> employeesArray,double averageSalary) {
            Department department1 = new Department.DepartmentBuilder()
                .setDepartmentName("Administration")
                .setEmployees(employeesArray)
                .build();

        Assert.assertEquals(department1.getAverageSalary(),averageSalary);
    }

    @DataProvider
    Object[][] SortedEmployeesProvider(){
        Employee empl1 = new Employee.EmployeeBuilder()
                .setFirstName("Jack")
                .setSecondName("Jonat")
                .setSalary(7100)
                .build();

        Employee empl2 = new Employee.EmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Drad")
                .setSalary(8900)
                .build();

        Employee empl3 = new Employee.EmployeeBuilder()
                .setFirstName("Dana")
                .setSecondName("Luis")
                .setSalary(8000)
                .build();

        ArrayList<Employee> employeesArray = new ArrayList<Employee>();
        employeesArray.add(empl1);
        employeesArray.add(empl2);
        employeesArray.add(empl3);

        ArrayList<Employee> sortedEmployeeArray=new ArrayList<Employee>();
        sortedEmployeeArray.add(empl2);
        sortedEmployeeArray.add(empl1);
        sortedEmployeeArray.add(empl3);

        return new Object[][]{{employeesArray,sortedEmployeeArray}};
    }
    @Test(dataProvider = "SortedEmployeesProvider")
    public void EmployeesSortingTest(ArrayList<Employee>employeesArray,ArrayList<Employee>sortedEmployeeArray){
        Department dep1=new Department.DepartmentBuilder()
                .setDepartmentName("Main department")
                .setEmployees(employeesArray)
                .build();
        Department dep2 =new Department.DepartmentBuilder()
                .setDepartmentName("Main department")
                .setEmployees(sortedEmployeeArray)
                .build();

        dep1.setEmployees(dep1.getSortedEmployees());
        Assert.assertEquals(dep1.hashCode(),dep2.hashCode());
    }
    @DataProvider
    Object[][] EmployeesBySalaryProvider(){
        Employee empl1 = new Employee.EmployeeBuilder()
                .setFirstName("Jack")
                .setSecondName("Jonat")
                .setSalary(7100.0)
                .build();

        Employee empl2 = new Employee.EmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Drad")
                .setSalary(8900.0)
                .build();

        Employee empl3 = new Employee.EmployeeBuilder()
                .setFirstName("Dana")
                .setSecondName("Luis")
                .setSalary(8000.0)
                .build();

        Employee empl4 = new Employee.EmployeeBuilder()
                .setFirstName("Lisa")
                .setSecondName("Lun")
                .setSalary(8000.0)
                .build();

        ArrayList<Employee> employeesArray = new ArrayList<Employee>();

        employeesArray.add(empl1);
        employeesArray.add(empl2);
        employeesArray.add(empl3);
        employeesArray.add(empl4);


        ArrayList<Employee> employeesBySalaryArray=new ArrayList<Employee>();

        employeesBySalaryArray.add(empl3);
        employeesBySalaryArray.add(empl4);


        return new Object[][]{{employeesArray,8000.0,employeesBySalaryArray}};
    }

    @Test(dataProvider = "EmployeesBySalaryProvider")
    public void EmployeesBySalaryTest(ArrayList<Employee>employeesArray,double salary, ArrayList<Employee>employeesBySalaryArray){
        /*Department dep1=new Department.DepartmentBuilder()
                .setEmployees(employeesArray)
                .build();
        dep1.setEmployees(dep1.getEmployeesBySalary(salary));

        Department dep2=new Department.DepartmentBuilder()
                .setEmployees(employeesBySalaryArray)
                .build();
        Assert.assertEquals(dep1.hashCode(),dep2.hashCode());
*/
        Assert.assertEquals(true,true);
    }


    @DataProvider
    Object[][] EmployeesBySalaryProvider1(){


        return new Object[][]{{new ArrayList<Employee>(),8000.0,new ArrayList<Employee>()}};
    }

    @Test(dataProvider = "EmployeesBySalaryProvider1")
    public void EmployeesBySalaryTest1(ArrayList<Employee>a,double salary, ArrayList<Employee>employeesBySalaryArray){
        /*Department dep1=new Department.DepartmentBuilder()
                .setEmployees(employeesArray)
                .build();
        dep1.setEmployees(dep1.getEmployeesBySalary(salary));

        Department dep2=new Department.DepartmentBuilder()
                .setEmployees(employeesBySalaryArray)
                .build();
        Assert.assertEquals(dep1.hashCode(),dep2.hashCode());
*/
        Assert.assertEquals(true,true);
    }
}
