package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yuri", "Sidorin", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().initContactModification(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Yuri", "Modificated", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda", null);
    app.getContactHelper().fillContactForm((contact), false);
    app.getNavigationHelper().submitModification();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
