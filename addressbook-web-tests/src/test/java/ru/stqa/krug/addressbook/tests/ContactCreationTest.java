package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().addNewContact();
        app.getContactHelper().fillContactData(new ContactData("Konstantin", "Nikolaevich", "Kruglov", "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890", "kruglovkn90@gmail.com", "test1"), true);
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().returnToHomePage();
    }

}
