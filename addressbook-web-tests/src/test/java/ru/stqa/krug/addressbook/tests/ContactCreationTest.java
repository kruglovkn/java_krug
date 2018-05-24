package ru.stqa.krug.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.Groups;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {

        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line =reader.readLine();
            while (line!= null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {}.getType());
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }



    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/image.jpg");
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().create(contact.withPhoto(photo).withGroup(groups.iterator().next()), true);
        assertEquals(app.contact().getContactCount(),before.size() + 1);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withAdded(
                contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyContactListFromUI();

        }
    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        File photo = new File("src/test/resources/image.jpg");
        ContactData contact = new ContactData().withName("Konstantin'").withMiddlename("Nikolaevich")
                .withLastname("Kruglov").withNickname(
                        "Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                .withEmail("kruglovkn90@gmail.com").withPhoto(photo);
        app.contact().create(contact, true);
        assertEquals(app.contact().getContactCount(),before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before));
        verifyContactListFromUI();

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
