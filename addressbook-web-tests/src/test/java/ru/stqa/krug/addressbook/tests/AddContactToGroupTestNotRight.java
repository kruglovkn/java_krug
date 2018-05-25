package ru.stqa.krug.addressbook.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTestNotRight extends TestBase {
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
    @BeforeMethod
    public void ensureContactPrecondition2() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        for (ContactData contact: contacts) {
            contact.getGroups();
            return;
        }
    }
    @Test
    public void testAddContactToGroup () {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();

        ContactsInGroups before = app.db().contactsInGroups();
        ContactData contactToGroup = contacts.iterator().next();
        GroupData groupForContact = groups.iterator().next();
        ContactsInGroupsData moved = new ContactsInGroupsData().withContactId(contactToGroup.getId()).withGroupId(groupForContact.getId());
        app.goTo().homePage();
        app.contact().selectContactById(contactToGroup.getId());
        app.contact().addToGroup(contactToGroup);
        ContactsInGroups after = app.db().contactsInGroups();

        before.add(moved);
        assertThat(after, equalTo(before.withMoved(moved)));

    }
}
