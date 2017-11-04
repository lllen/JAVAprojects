package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import employee.Employee;
import java.io.*;


public class EmployeeJSONserialization implements Serializing<Employee>{

    @Override
    public void serializingObj(Employee obj, Writer file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.writeValue(file ,obj);
    }

    @Override
    public Employee deserializingObj(InputStream file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(file,Employee.class);
    }
}
