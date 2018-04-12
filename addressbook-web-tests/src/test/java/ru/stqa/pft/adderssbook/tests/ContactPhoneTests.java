package ru.stqa.pft.adderssbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhone(){
    app.goTo();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
//    assertThat(contact.getMobilePhone(), equalTo(clean(contactInfoFromEditForm.getMobilePhone())));
//    assertThat(contact.getWorkPhone(), equalTo(clean(contactInfoFromEditForm.getWorkPhone())));
  }

  private String mergePhones(ContactData contact) {
   return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
           .map(ContactPhoneTests::clean)
           .collect(Collectors.joining("\n"));

  }

  public static String clean(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }
}
