package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    private void testGroupCreation() {

        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
