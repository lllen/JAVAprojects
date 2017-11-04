package serialization;


import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public interface Serializing<T> {

        void serializingObj(T obj, Writer file) throws IOException;

        T deserializingObj(InputStream file)throws IOException;

    }

