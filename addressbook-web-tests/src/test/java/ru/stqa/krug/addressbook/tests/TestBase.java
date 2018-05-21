package ru.stqa.krug.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.krug.addressbook.appmanager.ApplicationManager;
import ru.stqa.krug.addressbook.model.Contacts;
import ru.stqa.krug.addressbook.model.GroupData;
import ru.stqa.krug.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }



    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));

    }

    @AfterMethod (alwaysRun = true)
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());

    }

    public void verifyGroupListInUi() {
        if (Boolean.getBoolean("verifyUi")){
            Groups groupsFromDb = app.db().groups();
            Groups groupsFromUi = app.group().all();
            assertThat(groupsFromUi, equalTo(groupsFromDb.stream()
                    .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }
    public void verifyContactListFromUI() {
        if (Boolean.getBoolean("verifyUi")){
            Contacts contactsFromDb = app.db().contacts();
            Contacts contactsFromUi = app.contact().all();
            assertThat(contactsFromUi, equalTo(contactsFromDb.stream()
                    .map((g)-> new GroupData().withId(g.getId()).withName(g.getName()))
                    .collect(Collectors.toSet())));
        }
    }




}


