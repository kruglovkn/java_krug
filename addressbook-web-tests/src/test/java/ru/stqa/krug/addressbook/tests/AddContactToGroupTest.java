package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupTest extends TestBase {

    @Test
    public void testAddContactToGroup() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        int selectedId = 0;
        ContactData selectedContact = new ContactData();
        for (ContactData contact : contacts) {
            if (!contact.getGroups().equals(groups)) {
               selectedId = contact.getId();
               selectedContact = contact;
            } if (selectedId!=0){
                break;
            } else if (selectedId == 0) {
                selectedContact = new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                        .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                        .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                        .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com")
                        .withEmail3("kruglovkn90@gmail.com");
                app.contact().create(selectedContact, true);
            }
        }

        groups.removeAll(selectedContact.getGroups());
        GroupData selectedGroup = groups.iterator().next();
        app.contact().goHomePage();
        Groups before = selectedContact.getGroups();
        app.contact().selectContactById(selectedContact.getId());
        app.contact().addToGroup(selectedContact, selectedGroup.getName());

        Groups after = selectedContact.getGroups();
        before.add(selectedGroup);
        assertThat(after, equalTo(before.withAdded(selectedGroup)));



    }
}
