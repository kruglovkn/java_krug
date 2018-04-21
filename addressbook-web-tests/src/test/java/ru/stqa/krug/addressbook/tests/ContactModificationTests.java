package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification (){
        app.getContactHelper().goHomePage ();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                    "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                    "kruglovkn90@gmail.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().selectContactModification ();
        app.getContactHelper().fillContactData(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                "kruglovkn90@gmail.com", null),false);
        app.getContactHelper().updateModification ();
        app.getNavigationHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before);

    }
}
