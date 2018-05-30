package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.mantis.model.UserData;

public class ChangeHelper extends HelperBase {

    public ChangeHelper(ApplicationManager app) {
        super(app);
    }

    public void loginAsAdmin () {
        wd.get(app. getProperty("web.baseUrl")+ "/login_page.php");
        type(By.name("username"), app.getProperty("web.adminLogin"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.xpath("//input[@value='Login']"));
    }

    public void resetUserPassword(int id) {
        wd.get(app. getProperty("web.baseUrl")+ "/manage_user_page.php");
        wd.findElement(By.cssSelector("a[href='manage_user_edit_page.php?user_id=" + id +"']")).click();
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void finish(String conformationLink, String password) {
        wd.get(conformationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
