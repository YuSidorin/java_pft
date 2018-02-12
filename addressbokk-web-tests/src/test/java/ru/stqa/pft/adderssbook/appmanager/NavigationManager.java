package ru.stqa.pft.adderssbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationManager {
  FirefoxDriver wd;

  public NavigationManager(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroup() {
    wd.findElement(By.linkText("groups")).click();
  }
}
