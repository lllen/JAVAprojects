package employeeTest;
import employee.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.LocalDate;

public class EmployeeTest {
    @DataProvider
    Object[][] WorkingExperienceTimeProvider(){
        Employee ob = new Employee.EmployeeBuilder().
                setFirstDayAtWork(LocalDate.of(2015,05,05))
                .build();

        return new Object[][]{{ob.getWorkingExperience(),2}};
    }
    @Test(dataProvider = "WorkingExperienceTimeProvider")
    public void testCalculateWorkingExperience(long workingExperience,long expectedWorkingExperience) {
        Assert.assertEquals(workingExperience,expectedWorkingExperience);
    }

    @DataProvider
    Object[][] AgeProvider(){
        Employee ob=new Employee.EmployeeBuilder()
                .setDateOfBirth(LocalDate.of(1976,03,8))
                .build();
        return new Object[][]{{ob.getAge(),41}};
    }

    @Test(dataProvider = "AgeProvider")
    public void testCalculateAge(long dateOfBirth, long expectedDateOfBirth){
        Assert.assertEquals(dateOfBirth,expectedDateOfBirth);
    }

}