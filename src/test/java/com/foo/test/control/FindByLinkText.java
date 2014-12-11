package com.foo.test.control;

import org.openqa.selenium.By;

/**
 * Concrete {@link Find} implementation - looking for hyperlink text.
 * @author josephjobbings
 */
public class FindByLinkText implements Find {

    private String linkText;

    public FindByLinkText(String linkText) {
        this.linkText = linkText;
    }

	public By by() {
		return By.linkText(linkText);
	}
}
