package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.util.Iterator;

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



        app.contact().goHomePage();
        app.contact().selectContactById(selectedContact.getId());



    }
}
