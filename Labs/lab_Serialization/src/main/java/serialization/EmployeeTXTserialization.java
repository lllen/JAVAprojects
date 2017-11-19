package serialization;

import employee.Employee;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeTXTserialization {

    public static void main(String [] args) throws IOException {
        EmployeeTXTserialization o=new EmployeeTXTserialization();
        Employee employee=Employee.newEmployeeBuilder()
                .setFirstName("Miley")
                .setSecondName("Cyrus")
                .setEmailAddress("mileycRay@gmail.com")
                .setPhoneNumber("+380992776367")
                .setWorkingPosition("office admin")
                .setSalary(9850)
                .setFirstDayAtWork(LocalDate.of(2013,10,10))
                .setDateOfBirth(LocalDate.of(1991,9,21))
                .build();
        Writer file=new FileWriter("employee.txt");
        o.serializingObj(employee,file);

    }


    public void serializingObj(Employee employee,Writer file){
        try{
            file.write(employee.toString());
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

    public Employee deserializationObj(Input input){
        Scanner scanner = new Scanner((ReadableByteChannel) input, "UTF-8");
        String inputText = scanner.useDelimiter("\\A").next();
        scanner.close();
        return new Employee().fromString(inputText).build();
    }


}
