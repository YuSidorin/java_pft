package ru.stqa.pft.adderssbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationManager().gotoGroup();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
