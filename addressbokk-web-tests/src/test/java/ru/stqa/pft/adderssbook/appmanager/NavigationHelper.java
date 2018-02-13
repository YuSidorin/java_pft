package ru.stqa.pft.adderssbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);

  }
  public void gotoGroup() {
    click(By.linkText("groups"));
  }
  public void submitModification() {
    click(By.name("update"));
  }
}
