package ru.stqa.krug.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.krug.addressbook.model.ContactData;
import ru.stqa.krug.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        attach(By.name("photo"),contactData.getPhoto());
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
    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id = '" + id + "']")).click();
    }
    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void submitDeletion() {
        wd.switchTo().alert().accept();
    }

    public void selectContactModification(int index) {wd.findElements(By.cssSelector("img[title = 'Edit']")).get(index).click();
    }
    public void selectContactModificationById(int id) {wd.findElement(By.cssSelector("a[href = 'edit.php?id=" + id +"']")).click();
    }
    public void updateModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void create(ContactData contact, boolean b) {
        addNewContact();
        fillContactData(contact,b);
        submitNewContact();
        ContactCache = null;
        goHomePage();
    }
    public void modify(ContactData contact) {
        selectContactModificationById (contact.getId());
        fillContactData(contact,false);
        updateModification ();
        ContactCache = null;
        goHomePage();
    }
    public void delete(int index) {
        selectContact (index);
        deleteContact ();
        submitDeletion ();
        goHomePage ();
    }
    public void delete(ContactData contact) {
        selectContactById (contact.getId());
        deleteContact ();
        submitDeletion ();
        ContactCache = null;
        goHomePage ();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name = 'entry']"));
        for (WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.xpath(".//input[@name = 'selected[]']")).getAttribute("id"));
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName= cells.get(2).getText();
            contacts.add(new ContactData().withId(id).withName(firstName).withLastname(lastName));
        }
        return contacts;
    }
    private Contacts ContactCache = null;

    public Contacts all() {
        if (ContactCache != null){
            return new Contacts(ContactCache);
        }
        ContactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name = 'entry']"));
        for (WebElement element: elements) {
            int id = Integer.parseInt(element.findElement(By.xpath(".//input[@name = 'selected[]']")).getAttribute("id"));
            List<WebElement> cells =element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName= cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails  = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            ContactCache.add(new ContactData().withId(id).withName(firstName).withLastname(lastName).withAddress(address)
                    .withAllEmails(allEmails).withAllPhones(allPhones));
        }
        return new Contacts(ContactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        selectContactModificationById (contact.getId());
        String name = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        goHomePage ();
        return new ContactData().withId(contact.getId()).withName(name).withLastname(lastname)
                .withAddress(address).withHome(home).withMobile(mobile).withWork(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);

    }
}
