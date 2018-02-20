package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("test1", "test2", "test3"));
    app.getNavigationHelper().submitModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
