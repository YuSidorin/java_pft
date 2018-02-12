package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void groupDeletion (){
    app.getNavigationManager().gotoGroup();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSeletedGroup();
    app.getGroupHelper().returnToGroupPage();
  }

}
