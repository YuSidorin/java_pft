package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda"), true);
    }
  }

  @Test
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    int index = before.size() - 1;
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
