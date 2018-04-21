package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    private void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before + 1);

    }

}
