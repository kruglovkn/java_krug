package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData().withName("Konstantin").withMiddlename("Nikolaevich")
                    .withLastname("Kruglov").withNickname(
                            "Krug").withAddress("21 High st. apt. 11, Hudson, MA, USA").withMobile("6176718890")
                    .withEmail("kruglovkn90@gmail.com").withGroup("test1"), true);
        }
    }
    @Test
    public void contactDataTest(){
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(),equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contact.getHome(),equalTo(cleaned(contactInfoFromEditForm.getHome())));
        assertThat(contact.getMobile(),equalTo(cleaned(contactInfoFromEditForm.getMobile())));
        assertThat(contact.getWork(),equalTo(cleaned(contactInfoFromEditForm.getWork())));
        assertThat(contact.getEmail(),equalTo(contactInfoFromEditForm.getEmail()));
        assertThat(contact.getEmail2(),equalTo(contactInfoFromEditForm.getEmail2()));
        assertThat(contact.getEmail3(),equalTo(contactInfoFromEditForm.getEmail3()));
    }

    public String cleaned (String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}
