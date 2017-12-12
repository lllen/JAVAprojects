package serializationTest;

//import employee.Employee;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serialization.EmployeeJSONserialization;
import serialization.EmployeeTXTserialization;
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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    * JSON  deserialization test
    *
    * */

    @DataProvider
    Object[][]JSONserializationEmployeeProvider() throws IOException {
        String fileName_json="test_employee_deser.json";
        return new Object[][]{{new EmployeeJSONserialization(),employee,fileName_json}};
    }

   /* @Test(dataProvider = "JSONserializationEmployeeProvider")
    public void JSONserializationEmployeeTest(EmployeeJSONserialization jsonSerial,Employee employee,String file_in) throws IOException {
        jsonSerial.serializingObj(employee,new FileWriter(file_in));
    }*/

    @Test(dataProvider = "JSONserializationEmployeeProvider")
    public void JSONdeserializationEmployeeTest(EmployeeJSONserialization jsonDeserial, Employee employee, String file_out) throws IOException {
        Assert.assertEquals(jsonDeserial.deserializingObj(new FileReader(file_out)),employee);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*
    * XML deserialization test
    *
    * */

    @DataProvider
    Object[][]XMLserializationEmployeeProvider() throws IOException {
        String fileName_xml="test_employee_deser.xml";
        return new Object[][]{{new EmployeeXMLserialization(),employee,fileName_xml}};
    }

   /* @Test(dataProvider = "XMLserializationEmployeeProvider")
    public void XMLserializationEmployeeTest(EmployeeXMLserialization xmlSerial,Employee employee,String  file_in) throws IOException {
        xmlSerial.serializingObj(employee,new FileWriter(file_in));
    }*/

    @Test(dataProvider = "XMLserializationEmployeeProvider")
    public void XMLdeserializationEmployeeTest(EmployeeXMLserialization xmlDeserial, Employee employee, String  file_out) throws IOException, JAXBException {
       Assert.assertEquals(xmlDeserial.deserializingObj(new FileReader(file_out)),employee);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
    * TXT deserialization test
    *
    * */

    @DataProvider
    Object[][]TXTserializationEmployeeProvider() throws IOException {
        String fileName_txt="test_employee_deser.txt";
        return new Object[][]{{new EmployeeTXTserialization(),employee,fileName_txt}};
    }

   /* @Test(dataProvider = "TXTserializationEmployeeProvider")
    public void TXTserializationTest(EmployeeTXTserialization txtSerial, Employee employee, String file_in) throws IOException {
        txtSerial.serializingObj(employee,new FileWriter(file_in));
    }*/

    @Test(dataProvider = "TXTserializationEmployeeProvider")
    public void TXTdeserializationTest(EmployeeTXTserialization txtSerial, Employee employee, String file_out) throws IOException, JAXBException {
        Assert.assertEquals(txtSerial.deserializingObj(new FileReader(file_out)), employee);
    }


}
