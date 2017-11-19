package serializationTest;

import department.Department;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.DepartmentJSONserialization;
import serialization.DepartmentXMLserialization;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class DepartmentSerializationTest {

    @DataProvider
    Object[][] JSONserializationProvider() throws IOException {
        Employee empl1 = Employee.newEmployeeBuilder()
                .setFirstName("Chris")
                .setSecondName("Shwark")
                .setEmailAddress("ChrisSHW@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(7100)
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setFirstName("Tovm")
                .setSecondName("Kolins")
                .setEmailAddress("TKolins@yandex.ua")
                .setWorkingPosition("admin")
                .setSalary(8580)
                .build();

        Employee empl3 =Employee.newEmployeeBuilder()
                .setFirstName("Vera")
                .setSecondName("Trolt")
                .setEmailAddress("veravera@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(8459)
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setFirstName("Lilly")
                .setSecondName("Cowblack")
                .setEmailAddress("lilly@yandex.ua")
                .setWorkingPosition("data base developer")
                .setSalary(12580)
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setFirstName("Julia")
                .setSecondName("Roberts")
                .setEmailAddress("Juli@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(5085)
                .build();

        Employee empl6 =Employee.newEmployeeBuilder()
                .setFirstName("Andrew")
                .setSecondName("Zabur")
                .setEmailAddress("zabur11@yandex.ua")
                .setWorkingPosition("Main director")
                .setSalary(10000)
                .build();

        ArrayList<Employee> employeeSet=new ArrayList<Employee>();
        employeeSet.add(empl1);
        employeeSet.add(empl2);
        employeeSet.add(empl3);
        employeeSet.add(empl4);
        employeeSet.add(empl5);
        employeeSet.add(empl6);

        Department department=Department.newDepartmentBuilder()
                .setEmployees(employeeSet)
                .setDepartmentName("First department")
                .build();


        String filename="department.json";

        return new Object[][]{{new DepartmentJSONserialization(), department,filename}};
    }

    @Test(dataProvider = "JSONserializationProvider")
    public void JSONserializationTest(DepartmentJSONserialization JSONserialization,Department  department, String  filename) throws IOException {
        JSONserialization.serializingObj(department,new FileWriter(filename));
    }

    @Test(dataProvider = "JSONserializationProvider")
    public void JSONdeserializationTest(DepartmentJSONserialization JSONserialization,Department  department, String  filename) throws IOException {
        Assert.assertEquals(JSONserialization.deserializingObj(new FileReader(filename)),department);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    Object[][] XMLserializationProvider() throws IOException {
        Employee empl1 = Employee.newEmployeeBuilder()
                .setFirstName("Chris")
                .setSecondName("Shwark")
                .setEmailAddress("ChrisSHW@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(7100)
                .build();

        Employee empl2 = Employee.newEmployeeBuilder()
                .setFirstName("Tovm")
                .setSecondName("Kolins")
                .setEmailAddress("TKolins@yandex.ua")
                .setWorkingPosition("admin")
                .setSalary(8580)
                .build();

        Employee empl3 =Employee.newEmployeeBuilder()
                .setFirstName("Vera")
                .setSecondName("Trolt")
                .setEmailAddress("veravera@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(8459)
                .build();

        Employee empl4 = Employee.newEmployeeBuilder()
                .setFirstName("Lilly")
                .setSecondName("Cowblack")
                .setEmailAddress("lilly@yandex.ua")
                .setWorkingPosition("data base developer")
                .setSalary(12580)
                .build();

        Employee empl5 = Employee.newEmployeeBuilder()
                .setFirstName("Julia")
                .setSecondName("Roberts")
                .setEmailAddress("Juli@yandex.ua")
                .setWorkingPosition("Sale manager")
                .setSalary(5085)
                .build();

        Employee empl6 =Employee.newEmployeeBuilder()
                .setFirstName("Andrew")
                .setSecondName("Zabur")
                .setEmailAddress("zabur11@yandex.ua")
                .setWorkingPosition("Main director")
                .setSalary(10000)
                .build();

        ArrayList<Employee> employeeSet=new ArrayList<Employee>();
        employeeSet.add(empl1);
        employeeSet.add(empl2);
        employeeSet.add(empl3);
        employeeSet.add(empl4);
        employeeSet.add(empl5);
        employeeSet.add(empl6);

        Department department=Department.newDepartmentBuilder()
                .setEmployees(employeeSet)
                .setDepartmentName("First department")
                .build();


        String filename="department.xml";

        return new Object[][]{{new DepartmentXMLserialization(), department,filename}};
    }

    @Test(dataProvider = "XMLserializationProvider")
    public void XMLserializationTest(DepartmentXMLserialization XMLserialization, Department department, String filename) throws IOException {
        XMLserialization.serializingObj(department,new FileWriter(filename));
    }

    @Test(dataProvider = "XMLserializationProvider")
    public void XMLdeserializationTest(DepartmentXMLserialization XMLserialization, Department department, String filename) throws IOException, JAXBException {
        Assert.assertEquals(XMLserialization.deserializingObj(new FileReader(filename)),department);
    }

}
