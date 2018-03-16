package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.appmanager.ContactHelper;
import ru.stqa.pft.adderssbook.model.ContactData;
import ru.stqa.pft.adderssbook.model.Contacts;
import ru.stqa.pft.adderssbook.model.GroupData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.contact().all().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yuri").withLastname("Sidorin").withHomePhone("111").withMobilePhone("222").withWorkPhone("333"), true);
    }
  }
  @Test
  public void deleteContact() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
