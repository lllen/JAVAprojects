package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import employee.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


public class EmployeeXMLserialization implements Serializing<Employee>{

    public static void main(String [] args) throws IOException, JAXBException {
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

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Override
    public void serializingObj(Employee obj, File file) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(obj, file);
    }

    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @Override
    public Employee deserializingObj(File file) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employee employee = (Employee) jaxbUnmarshaller.unmarshal(file);
        return employee;
    }
}
