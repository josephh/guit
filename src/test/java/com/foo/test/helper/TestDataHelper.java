package com.foo.test.helper;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.foo.test.entity.UserLogonDetails;
import com.thoughtworks.xstream.XStream;

public class TestDataHelper {

    private static final String userLogonXMLFile = "data/UserLogonDetails.xml";
    private UserLogonDetails userLogonDetails;
    private XStream xStream;

    public TestDataHelper() {
        xStream = new XStream();
        xStream.processAnnotations(UserLogonDetails.class);
        // xStream.processAnnotations(OtherClass.class);
        // xStream.processAnnotations(OtherClass2.class); ...etc
    }

    public UserLogonDetails getUserLogonDetails(boolean reload) {
        if(userLogonDetails == null || reload) {
            userLogonDetails = (UserLogonDetails) xStream.fromXML(readFileCharacters(userLogonXMLFile));
        }
        return userLogonDetails;
    }

    private String readFileCharacters(String fileName) {
        try {
            return IOUtils.toString(TestDataHelper.class.getClassLoader().getResourceAsStream(fileName));
        } catch(IOException e) {
            fail("Error loading Test data from : " + fileName);
        }
        return StringUtils.EMPTY;
    }
}
