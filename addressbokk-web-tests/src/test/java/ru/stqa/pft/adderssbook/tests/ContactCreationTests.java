package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNewContact() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Yuri", "Sidorin", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda", "test1"));
    app.getContactHelper().submitContact();
  }

}