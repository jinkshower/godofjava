package second.lang.map;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesSample {

    public static void main(String[] args) {
        PropertiesSample sample = new PropertiesSample();
        sample.checkProperties();
    }

    private void checkProperties() {
        Properties properties = System.getProperties();
        Set<Entry<Object, Object>> set = properties.entrySet();
        for (Entry<Object, Object> entry : set) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println(key + "=" + value);
        }
    }
}
