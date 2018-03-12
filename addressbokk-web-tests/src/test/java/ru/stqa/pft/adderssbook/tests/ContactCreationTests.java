package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNewContact() {

    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda");
    app.contact().create(contact, true);
    app.contact().goToHomePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);

    Assert.assertEquals(before, after);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }
  }
