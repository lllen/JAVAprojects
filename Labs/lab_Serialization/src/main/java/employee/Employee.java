package employee;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@XmlRootElement
public class Employee implements Comparable<Employee>,Serializable {

    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private LocalDate firstDayAtWork;
    private String phoneNumber;
    private String emailAddress;
    private String workingPosition;
    private double salary;

    private static final String NAME_PATTERN = "^[A-Z][a-z]{3,14}(|[\\-][A-Z][a-z]{1,14})$"; // double name allowed with separator \\-
    private static final String PHONE_NUMBER_PATTERN = "^\\+380[0-9]{9}$";
    private static final String EMAIL_ADDRESS_PATTERN = "^[A-z]\\w{3,9}+@([a-z]{2,10})\\.(com|ru|ua)$";
    private static final String WORKINGPOSITION_PATTERN = "^[A-z]{2,15}($|\\s[A-z]{2,15})($|\\s[A-z]{2,15}$)";


    public static EmployeeBuilder newEmployeeBuilder() {
        return new Employee().new EmployeeBuilder();
    }

    // BUILDER (inner class)
    public class EmployeeBuilder {

        public EmployeeBuilder setSalary(double salary) throws RuntimeException {
            if (salary >= 5000) {
                Employee.this.salary = salary;
                return this;
            }
            throw new RuntimeException("Incorrect salary, must be bigger or equal to 5000 !");
        }

        public EmployeeBuilder setFirstName(final String firstName) throws RuntimeException {
            if (checkFirstSecondName(firstName)) {
                Employee.this.firstName = firstName;
                return this;
            }
            throw new RuntimeException("Incorrect first name !");
        }

        public EmployeeBuilder setSecondName(final String secondName) throws RuntimeException {
            if (checkFirstSecondName(secondName)) {
                Employee.this.secondName = secondName;
                return this;
            }

            throw new RuntimeException("Incorrect second name !");
        }

        public EmployeeBuilder setPhoneNumber(String phoneNumber) throws RuntimeException {
            if (checkPhoneNumber(phoneNumber)) {
                Employee.this.phoneNumber = phoneNumber;
                return this;
            }
            throw new RuntimeException("Incorrect phone number !");
        }

        public EmployeeBuilder setEmailAddress(String emailAddress) throws RuntimeException {
            if (checkEmailAddress(emailAddress)) {
                Employee.this.emailAddress = emailAddress;
                return this;
            }
            throw new RuntimeException("Incorrect e-mail address !");
        }

        public EmployeeBuilder setDateOfBirth(LocalDate dateOfBirth) {
            Employee.this.dateOfBirth = dateOfBirth;
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
            return Employee.this;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonIgnore
    public long getWorkingExperience() {
        return ChronoUnit.YEARS.between(this.firstDayAtWork, LocalDate.now());
    }

    @JsonIgnore
    public long getAge() {
        return ChronoUnit.YEARS.between(this.dateOfBirth, LocalDate.now());
    }

    // SET


    @XmlElement
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @XmlElement
    public void setPhoneNumber(String phoneNumber) throws RuntimeException {
        if (checkPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else
            throw new RuntimeException("Incorrect phone number !");
    }

    @XmlElement
    public void setEmailAddress(String emailAddress) throws RuntimeException {
        if (checkEmailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        } else
            throw new RuntimeException("Incorrect e-mail address !");
    }

    @XmlElement
    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;

    }


    public void setFirstDayAtWork(LocalDate firstDayAtWork) {
        this.firstDayAtWork = firstDayAtWork;
    }


    // OTHERS
    public boolean checkFirstSecondName(final String firstName) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        if (matcher.matches())
            return true;
        return false;
    }


    public boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches())
            return true;
        return false;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean checkEmailAddress(String emailAddress) {
        Pattern pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(emailAddress);
        if (matcher.matches())
            return true;
        return false;
    }

    public static String getNamePattern() {
        return NAME_PATTERN;
    }

    public static String getEmailAddressPattern() {
        return EMAIL_ADDRESS_PATTERN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
        return Objects.hash(firstName, secondName,
                dateOfBirth, firstDayAtWork,
                phoneNumber, emailAddress,
                workingPosition, salary);
    }

    @Override
    public int compareTo(Employee employee) {
        return this.secondName.compareTo(employee.getSecondName());
    }


    @Override
    public String toString() {
        return
                "\nfirstName='" + firstName + "'\n" +
                        "secondName='" + secondName + "'\n" +
                        "dateOfBirth='" + dateOfBirth + "'\n" +
                        "firstDayAtWork='" + firstDayAtWork + "'\n" +
                        "phoneNumber='" + phoneNumber + "'\n" +
                        "emailAddress='" + emailAddress + "'\n" +
                        "workingPosition='" + workingPosition + "'\n" +
                        "salary='" + salary + "'";
    }

    public String formString() {
        return
                "firstName='" + firstName + "'\n" +
                        "secondName='" + secondName + "'\n" +
                        "dateOfBirth='" + dateOfBirth + "'\n" +
                        "firstDayAtWork='" + firstDayAtWork + "'\n" +
                        "phoneNumber='" + phoneNumber + "'\n" +
                        "emailAddress='" + emailAddress + "'\n" +
                        "workingPosition='" + workingPosition + "'\n" +
                        "salary='" + salary + "'";
    }

    /*public void fromString(String[] str) {
        String FIRST_NAME = "(firstName\\=\')([A-Z][a-z]{3,14}(|[\\-][A-Z][a-z]{1,14}))(\')";
        String SECOND_NAME = "(secondName\\=\')([A-Z][a-z]{3,14}(|[\\-][A-Z][a-z]{1,14}))(\')";
        String EMAIL_ADDRESS = "(emailAddress\\=\')([A-z]\\w{3,9}+@([a-z]{2,10})\\.(com|ru|ua))(\')";
        String PHONE_NUMBER = "(phoneNumber\\=\')(\\+380[0-9]{9})(\')";
        String WORKING_POSITION = "(workingPosition\\=\')([A-z]{2,15}(|\\s[A-z]{2,15})(|\\s[A-z]{2,15}))(\')";
        String SALARY = "(salary\\=\')([0-9]{4,}\\.[0-9]{1})(\')(,|\\]\'|)";
        String DATE_OF_BIRTH = "(dateOfBirth\\=\')([0-9]{4}[\\-][0-9]{2}[\\-][0-9]{2})(\')";
        String FIRST_DAY_AT_WORK = "(firstDayAtWork\\=\')([0-9]{4}[\\-][0-9]{2}[\\-][0-9]{2})(\')";

        Pattern pattern_firstname = Pattern.compile(FIRST_NAME);
        Pattern pattern_secondname = Pattern.compile(SECOND_NAME);
        Pattern pattern_emailAddress = Pattern.compile(EMAIL_ADDRESS);
        Pattern pattern_pnoneNumber = Pattern.compile(PHONE_NUMBER);
        Pattern pattern_workingPosition = Pattern.compile(WORKING_POSITION);
        Pattern pattern_salary = Pattern.compile(SALARY);
        Pattern pattern_dataOfBirth = Pattern.compile(DATE_OF_BIRTH);
        Pattern pattern_firstDayAtWork = Pattern.compile(FIRST_DAY_AT_WORK);
        Matcher matcher;


        for (int i = 0; i < str.length; i++) {
            matcher = pattern_firstname.matcher(str[i]);
            if (matcher.matches()) {
                this.firstName = matcher.group(2);
            }

            matcher = pattern_salary.matcher(str[i]);
            if (matcher.matches()) {
                this.salary = Double.parseDouble(matcher.group(2));

            }

            matcher = pattern_secondname.matcher(str[i]);
            if (matcher.matches()) {
                this.secondName = matcher.group(2);
            }
            matcher = pattern_dataOfBirth.matcher(str[i]);
            if (matcher.matches()) {
                this.dateOfBirth = LocalDate.parse(matcher.group(2));
            }
            matcher = pattern_firstDayAtWork.matcher(str[i]);
            if (matcher.matches()) {
                this.firstDayAtWork = LocalDate.parse(matcher.group(2));
            }
            matcher = pattern_pnoneNumber.matcher(str[i]);
            if (matcher.matches()) {
                this.phoneNumber = matcher.group(2);
            }
            matcher = pattern_emailAddress.matcher(str[i]);
            if (matcher.matches()) {
                this.emailAddress = matcher.group(2);
            }
            matcher = pattern_workingPosition.matcher(str[i]);
            if (matcher.matches()) {
                this.workingPosition = matcher.group(2);
            }
        }*/
}


