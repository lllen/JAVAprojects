package temp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.org.apache.regexp.internal.RE;
import employee.Employee;
import serialization.Serializing;
import temp.Person;

import java.io.*;
import java.time.LocalDate;


public class PersonSerialization implements Serializing<Person> {

   /* public static void main(String [] args) throws IOException {

        File file=new File("employee.json");
        PersonSerialization o=new PersonSerialization();

        Person person=new Person("Aleks",0);
        o.serializingObj(person,file);
        Person person1=o.deserializingObj(file);
        System.out.println(person1.getName() + " " + person1.getAge());
    }*/

    @Override
    public void serializingObj(Person obj, File file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        objectMapper.writeValue(file,obj);
    }

    @Override
    public Person deserializingObj(File file) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper().registerModule(new JavaTimeModule());
        return objectMapper.readValue(file,Person.class);
    }
}
