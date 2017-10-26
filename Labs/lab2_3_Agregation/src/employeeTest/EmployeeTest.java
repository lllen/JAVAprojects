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

        return new Object[][]{{empl1.checkFirstSecondName(name1), false},
                {empl1.checkFirstSecondName(name2), true},
                {empl1.checkFirstSecondName(name3), false},
                {empl1.checkFirstSecondName(name4), false}};
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

        return new Object[][]{{empl1.checkPhoneNumber(phoneNumber1), false},
                {empl1.checkPhoneNumber(phoneNumber2), true},
                {empl1.checkPhoneNumber(phoneNumber3), false},
                {empl1.checkPhoneNumber(phoneNumber4), false},
                {empl1.checkPhoneNumber(phoneNumber5), false}};
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
        return new Object[][]{{empl.checkEmailAddress(email1), false},
                {empl.checkEmailAddress(email2), true},
                {empl.checkEmailAddress(email3), false},
                {empl.checkEmailAddress(email4), true},
                {empl.checkEmailAddress(email5), true},
                {empl.checkEmailAddress(email6), false},
                {empl.checkEmailAddress(email7), false}};
    }

    @Test(dataProvider = "emailAddressRegExpProvider")
    public void emailAddressRegExpTest(boolean rezult,boolean expected_rezult){
        Assert.assertEquals(rezult,expected_rezult);
    }

    /*
    * nameExceptionProvider provide info for firstName as well as
    * for secondName as requirements are the same for both field
    * */
    @DataProvider
    Object[][] nameExceptionProvider(){
        String name1="";
        String name2="Aaaaaaaaaaaaaaaaa"; //16 symbols in first word not allowed (only 15)
        String name3="aaaaaa"; // first symbol must be uppercase
        String name4="Ggjfkg12vf"; // numbers are not allowed
        String name5="Fhjk Hhjk"; // only one word is allowed
        String name6=" "; //
        String name7=" Alison";
        String name8="Alison ";
        String name9="Alison.";
        String name10="Alison-emmy"; // first letter of second word must be uppercase
        String name11="Ali"; // minimum symbols must be 4
        String name12="Alis-A";// minimum symbols of second word mast be 2
        String name13="Alison-Aliiiiiiiiiiiiii"; // //16 symbols in second word not allowed (only 15)

        return new Object[][]{{name1},{name2},{name3},{name4},
                {name5},{name6},{name7},{name8},{name9},{name10}
                ,{name11},{name12},{name13}};
    }


    @Test(dataProvider = "nameExceptionProvider", expectedExceptions = RuntimeException.class)
    public void firstNameExceptionTest(String name){
        Employee empl= Employee.newEmployeeBuilder()
                .setFirstName(name)
                .build();
    }

    @Test(dataProvider = "nameExceptionProvider", expectedExceptions = RuntimeException.class)
    public void secondNameExceptionTest(String name){
        Employee empl= Employee.newEmployeeBuilder()
                .setSecondName(name)
                .build();
    }

    @DataProvider
    Object[][]phoneNumberExceptionProvider(){
        /*
        * number starts from +380 and 9 numbers
        * */

        String number1="380992776367"; // must be symbol +
        String number2="+380 99 277 63 67"; // spaces are not allowed
        String number3="+377992776367"; // the code of country doesn`t match
        String number4="+3809927763678"; // too much numbers
        String number5="+380f99277636"; // not allowed symbol
        String number6="+38099277636"; // not enough numbers

        return new Object[][]{{number1},{number2},{number3},{number4},
                                {number5},{number6}};
    }
    @Test(dataProvider = "phoneNumberExceptionProvider", expectedExceptions = RuntimeException.class)
    public void phoneNumberExceptionTest(String phoneNumber){
        Employee empl1= Employee.newEmployeeBuilder()
                .setPhoneNumber(phoneNumber)
                .build();
    }

    @DataProvider
    Object[][]emailAddressExceptionProvider(){
        /*
        * First symbol must be a letter (upper or lowercase)
        * 9 symbols(numers, letters, numbers)(min=3, max=9) + @ + minimum=2 maximum=10 [a-z] symbols
        * + . + com or ru or ua
        * */
        String email1="1olena@mail.com";
        String email2=" olena1q2@yandex.ru";
        String email3="olena1q2@yandex.ru ";
        String email4="olena1q2@yandexru";
        String email5="olena1q2@3yandex.ru";
        String email6="OLENA1q2@yandex.r1u";
        String email7="aaa@yandex.ru";
        String email8="aaaaaaaaaaa@yandex.ru";
        String email9="olena1q2@yandexxxxxx.ru";
        String email10="olena1q2@y.ru";
        String email11="olen-a1q2@yandexmail.com";
        String email12="olena1Q2@yandexmail.rucom";

        return new Object[][]{{email1},{email2},{email3},{email4}
                            ,{email5},{email6},{email7},{email8}
                            ,{email9},{email10},{email11},{email12}};
    }

    @Test(dataProvider = "emailAddressExceptionProvider",expectedExceptions = RuntimeException.class)
    public void emailAddressExceptionTest(String email){
        Employee empl= Employee.newEmployeeBuilder()
                .setEmailAddress(email)
                .build();
    }



}
