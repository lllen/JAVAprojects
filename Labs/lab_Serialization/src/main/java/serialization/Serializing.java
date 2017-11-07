package serialization;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Serializing<T> {

        void serializingObj(T obj, File file) throws IOException, JAXBException;

        T deserializingObj(File file) throws IOException, JAXBException;

    }

