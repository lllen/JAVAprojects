package employee;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee implements Comparable<Employee>{

    private final String firstName;
    private final String secondName;
    private final LocalDate dateOfBirth;
    private final LocalDate firstDayAtWork;
    private String phoneNumber;
    private String emailAddress;
    private String workingPosition;
    private double salary;


    Employee(EmployeeBuilder employeeBuilder) {

        this.firstName = employeeBuilder.getFirstName();
        this.secondName = employeeBuilder.getSecondName();
        this.workingPosition = employeeBuilder.getWorkingPosition();
        this.firstDayAtWork = employeeBuilder.getFirstDayAtWork();
        this.dateOfBirth=employeeBuilder.getDateOfBirth();
        this.phoneNumber=employeeBuilder.getPhoneNumber();
        this.emailAddress=employeeBuilder.getEmailAddress();
        this.salary=employeeBuilder.getSalary();
    }


    // BUILDER
    public static class EmployeeBuilder {

        private String firstName;
        private String secondName;
        private LocalDate dateOfBirth;
        private String workingPosition;
        private LocalDate firstDayAtWork;
        private String phoneNumber;
        private String emailAddress;
        private double salary;

        public EmployeeBuilder setSalary(double salary){
            this.salary=salary;
            return  this;
        }
        public EmployeeBuilder setFirstName(final String firstName) throws RuntimeException{
            if(checkFirstSecondName(firstName)){
                this.firstName = firstName;
                return this;
            }
            throw new RuntimeException("Incorrect first name !");
        }

        public EmployeeBuilder setSecondName(final String secondName) throws RuntimeException{
            if(checkFirstSecondName(secondName)) {
                this.secondName = secondName;
                return this;
            }

            throw new RuntimeException("Incorrect second name !");
        }

        public EmployeeBuilder setPhoneNumber(String phoneNumber)throws RuntimeException{
            if(checkPhoneNumber(phoneNumber)){
                this.phoneNumber=phoneNumber;
                return this;
            }
            throw new RuntimeException("Incorrect phone number !");
        }

        public EmployeeBuilder setEmailAddress(String emailAddress)throws RuntimeException{
            if(checkEmailAddress(emailAddress)){
                this.emailAddress=emailAddress;
                return this;
            }
            throw new RuntimeException("Incorrect e-mail address !");
        }

        public EmployeeBuilder setDateOfBirth(LocalDate dateOfBirth)throws RuntimeException{
            if(checkDateOfBirth(dateOfBirth)) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }
            throw new RuntimeException("Incorrect date of birth !");
        }

        public EmployeeBuilder setWorkingPosition(String workingPosition)throws RuntimeException{
            if(checkWorkingPosition(workingPosition)){
                this.workingPosition = workingPosition;
                return this;
            }
            throw new RuntimeException("Incorrect working position !");
        }

        public EmployeeBuilder setFirstDayAtWork(LocalDate firstDayAtWork)throws RuntimeException {
            if(checkFirstDayAtWork(firstDayAtWork)) {
                this.firstDayAtWork = firstDayAtWork;
                return this;
            }
            throw new RuntimeException("Incorrect first day at work !");
        }

        public double getSalary(){return salary;}

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

        public Employee build() {
            return new Employee(this);
        }


        // regular exp
        public boolean checkFirstSecondName(final String firstName){
            String namePattern="^[A-Z][a-z]{3,14}$";
            Pattern pattern = Pattern.compile(namePattern);  // [0-15] letters allowed
            Matcher matcher = pattern.matcher(firstName);
            if(matcher.matches())
                return true;
            return false;
        }

        public boolean checkPhoneNumber(String phoneNumber){
            String numberPattern="^\\+380[0-9]{9}$";
            Pattern pattern=Pattern.compile(numberPattern);
            Matcher matcher=pattern.matcher(phoneNumber);
            if(matcher.matches())
                return true;
            return false;
        }

        public boolean checkEmailAddress(String emailAddress){
            String emailPattern="^[a-z]{1}[a-z-0-9]{3,10}\\@[a-z]{1,6}mail\\.[a-z]{2,3}$";
            Pattern pattern=Pattern.compile(emailPattern);
            Matcher matcher=pattern.matcher(emailAddress);
            if(matcher.matches())
                return true;
            return false;
        }
        public boolean checkWorkingPosition(String workingPosition){
            String positionPattern="^[A-Z]{1}[a-z]{1,10}($|[A-z])";
            Pattern pattern=Pattern.compile(positionPattern);
            Matcher matcher=pattern.matcher(workingPosition);
            if(matcher.matches())
                return true;
            return false;
        }


        public boolean checkDateOfBirth(LocalDate DateOfBirth){
            if(ChronoUnit.DAYS.between(DateOfBirth,LocalDate.now())<0){
                return false;
            }
            return true;
        }
        public boolean checkFirstDayAtWork(LocalDate firstDayAtWork){
            if(ChronoUnit.DAYS.between(firstDayAtWork,LocalDate.now())<0){
                return false;
            }
            return true;
        }
    }

    // GET
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

    public double getSalary() {
        return salary;
    }

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

    public void setPhoneNumber (String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress=emailAddress;
    }

    public void setWorkingPosition(String workingPosition){
        this.workingPosition=workingPosition;
    }

    // OTHERS


    @Override
    public int compareTo(Employee employee) {
        return this.secondName.compareTo(employee.getSecondName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(secondName, employee.secondName) &&
                Objects.equals(dateOfBirth, employee.dateOfBirth) &&
                Objects.equals(firstDayAtWork, employee.firstDayAtWork) &&
                Objects.equals(phoneNumber, employee.phoneNumber) &&
                Objects.equals(emailAddress, employee.emailAddress) &&
                Objects.equals(workingPosition, employee.workingPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, dateOfBirth, firstDayAtWork, phoneNumber, emailAddress, workingPosition, salary);
    }

}