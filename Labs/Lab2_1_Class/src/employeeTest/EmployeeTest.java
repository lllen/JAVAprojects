package employeeTest;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EmployeeTest {
    @DataProvider
    Object[][] WorkingExperienceTimeProvider(){
        Employee ob1 = new Employee();
                ob1.setFirstDayAtWork(LocalDate.of(2015,05,05));
        Employee ob2=new Employee();
                ob2.setFirstDayAtWork(LocalDate.of(2017,05,26));
        Employee ob3=new Employee();
                ob3.setFirstDayAtWork(LocalDate.of(2018,05,26));
        Employee ob4=new Employee();
                ob4.setFirstDayAtWork(LocalDate.now());

        return new Object[][]{{ob1.getWorkingExperience(),2},
                {ob2.getWorkingExperience(),0},
                {ob3.getWorkingExperience(),0},
                {ob4.getWorkingExperience(),0}};
    }
    @Test(dataProvider = "WorkingExperienceTimeProvider")
    public void testCalculateWorkingExperience(long workingExperience,long expectedWorkingExperience) {
        Assert.assertEquals(workingExperience,expectedWorkingExperience);
    }

    @DataProvider
    Object[][] AgeProvider(){
        Employee ob1=new Employee();
                ob1.setDateOfBirth(LocalDate.of(1976,03,8));
        Employee ob2=new Employee();
                ob2.setDateOfBirth(LocalDate.now());
        Employee ob3=new Employee();
                ob3.setDateOfBirth(LocalDate.of(2018,03,8));

        return new Object[][]{{ob1.getAge(),41},
                {ob2.getAge(),0},
                {ob3.getAge(),0}};
    }

    @Test(dataProvider = "AgeProvider")
    public void testCalculateAge(long dateOfBirth, long expectedDateOfBirth){
        Assert.assertEquals(dateOfBirth,expectedDateOfBirth);
    }

}











































