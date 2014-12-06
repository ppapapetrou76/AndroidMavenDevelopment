
package com.packt.androidMaven.tests;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelendroidTest {

    private static SelendroidLauncher selendroidServer = null;
    private static WebDriver driver = null;

    @BeforeClass
    public static void startSelendroidServer() throws Exception {
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
        SelendroidConfiguration config = new SelendroidConfiguration();
        config.addSupportedApp("src/main/resources/AndroidTier.apk");
        config.setForceReinstall(true);
        
        selendroidServer = new SelendroidLauncher(config);
        selendroidServer.launchSelendroid();
        
        SelendroidCapabilities caps = new SelendroidCapabilities("com.packt.androidMaven:1.0-SNAPSHOT");
        driver = new SelendroidDriver(caps);
    }

    @AfterClass
    public static void stopSelendroidServer() {
        if (driver != null) {
            driver.quit();
        }
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }

    @Test
    public void testShouldBeAbleToEnterText() {
        WebElement button = driver.findElement(By.id("button1"));
        Assert.assertNotNull(button);
        Assert.assertEquals("View Author Name!", button.getText());
    }

}
