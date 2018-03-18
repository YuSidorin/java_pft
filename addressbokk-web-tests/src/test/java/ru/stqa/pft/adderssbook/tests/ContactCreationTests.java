package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;
import ru.stqa.pft.adderssbook.model.Contacts;

import java.io.File;
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
    File photo = new File("src/test/resources/kot.jpg");
    ContactData contact = new ContactData().withFirstname("Yuri").withLastname("Sidorin").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("123@123.qw").withAddress("Qwe qwe").withGroup("test1").withPhoto(photo);
    app.contact().create(contact, true);
    app.contact().goToHomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
  }
