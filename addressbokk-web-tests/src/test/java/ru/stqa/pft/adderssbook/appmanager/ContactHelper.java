package ru.stqa.pft.adderssbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.adderssbook.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }
}