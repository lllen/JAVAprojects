package serializationTest;

import department.Department;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.DepartmentJSONserialization;
import serialization.DepartmentTXTserialization;
import serialization.DepartmentXMLserialization;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSerializationTest {

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

    @BeforeClass
    public void setObject(){
        employeeSet.add(empl1);
        employeeSet.add(empl2);
        employeeSet.add(empl3);
        employeeSet.add(empl4);
        employeeSet.add(empl5);
        employeeSet.add(empl6);

    }



    @DataProvider
    Object[][] JSONserializationProvider() throws IOException {

        Department department=Department.newDepartmentBuilder()
                .setEmployees(employeeSet)
                .setDepartmentName("Json department")
                .build();
        String filename="test_department_deser.json";
        return new Object[][]{{new DepartmentJSONserialization(), department,filename}};
    }
/*

    @Test(dataProvider = "JSONserializationProvider")
    public void JSONserializationTest(DepartmentJSONserialization JSONserialization,Department  department, String  filename) throws IOException {
        JSONserialization.serializingObj(department,new FileWriter(filename));
    }
*/

    @Test(dataProvider = "JSONserializationProvider")
    public void JSONdeserializationTest(DepartmentJSONserialization JSONserialization,Department  department, String  filename) throws IOException {
        Assert.assertEquals(JSONserialization.deserializingObj(new FileReader(filename)),department);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    Object[][] XMLserializationProvider() throws IOException {

        Department department=Department.newDepartmentBuilder()
                .setEmployees(employeeSet)
                .setDepartmentName("XML department")
                .build();
        String filename="test_department_deser.xml";
        return new Object[][]{{new DepartmentXMLserialization(), department,filename}};
    }
   /* @Test(dataProvider = "XMLserializationProvider")
    public void XMLserializationTest(DepartmentXMLserialization XMLserialization, Department department, String filename) throws IOException {
        XMLserialization.serializingObj(department,new FileWriter(filename));
    }*/
    @Test(dataProvider = "XMLserializationProvider")
    public void XMLdeserializationTest(DepartmentXMLserialization XMLserialization, Department department, String filename) throws IOException, JAXBException {
        Assert.assertEquals(XMLserialization.deserializingObj(new FileReader(filename)),department);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DataProvider
    Object[][] TXTserializationProvider() throws IOException {

        Department department1=Department.newDepartmentBuilder()
                .setEmployees(employeeSet)
                .setDepartmentName("TXT department")
                .build();
        String filename="test_department_deser.txt";
        return new Object[][]{{new DepartmentTXTserialization(), department1,filename}};
    }

  /* @Test(dataProvider = "TXTserializationProvider")
    public void TXTserializationTest(DepartmentTXTserialization TXTserialization, Department department, String filename) throws IOException {
        TXTserialization.serializingObj(department,new FileWriter(filename));
    }*/

    @Test(dataProvider = "TXTserializationProvider")
    public void TXTdeserializationTest(DepartmentTXTserialization TXTserialization, Department department, String filename) throws IOException, JAXBException {
        Assert.assertEquals(TXTserialization.deserializingObj(new FileReader(filename)),department);
    }

}
