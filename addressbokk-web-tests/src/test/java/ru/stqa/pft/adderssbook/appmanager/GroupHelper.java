package ru.stqa.pft.adderssbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adderssbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void fillForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
  public void modify(int index, GroupData group) {
    selectGroup(index);
    initGroupModification();
    fillForm(group);
    submitModification();
    returnToGroupPage();
  }
  public void initGroupModification() {
    click(By.name("edit"));
  }
  public void submitModification() {
    click(By.name("update"));
  }
  public void create(GroupData group) {
    initGroupCreation();
    fillForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroup();
    returnToGroupPage();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groups.add(group);
    }
    return groups;
  }
}
