package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;
import ru.stqa.pft.adderssbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testAddNewContact() {

    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Yuri").withLastname("Sidorin").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withGroup("test1");
    app.contact().create(contact, true);
    app.contact().goToHomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
  }
