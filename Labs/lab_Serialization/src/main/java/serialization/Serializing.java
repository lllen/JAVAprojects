package serialization;


import java.io.*;

public interface Serializing<T> {

        void serializingObj(T obj, File file) throws IOException;

        T deserializingObj(File file)throws IOException;

    }

