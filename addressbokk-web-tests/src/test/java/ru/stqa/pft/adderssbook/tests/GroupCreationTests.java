package ru.stqa.pft.adderssbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.adderssbook.model.GroupData;
import ru.stqa.pft.adderssbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static afu.org.checkerframework.checker.units.UnitsTools.g;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {
  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.csv")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xStream.fromXML(xml);
    groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    return list.iterator();
  }


  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
    app.goTo().GroupPage();
    Groups before = app.group().all();
//    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

//  @Test
//  public void testBadGroupCreation() {
//    app.goTo().GroupPage();
//    Groups before = app.group().all();
//    GroupData group = new GroupData().withName("test'");
//    app.group().create(group);
//    assertThat(app.group().count(), equalTo(before.size()));
//    Groups after = app.group().all();
//
//    assertThat(after, equalTo(before));
//  }
}
