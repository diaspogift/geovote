package com.geovote.domain.context.helper;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by elberto on 3/13/17.
 */

@Embeddable
public class ThemeInfo implements Serializable {

    private String themeCode;
    private String themeTitle;

    public ThemeInfo() {
    }

    public ThemeInfo(String themeCode, String themeTitle) {
        this.themeCode = themeCode;
        this.themeTitle = themeTitle;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

}
