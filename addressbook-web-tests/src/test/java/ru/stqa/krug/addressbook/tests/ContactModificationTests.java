package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().contacts().size()==0) {
            app.goTo().homePage();
            File photo = new File("src/test/resources/image.jpg");
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                    .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com").withEmail3("kruglovkn90@gmail.com")
                    .withGroup("test1").withPhoto(photo), true);
        }

    }
    @Test
    public void testContactModification (){
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        File photo = new File("src/test/resources/image.jpg");
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Konstantin").withMiddlename("Nikolaevich")
                .withLastname("Kruglov").withNickname("Krug")
                .withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                .withHome("6176718890").withWork("6176718890")
                .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com").withEmail3("kruglovkn90@gmail.com").withPhoto(photo);
        app.goTo().homePage();
        app.contact().selectContactById(contact.getId());
        app.contact().modify(contact);
        assertEquals(app.contact().getContactCount(),before.size());
        Contacts after = app.db().contacts();

        before.remove(modifiedContact);
        before.add(contact);
        assertEquals(before,after);
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

    }


}
