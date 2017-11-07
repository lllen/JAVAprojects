package serialization;



import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;


public class LocalDateAdapter
        extends XmlAdapter<String, LocalDate>{

    public LocalDateAdapter() {
    }

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse (v) ;
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        if (v != null) {
            return v.toString();
        } else {
            return null;
        }
    }

}
