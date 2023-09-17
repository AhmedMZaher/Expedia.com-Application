package Model;

import java.util.Map;

public class FlightSpec {
    private Map properties;

    public FlightSpec(Map properties) {
        this.properties = properties;
    }

    public Object getProperty(String propertyName){
        return properties.get(propertyName);
    }
}
