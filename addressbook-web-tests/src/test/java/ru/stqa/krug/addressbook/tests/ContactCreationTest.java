package ru.stqa.krug.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
       File photo = new File("src/test/resources/image.jpg");
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
        String line =reader.readLine();
        while (line!= null) {
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withName(split[0]).withMiddlename(split[1]).withLastname(split[2])
                    .withNickname(split[3]).withAddress(split[4]).withHome(split[5]).withMobile(split[6]).withWork(split[7])
            .withEmail(split[8]).withEmail2(split[9]).withEmail3(split[10]).withGroup(split[11]).withPhoto(photo)});
            line = reader.readLine();
        }
        return list.iterator();
    }



    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before = app.contact().all();
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
