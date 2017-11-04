package SerializationTest;

import employee.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JSONserilalizationTest {
    @DataProvider
    Object[][]EmployeeSerilalizationProvider()  {
        Employee employee=Employee.newEmployeeBuilder()
                .setFirstName("Lage")
                .setSecondName("Dfrggr")
                .build();

        String fileName="employee.json";
       return new Object[][]{{employee,fileName},{employee,fileName}};
    }


    @Test(dataProvider = "EmployeeSerilalizationProvider")
    public void EmployeeSerilalizationTst(Employee employee,String fileName){


    }
}
