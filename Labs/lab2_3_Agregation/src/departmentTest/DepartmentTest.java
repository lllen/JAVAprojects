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
        Employee empl1 = Employee.newEmployeeBuilder()
                .setSalary(7100)
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setSalary(8580)
                .build();

        Employee empl3 =Employee.newEmployeeBuilder()
                .setSalary(8459)
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setSalary(12580)
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setSalary(5085)
                .build();

        Employee empl6 =Employee.newEmployeeBuilder()
                .setSalary(6000)
                .build();

        ArrayList<Employee> employeesArray1 = new ArrayList<Employee>();
        employeesArray1.add(empl1);
        employeesArray1.add(empl2);
        employeesArray1.add(empl3);

        ArrayList<Employee> employeesArray2 = new ArrayList<Employee>();
        employeesArray2.add(empl2);
        employeesArray2.add(empl5);
        employeesArray2.add(empl6);

        ArrayList<Employee> employeesArray3 = new ArrayList<Employee>();
        employeesArray3.add(empl4);
        employeesArray3.add(empl6);
        employeesArray3.add(empl1);


        Department dep1=Department.newDepartmentBuilder()
                .setEmployees(employeesArray1)
                .build();

        Department dep2=Department.newDepartmentBuilder()
                .setEmployees(employeesArray2)
                .build();

        Department dep3=Department.newDepartmentBuilder()
                .setEmployees(employeesArray3)
                .build();

        return new Object[][]{{dep1.getAverageSalary(),24139.0/3.0},
                {dep2.getAverageSalary(),19665.0/3.0},
                {dep3.getAverageSalary(),25680.0/3.0}};
    }
    @Test(dataProvider =  "EmployeesAverageSalaryProvider")
        public void testAverageSalary(double averageSalary,double expected_averageSalary) {
            Assert.assertEquals(averageSalary,expected_averageSalary);
    }

    @DataProvider
    Object[][] SortedEmployeesProvider(){
        Employee empl1 = Employee.newEmployeeBuilder()
                .setSecondName("Jonat")
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setSecondName("Drad")
                .build();

        Employee empl3 = Employee.newEmployeeBuilder()
                .setSecondName("Luis")
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setSecondName("Jordan")
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setSecondName("Kolas")
                .build();

        Employee empl6 = Employee.newEmployeeBuilder()
                .setSecondName("Molpan")
                .build();

        ArrayList<Employee> employeesArray1 = new ArrayList<Employee>();
        employeesArray1.add(empl1);
        employeesArray1.add(empl2);
        employeesArray1.add(empl3);
        employeesArray1.add(empl4);
        employeesArray1.add(empl5);
        employeesArray1.add(empl6);

        ArrayList<Employee> sortedEmployeeArray1=new ArrayList<Employee>();
        sortedEmployeeArray1.add(empl2);
        sortedEmployeeArray1.add(empl1);
        sortedEmployeeArray1.add(empl4);
        sortedEmployeeArray1.add(empl5);
        sortedEmployeeArray1.add(empl3);
        sortedEmployeeArray1.add(empl6);

        Department dep1_notsorted=Department.newDepartmentBuilder()
                .setEmployees(employeesArray1)
                .build();

        Department dep2_sorted=Department.newDepartmentBuilder()
                .setEmployees(sortedEmployeeArray1)
                .build();

        dep1_notsorted.sortEmployees();
        return new Object[][]{{dep1_notsorted,dep2_sorted}};
    }
    @Test(dataProvider = "SortedEmployeesProvider")
    public void EmployeesSortingTest(Department dep,Department expected_dep){
        Assert.assertEquals(dep,expected_dep);
    }
    @DataProvider
    Object[][] EmployeesBySalaryProvider(){
        Employee empl1 = Employee.newEmployeeBuilder()
                .setSalary(7100.0)
                .build();

        Employee empl2 =Employee.newEmployeeBuilder()
                .setSalary(8900.0)
                .build();

        Employee empl3 = Employee.newEmployeeBuilder()
                .setSalary(8000.0)
                .build();

        Employee empl4 =Employee.newEmployeeBuilder()
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

        Department dep1 = Department.newDepartmentBuilder()
                .setEmployees(employeesArray)
                .build();

        Department dep2=Department.newDepartmentBuilder()
                .setEmployees(employeesBySalaryArray)
                .build();

        Department dep3=Department.newDepartmentBuilder()
                .build();

        dep3.setEmployees(dep1.getEmployeesBySalary(8000.0));

        return new Object[][]{{dep3,dep2}};
    }

    @Test(dataProvider = "EmployeesBySalaryProvider")
    public void EmployeesBySalaryTest(Department dep, Department expected_dep){
        Assert.assertEquals(dep,expected_dep);
    }

    @DataProvider
    Object[][] departmentNameProvider(){
        String depName1="Ftfyguhjk";
        String depName2="Gfyghjbnk hbjn";
        String depName3="GVBHJ";
        String depName4="Gghj Hghbj";
        String depName5="Ff8fr fr8";
        String depName6="Hgtg Jbj Jjk";

        Department dep1=Department.newDepartmentBuilder()
                .build();

        return new Object[][]{{dep1.checkDepartmentName(depName1),true},
                {dep1.checkDepartmentName(depName2),true},
                {dep1.checkDepartmentName(depName3),false},
                {dep1.checkDepartmentName(depName4),true},
                {dep1.checkDepartmentName(depName5),false},
                {dep1.checkDepartmentName(depName6),false}};
    }

    @Test(dataProvider = "departmentNameProvider")
    public void departmentNameTest(boolean rezult,boolean expected_rezult){
        Assert.assertEquals(rezult,expected_rezult);
    }
}
