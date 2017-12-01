package serialization;

import com.sun.org.apache.regexp.internal.RE;
import employee.Employee;
import jdk.internal.util.xml.impl.Input;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeTXTserialization implements Serializing<Employee>{

    String FIRST_NAME = "(firstName\\=\')([A-Z][a-z]{3,14}(|[\\-][A-Z][a-z]{1,14}))(\')";
    String SECOND_NAME = "(secondName\\=\')([A-Z][a-z]{3,14}(|[\\-][A-Z][a-z]{1,14}))(\')";
    String EMAIL_ADDRESS = "(emailAddress\\=\')([A-z]\\w{3,9}+@([a-z]{2,10})\\.(com|ru|ua))(\')";
    String PHONE_NUMBER = "(phoneNumber\\=\')(\\+380[0-9]{9})(\')";
    String WORKING_POSITION = "(workingPosition\\=\')([A-z]{2,15}(|\\s[A-z]{2,15})(|\\s[A-z]{2,15}))(\')";
    String SALARY = "(salary\\=\')([0-9]{4,}\\.[0-9]{1})(\')(,|\\]\'|)";
    String DATE_OF_BIRTH = "(dateOfBirth\\=\')([0-9]{4}[\\-][0-9]{2}[\\-][0-9]{2})(\')";
    String FIRST_DAY_AT_WORK = "(firstDayAtWork\\=\')([0-9]{4}[\\-][0-9]{2}[\\-][0-9]{2})(\')";


    public Employee fromString(String[] str, Employee employee) {

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
                employee.setFirstName(  matcher.group(2));
            }

            matcher = pattern_salary.matcher(str[i]);
            if (matcher.matches()) {
               employee.setSalary(Double.parseDouble(matcher.group(2)));

            }

            matcher = pattern_secondname.matcher(str[i]);
            if (matcher.matches()) {
                employee.setSecondName( matcher.group(2));
            }
            matcher = pattern_dataOfBirth.matcher(str[i]);
            if (matcher.matches()) {
                employee.setDateOfBirth( LocalDate.parse(matcher.group(2)));
            }
            matcher = pattern_firstDayAtWork.matcher(str[i]);
            if (matcher.matches()) {
                employee.setFirstDayAtWork( LocalDate.parse(matcher.group(2)));
            }
            matcher = pattern_pnoneNumber.matcher(str[i]);
            if (matcher.matches()) {
                employee.setPhoneNumber( matcher.group(2));
            }
            matcher = pattern_emailAddress.matcher(str[i]);
            if (matcher.matches()) {
                employee.setEmailAddress( matcher.group(2));
            }
            matcher = pattern_workingPosition.matcher(str[i]);
            if (matcher.matches()) {
                employee.setWorkingPosition(matcher.group(2));
            }
        }
        return  employee;
    }

    @Override
    public void serializingObj(Employee employee,Writer file){
        try{
            file.write(employee.formString());
            file.flush();
            file.close();
        }catch (FileNotFoundException e) {
           System.out.println("File not found");
           System.exit(1);
        } catch (IOException e) {
            System.out.println("Input error");
            System.exit(2);
        }

    }

    @Override
    public Employee deserializingObj(Reader file) throws IOException, JAXBException {
        BufferedReader bf = new BufferedReader(file);
        String [] text = new String[8];

        for(int i=0;i<text.length;i++) {
            text[i] = bf.readLine();
        }
        Employee employee=new Employee();
        employee=fromString(text,employee);
        return employee;
    }


}
