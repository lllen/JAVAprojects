package serialization;

import com.sun.org.apache.regexp.internal.RE;
import employee.Employee;
import jdk.internal.util.xml.impl.Input;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeTXTserialization implements Serializing<Employee>{

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
        employee.fromString(text);
        return employee;
    }


}
