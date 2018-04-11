package ru.stqa.krug.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{


    @Test
    public void testContactCreation() {
        wd.get("http://localhost/addressbook/edit.php");

        addNewContact();
        fillContactData(new ContactData("Konstantin", "Nikolaevich", "Kruglov", "Krug", "21 High st. apt. 11, Hudson, MA, USA", "6176718890", "kruglovkn90@gmail.com"));
        submitNewContact();
        returnToHomePage();
    }

}
