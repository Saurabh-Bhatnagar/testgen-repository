import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;


@SuppressWarnings("restriction")
@XmlRootElement
public class Testing {

    @XmlAttribute
    private boolean canRead;

    @XmlAttribute
    private boolean canWrite;

    @XmlValue
    private String value;
    
    @XmlElement(required=true)
    private String bar;
    
    @XmlElement(name="testig")
    private Test teti;
    
    public static void main(String[] args) throws JsonMappingException {
    	ObjectMapper jsonMapper = new ObjectMapper();
        AnnotationIntrospector introspector = new AnnotationIntrospector.Pair(new JaxbAnnotationIntrospector(), 
        		new JacksonAnnotationIntrospector());
        jsonMapper.setAnnotationIntrospector(introspector);
        JsonSchema schema = jsonMapper.generateJsonSchema(Testing.class);
        if(Testing.class.getAnnotation(XmlRootElement.class)!=null
        		&& !Testing.class.getAnnotation(XmlRootElement.class).name().equals("##default"))
        	schema.getSchemaNode().put("name", Testing.class.getAnnotation(XmlRootElement.class).name());
        else if(Testing.class.getAnnotation(XmlType.class)!=null
        		&& !Testing.class.getAnnotation(XmlType.class).name().equals("##default"))
        	schema.getSchemaNode().put("name", Testing.class.getAnnotation(XmlType.class).name());
        else
        	schema.getSchemaNode().put("name", Testing.class.getSimpleName());
        String schemaJson = schema.toString();
    	System.out.println(schemaJson);
    }
}