package configreader;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    public static final PropertiesReader properties = ConfigFactory.create(PropertiesReader.class, System.getProperties());

}
