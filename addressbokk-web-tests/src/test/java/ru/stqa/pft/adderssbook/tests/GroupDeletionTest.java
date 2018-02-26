package ru.stqa.pft.adderssbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void groupDeletion (){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToHomePage();
    int after = app.getGroupHelper().countGroups();
    Assert.assertEquals(after, before.size() - 1);
  }
}
