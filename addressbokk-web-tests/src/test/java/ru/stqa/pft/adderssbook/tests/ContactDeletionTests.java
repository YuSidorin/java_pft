package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test
  public void deleteContact() {
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Yuri", "Sidorin", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().initContactModification(before.size() - 1);
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
  }
}
