package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    private void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));

    }

}
