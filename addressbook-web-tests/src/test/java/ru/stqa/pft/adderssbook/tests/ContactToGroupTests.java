package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;
import ru.stqa.pft.adderssbook.model.Contacts;
import ru.stqa.pft.adderssbook.model.GroupData;
import ru.stqa.pft.adderssbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroupTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.db().contacts().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yuri").withLastname("Sidorin").withHomePhone("111").withMobilePhone("222").withWorkPhone("333").withEmail("123@123.qw").withAddress("Qwe qwe"), true);
    }
    if(app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test2"));
    }
    app.contact().goToHomePage();
  }

  @Test
  public void testAddContactToGroup() {
    Contacts before = app.db().contacts();
    ContactData contactToGroup = before.iterator().next();
    app.contact().add(contactToGroup);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
  }

  @Test
  public void testDelContactFromGroup() {
    Contacts before = app.db().contacts();
    ContactData removedContact = before.iterator().next();
    Groups list = app.db().groups();
    GroupData group = list.iterator().next();
    if (removedContact.getGroups().size() == 0) {
      ContactData addedContact = before.iterator().next();
      app.contact().add(addedContact);
    }
    app.contact().remove(removedContact, group);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    verifyContactListInUI();
  }
  }
