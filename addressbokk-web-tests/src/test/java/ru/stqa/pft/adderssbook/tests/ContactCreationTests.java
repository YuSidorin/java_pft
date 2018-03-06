package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNewContact() {

    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda");
    app.contact().create(contact, true);
    app.contact().goToHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
  }
