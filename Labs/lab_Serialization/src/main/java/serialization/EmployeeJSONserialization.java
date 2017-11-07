package serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.org.apache.regexp.internal.RE;
import employee.Employee;
import temp.Person;
import java.io.*;
import java.time.LocalDate;


public class EmployeeJSONserialization implements Serializing<Employee> {

    public static void main(String [] args) throws IOException {
      Employee employee=Employee.newEmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Hogvart")
                .setWorkingPosition("administrator")
                .setPhoneNumber("+380992776367")
                .setSalary(8950)
                .setEmailAddress("amanda1w@mail.ua")
                .setDateOfBirth(LocalDate.of(1997,10,25))
                .setFirstDayAtWork(LocalDate.of(2013,12,1))
                .build();

      EmployeeJSONserialization o=new EmployeeJSONserialization();
        File file=new File("employee.json");
        //o.serializingObj(employee,file);
        Employee employee1=o.deserializingObj(file);
        System.out.println(employee1.toString());

    }

    @Override
    public void serializingObj(Employee obj, File file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.writeValue(file,obj);
    }


    @Override
    public Employee deserializingObj(File file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        ///objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper.readValue(file,Employee.class);
    }
}
