package employeeTest;
import employee.Employee;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.time.LocalDate;

public class EmployeeTest {
    @DataProvider
    Object[][] WorkingExperienceTimeProvider() {
        Employee ob1 = Employee.newEmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2015, 05, 05))
                .build();
        Employee ob2 = Employee.newEmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2017, 05, 26))
                .build();
        Employee ob3 = Employee.newEmployeeBuilder()
                .setFirstDayAtWork(LocalDate.of(2018, 05, 26))
                .build();
        Employee ob4 = Employee.newEmployeeBuilder()
                .setFirstDayAtWork(LocalDate.now())
                .build();

        return new Object[][]{{ob1.getWorkingExperience(), 2}, {ob2.getWorkingExperience(), 0}, {ob3.getWorkingExperience(), 0}, {ob4.getWorkingExperience(), 0}};
    }

    @Test(dataProvider = "WorkingExperienceTimeProvider")
    public void testCalculateWorkingExperience(long workingExperience, long expectedWorkingExperience) {
        Assert.assertEquals(workingExperience, expectedWorkingExperience);
    }

    @DataProvider
    Object[][] AgeProvider() {
        Employee ob1 = Employee.newEmployeeBuilder()
                .setDateOfBirth(LocalDate.of(1976, 03, 8))
                .build();
        Employee ob2 = Employee.newEmployeeBuilder()
                .setDateOfBirth(LocalDate.now())
                .build();
        Employee ob3 = Employee.newEmployeeBuilder()
                .setDateOfBirth(LocalDate.of(2018, 03, 8))
                .build();

        return new Object[][]{{ob1.getAge(), 41}, {ob2.getAge(), 0}, {ob3.getAge(), 0}};
    }

    @Test(dataProvider = "AgeProvider")
    public void testCalculateAge(long dateOfBirth, long expectedDateOfBirth) {
        Assert.assertEquals(dateOfBirth, expectedDateOfBirth);
    }

    @DataProvider
    Object[][] nameRegExpProvider() {
        String name1 = "dima";
        String name2 = "Dima";
        String name3 = "DimaDimaDimaDifergrfg";
        String name4 = "Lisa lisa";

        Employee empl1 = Employee.newEmployeeBuilder()
                .build();

        return new Object[][]{{empl1.checkFirstSecondName(name1), false}, {empl1.checkFirstSecondName(name2), true}, {empl1.checkFirstSecondName(name3), false}, {empl1.checkFirstSecondName(name4), false}};
    }

    @Test(dataProvider = "nameRegExpProvider")
    public void nameRegExpTest(boolean rezult, boolean expected_rezult) {
        Assert.assertEquals(rezult, expected_rezult);
    }

    @DataProvider
    Object[][] phoneNumberRegExpProvider() {
        String phoneNumber1 = "+38000"; // not enough numbers
        String phoneNumber2 = "+380992776367"; // everuthing is ok
        String phoneNumber3 = "+380 99 2 7 7 6 3 6 7"; // unwanted space
        String phoneNumber4 = "+38012345678910"; // too much numbers
        String phoneNumber5 = "+380/9927763"; // unwanted symbol

        Employee empl1 = Employee.newEmployeeBuilder()
                .build();

        return new Object[][]{{empl1.checkPhoneNumber(phoneNumber1), false}, {empl1.checkPhoneNumber(phoneNumber2), true}, {empl1.checkPhoneNumber(phoneNumber3), false}, {empl1.checkPhoneNumber(phoneNumber4), false}, {empl1.checkPhoneNumber(phoneNumber5), false}};
    }

    @Test(dataProvider = "phoneNumberRegExpProvider")
    public void phoneNumberRegExpTest(boolean rezult, boolean expected_rezult) {
        Assert.assertEquals(rezult, expected_rezult);
    }

    @DataProvider
    Object[][] emailAddressRegExpProvider() {
        String email1 = "olena@11.11";
        String email2 = "oLena@gmail.com";
        String email3 = "1olena@mail.com";
        String email4 = "olen1a11d3@ya.ua";
        String email5 = "olE1245i@mail.ru";
        String email6 = "olena@@mail.ru";
        String email7 = "olena@gmailcom";

        Employee empl = Employee.newEmployeeBuilder()
                .build();
        return new Object[][]{{empl.checkEmailAddress(email1), false}, {empl.checkEmailAddress(email2), true}, {empl.checkEmailAddress(email3), false},
                {empl.checkEmailAddress(email4), true}, {empl.checkEmailAddress(email5), true}, {empl.checkEmailAddress(email6), false},
        {empl.checkEmailAddress(email7), false}};
    }

    @Test(dataProvider = "emailAddressRegExpProvider")
    public void emailAddressRegExpTest(boolean rezult,boolean expected_rezult){
        Assert.assertEquals(rezult,expected_rezult);
    }


}
