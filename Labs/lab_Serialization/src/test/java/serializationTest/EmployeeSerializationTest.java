package serializationTest;

//import employee.Employee;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.EmployeeJSONserialization;
import serialization.EmployeeXMLserialization;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.time.LocalDate;

public class EmployeeSerializationTest {


    Employee employee=Employee.newEmployeeBuilder()
            .setFirstName("Miley")
            .setSecondName("Cyrus")
            .setEmailAddress("mileycRay@gmail.com")
            .setPhoneNumber("+380992776367")
            .setWorkingPosition("office admin")
            .setSalary(9850)
            .setFirstDayAtWork(LocalDate.of(2013,10,10))
            .setDateOfBirth(LocalDate.of(1991,9,21))
            .build();

    public void m(){
        Employee test1Employee = new Employee();
        test1Employee.setFirstName("Miley");
    }


    String fileName_json="employee.json";
    String fileName_xml="employee.xml";
    String fileName_txt="employee.txt";


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    * JSON serialization and deserialization tests
    *
    * */

    @DataProvider
    Object[][]JSONserializationEmployeeProvider() throws IOException {
        Writer file_in=new FileWriter(fileName_json);
        EmployeeJSONserialization jsonSerial=new EmployeeJSONserialization();
        return new Object[][]{{new EmployeeJSONserialization(),employee,file_in}};
    }

    @Test(dataProvider = "JSONserializationEmployeeProvider")
    public void JSONserializationEmployeeTest(EmployeeJSONserialization jsonSerial,Employee employee,Writer file_in) throws IOException {
        jsonSerial.serializingObj(employee,file_in);
    }

    @DataProvider
    Object[][]JSONdeserializationEmployeeProvider() throws IOException {
        Reader file_out=new FileReader(fileName_json);
        EmployeeJSONserialization jsonSerial=new EmployeeJSONserialization();
        return new Object[][]{{new EmployeeJSONserialization(),employee,file_out}};
    }

    @Test(dataProvider = "JSONdeserializationEmployeeProvider")
    public void JSONdeserializationEmployeeTest(EmployeeJSONserialization jsonDeserial, Employee employee, Reader file_out) throws IOException {
        Employee employee1=jsonDeserial.deserializingObj(file_out);
        Assert.assertEquals(employee1,employee);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    * XML serialization and deserialization tests
    *
    * */

    @DataProvider
    Object[][]XMLserializationEmployeeProvider() throws IOException {
        Writer file_in=new FileWriter(fileName_xml);
        EmployeeXMLserialization jsonSerial=new EmployeeXMLserialization();
        return new Object[][]{{new EmployeeXMLserialization(),employee,file_in}};
    }

    @Test(dataProvider = "XMLserializationEmployeeProvider")
    public void XMLserializationEmployeeTest(EmployeeXMLserialization xmlSerial,Employee employee,Writer file_in) throws IOException {
        xmlSerial.serializingObj(employee,file_in);
    }

    @DataProvider
    Object[][]XMLdeserializationEmployeeProvider() throws IOException {
        Reader file_out=new FileReader(fileName_xml);
        EmployeeXMLserialization jsonSerial=new EmployeeXMLserialization();
        return new Object[][]{{new EmployeeXMLserialization(),employee,file_out}};
    }

    @Test(dataProvider = "XMLdeserializationEmployeeProvider")
    public void XMLdeserializationEmployeeTest(EmployeeXMLserialization xmlDeserial, Employee employee, Reader file_out) throws IOException, JAXBException {
        Employee employee1=xmlDeserial.deserializingObj(file_out);
       Assert.assertEquals(employee1,employee);
    }



}
