package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.pages.BrokenLinkPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class BrokenLinkTest extends BaseClass {

    BrokenLinkPage linkPage;

    @BeforeMethod
    public void initialization() {
        setUp();
        linkPage = new BrokenLinkPage(driver);
    }

    @Test
    public void automateBrokenLinks() {
        linkPage.automatePage();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}
