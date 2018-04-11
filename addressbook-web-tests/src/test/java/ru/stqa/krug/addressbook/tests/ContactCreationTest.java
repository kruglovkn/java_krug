package ru.stqa.krug.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.krug.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().addNewContact();
        final ContactData contactData = new ContactData("Konstantin", "Nikolaevich", "Kruglov", "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890", "kruglovkn90@gmail.com");
        app.getContactHelper().fillContactData(contactData.getName(), contactData.getMiddlename(), contactData.getLastname(), contactData.getNickname(), contactData.getAddress(), contactData.getMobile(), contactData.getEmail());
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().returnToHomePage();
    }

}
