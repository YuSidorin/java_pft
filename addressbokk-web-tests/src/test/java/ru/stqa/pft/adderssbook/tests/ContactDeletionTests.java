package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstname("Yuri").withLastname("Sidorin").withNickname("YuSidorin").withTitle("test").withCompany("Cnet").withEmail("test").withPhone("890898098980").withHomepage("sd").withAddress("asda"), true);
    }
  }
  @Test
  public void deleteContact() {
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), index);
    before.remove(index);
      Assert.assertEquals(before, after);
  }
}
