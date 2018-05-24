package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.io.File;

public class AddContactToGroupTest extends TestBase {
    @BeforeMethod
    public void ensureGroupPrecondition() {
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 1"));
        }
    }
    @BeforeMethod
    public void ensureContactPrecondition() {
        if (app.db().contacts().size()==0) {
            app.goTo().homePage();
            Groups groups = app.db().groups();
            File photo = new File("src/test/resources/image.jpg");
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                    .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com").withEmail3("kruglovkn90@gmail.com").
                            withGroup(groups.iterator().next()).withPhoto(photo), true);
        }

    }
    @Test
    public void testAddContactToGroup () {
        Contacts before = app.db().contacts();
        ContactData contact = before.iterator().next();
        app.goTo().homePage();
        app.contact().selectContactById(contact.getId());
        app.contact().addToGroup(contact);

    }
}
