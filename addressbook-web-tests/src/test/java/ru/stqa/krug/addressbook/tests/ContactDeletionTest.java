package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion (){
        app.getContactHelper().goHomePage ();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                    "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                    "kruglovkn90@gmail.com", "test1"), true);
        }
        app.getContactHelper().selectContact ();
        app.getContactHelper().deleteContact ();
        app.getContactHelper().submitDeletion ();
        app.getContactHelper().goHomePage ();
    }
}
