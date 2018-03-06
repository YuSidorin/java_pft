package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
