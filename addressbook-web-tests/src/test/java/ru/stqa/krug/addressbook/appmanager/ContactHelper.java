package ru.stqa.krug.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getName());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("address"),contactData.getAddress());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("email"),contactData.getEmail());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
                   } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

       }
        

    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void goHomePage() {
        click(By.linkText("home"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selectContactModification(int index) {wd.findElements(By.cssSelector("img[title = 'Edit']")).get(index).click();
    }

    public void updateModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(ContactData contact, boolean b) {
        addNewContact();
        fillContactData(contact,b);
        submitNewContact();
        goHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name = 'entry']"));
        for (WebElement element: elements) {
            String id = element.findElement(By.xpath(".//input[@name = 'selected[]']")).getAttribute("id");
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName= cells.get(2).getText();
            ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null,
                    null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
