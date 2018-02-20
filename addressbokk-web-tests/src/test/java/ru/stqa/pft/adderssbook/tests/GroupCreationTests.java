package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", null, null));

  }

}
