package serialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.org.apache.regexp.internal.RE;
import employee.Employee;
import java.io.*;
import java.time.LocalDate;


public class EmployeeJSONserialization implements Serializing<Employee> {

    @Override
    public void serializingObj(Employee obj, Writer file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(file,obj);
    }


    @Override
    public Employee deserializingObj(Reader file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(file,Employee.class);
    }
}
