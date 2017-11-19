package serialization;

import com.sun.org.apache.regexp.internal.RE;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Serializing<T> {

        void serializingObj(T obj, Writer file) throws IOException,JAXBException;

        T deserializingObj(Reader file) throws IOException,JAXBException;

    }

