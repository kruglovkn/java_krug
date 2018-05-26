package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.io.File;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTest extends TestBase {
    @BeforeMethod
    public void ensureGroupPrecondition() {
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test 1"));
        }

        if (app.db().contacts().size()==0) {
            app.goTo().homePage();
            File photo = new File("src/test/resources/image.jpg");
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                    .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com")
                    .withEmail3("kruglovkn90@gmail.com").withPhoto(photo), true);
        }
    }
    @Test
    public void testDeleteContactFromGroup() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        int selectedId = 0;
        ContactData selectedContact = new ContactData();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() > 0) {
                selectedId = contact.getId();
                selectedContact = contact;
            } if (selectedId != 0) {break;}
        }
        if (selectedId == 0) {
                selectedContact = new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                        .withLastname("Kruglov").withNickname("Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA")
                        .withMobile("6176718890").withHome("6176718890").withWork("6176718890")
                        .withEmail("kruglovkn90@gmail.com").withEmail2("kruglovkn90@gmail.com")
                        .withEmail3("kruglovkn90@gmail.com");
                app.contact().create(selectedContact, true);
            }

        GroupData selectedGroup = selectedContact.getGroups().iterator().next();
        Groups before = selectedContact.getGroups();
        app.contact().goHomePage();
        app.contact().selectGroup(selectedGroup.getName());
        app.contact().selectContactById(selectedContact.getId());
        app.contact().deleteFromGroup();
        ContactData finalSelectedContact = selectedContact;
        Groups after = app.db().contacts().stream().filter((c) -> c.equals(finalSelectedContact))
                .collect(Collectors.toList()).iterator().next().getGroups();
        before.add(selectedGroup);
        before.remove(selectedGroup);
        assertThat(after, equalTo(before.withOut(selectedGroup)));
    }
}
