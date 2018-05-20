package ru.stqa.krug.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().contacts().size()==0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                    .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com").withEmail3("kruglovkn90@gmail.com")
                    .withGroup("test1"), true);
        }
    }
    @Test
    public void testContactDeletion (){
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.goTo().homePage();
        app.contact().delete(deletedContact);
        assertThat(app.contact().getContactCount(),equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(deletedContact)));
    }
}
