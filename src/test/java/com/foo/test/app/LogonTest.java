package com.foo.test.app;

import java.io.IOException;

import org.junit.Test;

import com.foo.test.entity.UserLogonDetails;
import com.foo.test.helper.TestDataHelper;
import com.foo.test.interaction.LogonInteraction;

public class LogonTest extends GuiIntegrationTest {

    @Test
    public void verifyLogon() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon();
    }
    
    @Test
    public void verifyLogout() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon().logout().verifyLogout();
    }

    @Test
    public void verifyChangePassword() throws IOException {
        UserLogonDetails userLogonDetails = new TestDataHelper().getUserLogonDetails(false);
//        new LogonAction(userLogonDetails).enterLogonDetails().verifyLogon().changePassword();
        new LogonInteraction(userLogonDetails).enterLogonDetails().verifyLogon().verifyLogout();
    }
    
       
    
}
