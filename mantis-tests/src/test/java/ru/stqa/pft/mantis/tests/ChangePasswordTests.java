package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

public class ChangePasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testPasswordChange() throws IOException, MessagingException {
        UserData admin = new UserData();
        UserData user = app.db().users().stream().filter((u)-> !u.equals(admin.withName("administrator")
                .withId(1).withEmail("root@localhost"))).collect(Collectors.toList()).iterator().next();
        String email = user.getEmail();
        String password = "password1";
        app.change().loginAsAdmin();
        app.change().resetUserPassword(user.getId());
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 50000);
        String conformationLink = findConformationLink(mailMessages, email);
        app.change().finish(conformationLink, password);

        assertTrue(app.newSession().login(user.getName(), password));

    }

    private String findConformationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
