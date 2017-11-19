package serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.org.apache.regexp.internal.RE;
import com.thoughtworks.xstream.XStream;
import employee.Employee;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
//import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.io.*;
import java.nio.channels.WritableByteChannel;
import java.time.LocalDate;
import com.thoughtworks.xstream.XStream;

public class EmployeeXMLserialization implements Serializing<Employee>{

 /*   public static void main(String [] args) throws IOException, JAXBException {
        Employee employee=Employee.newEmployeeBuilder()
                .setFirstName("Amanda")
                .setSecondName("Hogvart")
                .setWorkingPosition("administrator")
                .setSalary(8950)
                .setEmailAddress("amanda1w@mail.ua")
                .setDateOfBirth(LocalDate.of(1997,10,25))
                .setFirstDayAtWork(LocalDate.of(2013,12,1))
                .build();

        Writer file_out=new PrintWriter("employee.xml");
        Reader file_in=new FileReader("employee.xml");
        EmployeeXMLserialization o=new EmployeeXMLserialization();
        o.serializingObj(employee,file_out);
        Employee employee1=o.deserializingObj(file_in);
        System.out.println(employee1.toString());
    }
*/
    @Override
    public void serializingObj(Employee employee, Writer file) throws IOException {
        XStream xs = new XStream();
        xs.toXML(employee,file);
    }


    @Override
    public Employee deserializingObj(Reader file) throws IOException, JAXBException {
        XStream xs = new XStream();
        Employee employee = new Employee();
        xs.fromXML(file, employee);
        return employee;
    }




    /*@Override
    public void serializingObj(Employee obj, File file) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.marshal(obj, file);
    }


    @Override
    public Employee deserializingObj(File file) throws IOException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Employee employee = (Employee) jaxbUnmarshaller.unmarshal(file);
        return employee;
    }*/
}
