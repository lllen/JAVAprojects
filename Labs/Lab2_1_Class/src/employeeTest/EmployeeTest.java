package employeeTest;
import employee.Employee;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class EmployeeTest {
    @DataProvider
    Object[][] WorkingExperienceTimeProvider(){
        Employee ob = new Employee();
                ob.setFirstDayAtWork(LocalDate.of(2015,05,05));
        return new Object[][]{{ob.getWorkingExperience(),2}};
    }
    @Test(dataProvider = "WorkingExperienceTimeProvider")
    public void testCalculateWorkingExperience(long workingExperience,long expectedWorkingExperience) {
        Assert.assertEquals(workingExperience,expectedWorkingExperience);
    }

    @DataProvider
    Object[][] AgeProvider(){
        Employee ob=new Employee();
                ob.setDateOfBirth(LocalDate.of(1976,03,8));
        return new Object[][]{{ob.getAge(),41}};
    }

    @Test(dataProvider = "AgeProvider")
    public void testCalculateAge(long dateOfBirth, long expectedDateOfBirth){
        Assert.assertEquals(dateOfBirth,expectedDateOfBirth);
    }

}