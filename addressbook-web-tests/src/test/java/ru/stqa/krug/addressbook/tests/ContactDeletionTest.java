package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion (){
        app.getContactHelper().goHomePage ();
        app.getContactHelper().selectContact ();
        app.getContactHelper().deleteContact ();
        app.getContactHelper().submitDeletion ();
        app.getContactHelper().goHomePage ();
    }
}
