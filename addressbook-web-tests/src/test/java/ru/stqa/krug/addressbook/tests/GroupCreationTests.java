package ru.stqa.krug.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    private void testGroupCreation() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().create(group);
        assertThat(app.group().getGroupCount(),equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

}
    @Test
    private void testBadGroupCreation() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1'");
        app.group().create(group);
        assertThat(app.group().getGroupCount(),equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));

    }
}
