package com.foo.test.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.foo.test.app.page.BasePage;

public class PropertyFileHelper {

    private String propertyFile;

    public PropertyFileHelper(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    public Properties load() throws IOException {
        InputStream propertyStream = PropertyFileHelper.class.getClassLoader().getResourceAsStream(propertyFile);
        Properties properties = new Properties();
        if(propertyStream != null) {
            properties.load(propertyStream);
        }

        return properties;
    }

    public static String propertiesFileName(Class<? extends BasePage> clazz) {
        return clazz.getSimpleName() + ".properties";
    }

}
