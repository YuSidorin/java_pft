package ru.stqa.pft.adderssbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adderssbook.appmanager.ApplicationManager;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

import static java.lang.System.getProperty;

public class TestBase {
  Logger logger = LoggerFactory.getLogger(TestBase.class);
  protected static final ApplicationManager app = new ApplicationManager(getProperty("browser", BrowserType.CHROME));



  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTeststart(Method m,  Object[] p) {
    logger.info("Start test" + m.getName()+ " with parameters" + Arrays.asList(p));
  }

  @AfterSuite (alwaysRun = true)
  public void logTeststop(Method m, Object[] p) {
    logger.info("Stop test" + m.getName() + " with parameters" + Arrays.asList(p));
  }
}