package employee;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Employee {

    private  String firstName;
    private  String secondName;
    private  LocalDate dateOfBirth;
    private  LocalDate firstDayAtWork;
    private String phoneNumber;
    private String emailAddress;
    private String workingPosition;
    private double salary;

    // GETTERS

    public double getSalary() { return salary; }

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

    // SETTERS

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstDayAtWork(LocalDate firstDayAtWork) {
        this.firstDayAtWork = firstDayAtWork;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    // OTHER METHODS
    public long getWorkingExperience(){
        return ChronoUnit.YEARS.between(this.firstDayAtWork, LocalDate.now());
    }

    public long getAge(){
        return ChronoUnit.YEARS.between(this.dateOfBirth,LocalDate.now());
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