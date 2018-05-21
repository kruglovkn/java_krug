package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 1"));
        }
    }
    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test 1").withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
        app.group().modify(group);
        Assert.assertEquals(app.group().getGroupCount(),before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
        verifyGroupListInUi();
    }


}
