package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().goHomePage ();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                "kruglovkn90@gmail.com", "test1"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before + 1);

    }

}
