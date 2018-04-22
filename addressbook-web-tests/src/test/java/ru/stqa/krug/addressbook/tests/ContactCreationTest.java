package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().goHomePage ();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                "kruglovkn90@gmail.com", "test1"), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

    }

}
