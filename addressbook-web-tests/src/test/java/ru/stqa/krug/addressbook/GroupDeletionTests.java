package ru.stqa.krug.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    
    @Test
    public void testsGroupDeletion() {
        goToGroupPage();
        selectGroup();
        deleteSelectedGroup();
        returnToGroupPage();
    }


}
