package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;

public class GroupDeletionTest extends TestBase {

  @Test
  public void groupDeletion (){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getNavigationHelper().goToHomePage();
  }
}
