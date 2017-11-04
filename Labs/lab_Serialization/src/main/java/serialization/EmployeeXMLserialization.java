package serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import employee.Employee;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class EmployeeXMLserialization implements Serializing<Employee>{

    public static void main(String [] args) throws IOException {
        Employee employee=Employee.newEmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Hogvart")
                .setWorkingPosition("administrator")
                .setSalary(8950)
                .setEmailAddress("amanda1w@mail.ua")
                .setDateOfBirth(LocalDate.of(1997,10,25))
                .setFirstDayAtWork(LocalDate.of(2013,12,1))
                .build();

        File file=new File("employee.xml");
        EmployeeXMLserialization o=new EmployeeXMLserialization();
        o.serializingObj(employee,file);
        Employee employee1=o.deserializingObj(file);
        System.out.println(employee1.getFirstName());
    }

    @Override
    public void serializingObj(Employee obj, File file) throws IOException {
        XmlMapper mapper= (XmlMapper) new XmlMapper().registerModule(new JavaTimeModule());
        mapper.writeValue(file,obj);
    }

    @Override
    public Employee deserializingObj(File file) throws IOException {
        XmlMapper mapper= (XmlMapper) new XmlMapper().registerModule(new JavaTimeModule());
        return mapper.readValue(file,Employee.class);
    }
}
