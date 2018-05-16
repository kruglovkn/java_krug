package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
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

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/image.jpg");
        ContactData contact = new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                .withLastname("Kruglov").withNickname(
                "Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                .withEmail("kruglovkn90@gmail.com").withGroup("test1").withPhoto(photo);
        app.contact().create(contact, true);
        assertEquals(app.contact().getContactCount(),before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(
                contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

        }
    @Test    (enabled = false)
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withName("Konstantin'").withMiddlename("Nikolaevich")
                .withLastname("Kruglov").withNickname(
                        "Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                .withEmail("kruglovkn90@gmail.com").withGroup("test1");
        app.contact().create(contact, true);
        assertEquals(app.contact().getContactCount(),before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }

    @Test
    public void getCurrantDir() {
        File currantDir = new File(".");
        System.out.println(currantDir.getAbsolutePath());
        File photo = new File("src/test/resources/image.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
}
