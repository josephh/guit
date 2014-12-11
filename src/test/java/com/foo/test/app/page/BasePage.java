package com.foo.test.app.page;

import java.util.Properties;

import com.foo.test.functional.UiDriver;
import com.foo.test.functional.UiOperation;
import com.foo.test.functional.Verify;
import com.foo.test.functional.WebDriverProvider;
import com.foo.test.app.GuiIntegrationTest;

/**
 * Abstract class to provide shared behaviour and utilities that 'represent' a GUi web page. Subclasses should only
 * implement this page where they represent a known, addressable web page. Subclasses must provide any required
 * properties for use in the test.
 * @author josephjobbings
 */
public abstract class BasePage {

    protected UiOperation browser;
    protected Verify verification;
    protected Properties props;

    private enum HTTPError {
        ERROR_404("Page Not Found"), INTERNAL_ERROR("Internal Server Error"), ERROR_500("500 Error");

        String errorLabel;

        HTTPError(String errorLabel) {
            this.errorLabel = errorLabel;
        }

        String getErrorLabel() {
            return errorLabel;
        }
    }

    public BasePage() {
        final UiDriver uiDriver = WebDriverProvider.instance().getWebDriver();
        browser = new UiOperation(uiDriver);
        verification = new Verify(uiDriver, GuiIntegrationTest.getCollector());
        verifyNoHTTPError();
    }

    private void verifyNoHTTPError() {
        for(HTTPError httpError : HTTPError.values()) {
            verification.failIfMessageExists(httpError.getErrorLabel());
        }
    }

    protected abstract String testPropertiesFileName();

}
