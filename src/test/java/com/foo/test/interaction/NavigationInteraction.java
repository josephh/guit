package com.foo.test.interaction;

import java.io.IOException;

import com.foo.test.app.page.HomePage;
import com.foo.test.entity.UserLogonDetails;

public class NavigationInteraction {

    public LogonInteraction navigateToLogonPage(UserLogonDetails userLogonDetails) throws IOException {
        HomePage homePage = new HomePage();
        homePage.navigateToLogonPage();
        return new LogonInteraction(userLogonDetails);
    }

}
