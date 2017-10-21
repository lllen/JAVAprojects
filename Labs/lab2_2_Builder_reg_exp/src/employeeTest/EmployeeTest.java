package employeeTest;
import employee.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.LocalDate;

public class EmployeeTest {
    @DataProvider
    Object[][] WorkingExperienceTimeProvider(){
        Employee ob1 = new Employee.EmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2015,05,05))
                .build();
        Employee ob2=new  Employee.EmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2017,05,26))
                .build();
        Employee ob3=new  Employee.EmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2018,05,26))
                .build();
        Employee ob4=new  Employee.EmployeeBuilder()
                .setFirstDayAtWork(LocalDate.now())
                .build();

        return new Object[][]{{ob1.getWorkingExperience(),2},{ob2.getWorkingExperience(),0},{ob3.getWorkingExperience(),0},{ob4.getWorkingExperience(),0}};
    }
    @Test(dataProvider = "WorkingExperienceTimeProvider")
    public void testCalculateWorkingExperience(long workingExperience,long expectedWorkingExperience) {
        Assert.assertEquals(workingExperience,expectedWorkingExperience);
    }

    @DataProvider
    Object[][] AgeProvider(){
        Employee ob1=new Employee.EmployeeBuilder()
                .setDateOfBirth(LocalDate.of(1976,03,8))
                .build();
        Employee ob2=new Employee.EmployeeBuilder()
                .setDateOfBirth(LocalDate.now())
                .build();
        Employee ob3=new Employee.EmployeeBuilder()
                .setDateOfBirth(LocalDate.of(2018,03,8))
                .build();

        return new Object[][]{{ob1.getAge(),41},{ob2.getAge(),0},{ob3.getAge(),0}};
    }

    @Test(dataProvider = "AgeProvider")
    public void testCalculateAge(long dateOfBirth, long expectedDateOfBirth){
        Assert.assertEquals(dateOfBirth,expectedDateOfBirth);
    }

    @DataProvider
    Object[][] nameRegExpProvider(){
        String name1="dima";
        String name2="Dima";
        String name3="DimaDimaDimaDifergrfg";
        String name4="Lisa lisa";

        Employee empl1=new Employee.EmployeeBuilder()
                .setFirstName(name1)
                .build();
        Employee empl2=new Employee.EmployeeBuilder()
                .setFirstName(name2)
                .build();
        Employee empl3=new Employee.EmployeeBuilder()
                .setFirstName(name3)
                .build();
        Employee empl4=new Employee.EmployeeBuilder()
                .setFirstName(name4)
                .build();

        return new Object[][]{{},{},{},{}};
    }
    @Test(dataProvider = "nameRegExpProvider")
    public void nameRegExpTest(String name,boolean flag){
        Assert.assertEquals();
    }
}