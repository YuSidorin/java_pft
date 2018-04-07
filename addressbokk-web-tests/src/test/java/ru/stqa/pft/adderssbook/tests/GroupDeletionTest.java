package ru.stqa.pft.adderssbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;
import ru.stqa.pft.adderssbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions() {
    if(app.db().groups().size() == 0){
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test"));
    }
  }
  @Test
  public void groupDeletion (){
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo(before.size() - 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.without(deletedGroup)));

  }
}
