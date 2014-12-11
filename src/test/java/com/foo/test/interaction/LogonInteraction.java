package com.foo.test.interaction;

import java.io.IOException;

import com.foo.test.app.page.HomePage;
import com.foo.test.app.page.LogonPage;
import com.foo.test.entity.UserLogonDetails;

public class LogonInteraction {

    private UserLogonDetails userLogonDetails;

    public LogonInteraction(UserLogonDetails userLogonDetails) {
        this.userLogonDetails = userLogonDetails;
    }

    public LogonInteraction enterLogonDetails() throws IOException {
        LogonPage logonPage = new LogonPage(userLogonDetails);
        logonPage.open();
        logonPage.logon();
        return this;
    }

    public LogonInteraction verifyLogon() throws IOException {
        HomePage homePage = new HomePage();
        homePage.verifyLogon();
        return this;
    }

    public LogonInteraction verifyLogout() throws IOException {
        LogonPage logonPage = new LogonPage(userLogonDetails);
        logonPage.verifyLogout();
        return this;
    }

    public LogonInteraction changePassword() throws IOException {
        LogonPage logonPage = new LogonPage(userLogonDetails);
        logonPage.changePassword();
        return this;        
    }
    
    public LogonInteraction verifyPasswordChange() throws IOException {
        /**
         * TODO - logon again with new details  
         */
        
        LogonPage logonPage = new LogonPage(userLogonDetails);
        logonPage.logon();
        return this;        
    }

    public LogonInteraction logout() throws IOException {
        HomePage homePage = new HomePage();
        homePage.logout();
        return this;
    }

}
