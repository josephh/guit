package com.foo.test.action;

import org.openqa.selenium.interactions.Actions;

import com.foo.test.control.UiControl;
import com.foo.test.functional.UiDriver;


public class HoverOverAction extends UiAction {

    public HoverOverAction(UiDriver uiDriver, UiControl control) {
        super(uiDriver, control);
    }

    public void hoverOver() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element.getElement());
    }
    
}
