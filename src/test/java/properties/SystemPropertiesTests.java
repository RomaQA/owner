package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    @Tag("hello")
    void simpleProperty5Test(){
        System.out.println("Hello "+System.getProperty("user_name", "unknown"));
    }
}
