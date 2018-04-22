package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification (){
        app.getContactHelper().goHomePage ();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Konstantin", "Nikolaevich", "Kruglov",
                    "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                    "kruglovkn90@gmail.com", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().selectContactModification ();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Konstantin", "Nikolaevich", "Kruglov",
                "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890",
                "kruglovkn90@gmail.com", null);
        app.getContactHelper().fillContactData(contact,false);
        app.getContactHelper().updateModification ();
        app.getNavigationHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }
}
