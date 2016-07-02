import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;


@SuppressWarnings("restriction")
@XmlRootElement
public class Test {

    @XmlAttribute
    private boolean canRead;

    @XmlAttribute
    private boolean canWrite;

    @XmlValue
    private String value;
    
    @XmlElement(required=true)
    private String bar;
    
    @XmlElement(name="lis")
    private List<String> lis;
    
    @XmlElement(name="mss")
    private Map<String, String> mss;
}
