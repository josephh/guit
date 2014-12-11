package com.foo.test.action;

import com.foo.test.control.UiControl;
import com.foo.test.functional.UiDriver;

/**
 * @author josephjobbings
 */
public abstract class UiAction {

    protected UiControl element;
    protected UiDriver driver;

    public UiAction( UiDriver uiDriver, UiControl element) {
        this.driver = uiDriver;
    }

}
