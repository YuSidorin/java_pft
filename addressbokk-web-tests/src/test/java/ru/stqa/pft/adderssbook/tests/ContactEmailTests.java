package ru.stqa.pft.adderssbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

    public class ContactEmailTests extends TestBase {

        @Test
        public void testContactEmail() {
            app.goTo();
            ContactData contact = app.contact().all().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            assertThat(contact.getEmail(), equalTo(clean(contactInfoFromEditForm.getEmail())));
        }

        public static String clean(String email) {
            return email.replaceAll("\\s", "");

        }
    }
