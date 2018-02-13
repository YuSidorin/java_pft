package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

  @Test
  public void deleteContact() {
    app.getContactHelper().initContactModification();
    app.getContactHelper().deleteContact();
  }
}
