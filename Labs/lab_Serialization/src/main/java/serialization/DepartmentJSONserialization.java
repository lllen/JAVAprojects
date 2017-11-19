package serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import department.Department;
import employee.Employee;

import javax.lang.model.type.NullType;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;

public class DepartmentJSONserialization implements Serializing<Department>{

    @Override
    public void serializingObj(Department obj, Writer file) throws IOException{
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(file,obj);
    }

    @Override
    public Department deserializingObj(Reader file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(file, Department.class);
    }
}
