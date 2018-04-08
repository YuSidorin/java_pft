package ru.stqa.pft.adderssbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.adderssbook.model.ContactData;
import ru.stqa.pft.adderssbook.model.Contacts;
import ru.stqa.pft.adderssbook.model.GroupData;

import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
//    attach(By.name("photo"), contactData.getPhoto());
//    type(By.name("home"), contactData.getHomePhone());
//    type(By.name("mobile"), contactData.getMobilePhone());
//    type(By.name("work"), contactData.getWorkPhone());
//    type(By.name("email"), contactData.getEmail());
    type(By.name("address"), contactData.getAddress());
    if (creation) {
//      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void submitContact() {
    click(By.name("submit"));
  }

  public void initContactModificationById(int id)  {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void modify(ContactData contact) {
    initContactModificationById(contact.getId());
    fillContactForm((contact), false);
    submitModification();
    contactCache = null;
    goToHomePage();
  }

  public void submitModification() {
    click(By.name("update"));
  }

  public void deleteContact(int id) {
    wd.findElement(By.xpath("//a[.='edit.php?id=" + id + "']")).click();
  }

  public void deleteSelectedContact() {
    click(By.cssSelector("input[value='Delete']"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    wd.switchTo().alert().accept();
    contactCache = null;
    goToHomePage();
  }

  public void remove(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    goToContactFromGroupPage(group.getId());
    selectContactById(contact.getId());
    removeContactFromGroup();
    goToHomePage();
    contactCache = null;
  }
  public void goToContactFromGroupPage(int group) {
    wd.findElement(By.cssSelector(String.format("a[href='./index.php?group=%s']", group))).click();
  }
  public void removeContactFromGroup() {
    click(By.cssSelector("input[name='remove']"));
  }
  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contactData, boolean creation) {
    initContactCreation();
    fillContactForm(contactData, creation);
    submitContact();
    contactCache = null;
  }
  public void add(ContactData contact) {
    selectContactById(contact.getId());
    addContactInGroup();
    goToHomePage();
    contactCache = null;
  }

  private void addContactInGroup() { click(By.cssSelector("input[name='add']")); }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allphones = cells.get(5).getText();
      String allemails = cells.get(4).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allphones).withAllemails(allemails).withAddress(address));
    }
    return new Contacts(contactCache);
  }
}