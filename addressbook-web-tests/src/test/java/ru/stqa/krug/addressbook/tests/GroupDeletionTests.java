package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    
    @Test
    public void testsGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
    }


}
