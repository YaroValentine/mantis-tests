package stqa.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String user, String pass) {
        driver.get(app.getProperty("web.baseURL") + "/login_page.php");
        type(By.name("username"), user);
    }
}