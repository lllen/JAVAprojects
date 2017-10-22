package employee;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

    private  String firstName;
    private  String secondName;
    private  LocalDate dateOfBirth;
    private  LocalDate firstDayAtWork;
    private String phoneNumber;
    private String emailAddress;
    private String workingPosition;
    private double salary;
    private final String checkFirstSecondName="^[A-Z][a-z]{3,14}$";
    private final String checkPhoneNumber="^\\+380[0-9]{9}$";
    private final String checkEmailAddress="^[a-z]+\\w{1,10}+@(mail|[a-z]+|[a-z]+mail])\\.(com|ru|ua)$";


    public static EmployeeBuilder newEmployeeBuilder() {
        return new Employee().new EmployeeBuilder();
    }
    // BUILDER (inner class)
    public  class EmployeeBuilder {

        public EmployeeBuilder setSalary(double salary){
            Employee.this.salary=salary;
            return  this;
        }
        public EmployeeBuilder setFirstName(final String firstName) throws RuntimeException{
            if(checkFirstSecondName(firstName)){
                Employee.this.firstName = firstName;
                return this;
            }
            throw new RuntimeException("Incorrect first name !");
        }

        public EmployeeBuilder setSecondName(final String secondName) throws RuntimeException{
            if(checkFirstSecondName(secondName)) {
                Employee.this.secondName = secondName;
                return this;
            }

            throw new RuntimeException("Incorrect second name !");
        }

        public EmployeeBuilder setPhoneNumber(String phoneNumber)throws RuntimeException{
            if(checkPhoneNumber(phoneNumber)){
                Employee.this.phoneNumber=phoneNumber;
                return this;
            }
            throw new RuntimeException("Incorrect phone number !");
        }

        public EmployeeBuilder setEmailAddress(String emailAddress)throws RuntimeException{
            if(checkEmailAddress(emailAddress)){
                Employee.this.emailAddress=emailAddress;
                return this;
            }
            throw new RuntimeException("Incorrect e-mail address !");
        }

        public EmployeeBuilder setDateOfBirth(LocalDate dateOfBirth){
            Employee.this.dateOfBirth=dateOfBirth;
            return this;
        }

        public EmployeeBuilder setWorkingPosition(String workingPosition) {
            Employee.this.workingPosition = workingPosition;
            return this;
        }

        public EmployeeBuilder setFirstDayAtWork(LocalDate firstDayAtWork) {
            Employee.this.firstDayAtWork = firstDayAtWork;
            return this;
        }

        public Employee build() {
            return  Employee.this;
        }
    }

    // GET

    public double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public LocalDate getFirstDayAtWork() {
        return firstDayAtWork;
    }

    public LocalDate getDateOfBirth(){return dateOfBirth;}

    public String getEmailAddress(){return emailAddress;}

    public String getPhoneNumber(){return phoneNumber;}

    public long getWorkingExperience(){
        return ChronoUnit.YEARS.between(this.firstDayAtWork, LocalDate.now());
    }

    public long getAge(){
        return ChronoUnit.YEARS.between(this.dateOfBirth,LocalDate.now());
    }

    // SET

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPhoneNumber (String phoneNumber)throws RuntimeException{
        if(checkPhoneNumber(phoneNumber)){
            this.phoneNumber=phoneNumber;
        }
        throw new RuntimeException("Incorrect phone number !");
    }

    public void setEmailAddress(String emailAddress)throws RuntimeException{
        if(checkEmailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        }
        throw  new RuntimeException("Incorrect e-mail address !");
    }

    public void setWorkingPosition(String workingPosition){

            this.workingPosition = workingPosition;

    }

    public void setFirstDayAtWork(LocalDate firstDayAtWork) {
        this.firstDayAtWork = firstDayAtWork;
    }


    // OTHERS
    public boolean checkFirstSecondName(final String firstName){
        Pattern pattern = Pattern.compile(checkFirstSecondName);
        Matcher matcher = pattern.matcher(firstName);
        if(matcher.matches())
            return true;
        return false;
    }

    public boolean checkPhoneNumber(String phoneNumber){
        Pattern pattern=Pattern.compile(checkPhoneNumber);
        Matcher matcher=pattern.matcher(phoneNumber);
        if(matcher.matches())
            return true;
        return false;
    }

    public boolean checkEmailAddress(String emailAddress){
        Pattern pattern=Pattern.compile(checkEmailAddress);
        Matcher matcher=pattern.matcher(emailAddress);
        if(matcher.matches())
            return true;
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(workingPosition, employee.workingPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName,
                dateOfBirth, firstDayAtWork,
                phoneNumber, emailAddress,
                workingPosition, salary);
    }

}