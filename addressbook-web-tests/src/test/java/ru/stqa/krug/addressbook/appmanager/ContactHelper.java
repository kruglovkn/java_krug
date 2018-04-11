package ru.stqa.krug.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase{

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactData(String firstname, String middlename, String lastname, String nickname, String address, String mobile, String email) {
        type(By.name("firstname"),firstname);
        type(By.name("middlename"),middlename);
        type(By.name("lastname"),lastname);
        type(By.name("nickname"),nickname);
        type(By.name("address"),address);
        type(By.name("mobile"),mobile);
        type(By.name("email"),email);

    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }
}
