package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification (){
        app.getContactHelper().goHomePage ();
        app.getContactHelper().selectContactModification ();
        app.getContactHelper().fillContactData(new ContactData("Konstantin", "Nikolaevich", "Kruglov", "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890", "kruglovkn90@gmail.com"));
        app.getContactHelper().updateModification ();
        app.getNavigationHelper().returnToHomePage();

    }
}
