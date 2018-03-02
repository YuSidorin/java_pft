package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNewContact() {

    List<ContactData> before = app.getContactHelper().getContactsList();
    app.getContactHelper().createContact(new ContactData(id, "Yuri", "Sidorin", "YuSidorin", "test", "Cnet", "test", "890898098980", "asd", "asda", "test1"), true);
    app.getNavigationHelper().goToHomePage();
    List<ContactData> after = app.getContactHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
  }
