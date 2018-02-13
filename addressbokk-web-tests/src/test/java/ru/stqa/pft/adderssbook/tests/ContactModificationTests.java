package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Yuri", "Sidorin111", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda"));
    app.getNavigationHelper().submitModification();
  }
}
