package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homePage();
        if (app.contact().list().size()==0){
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                    .withMobile("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withGroup("test1"), true);
        }
    }
    @Test
    public void testContactModification (){
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Konstantin").withMiddlename("Nikolaevich")
                .withLastname("Kruglov").withNickname("Krug")
                .withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                .withEmail("kruglovkn90@gmail.com");
        app.contact().selectContactById(contact.getId());
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before,after);

    }


}
