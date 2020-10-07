package stqa.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private final String browser;
    private WebDriver driver;
    private RegistrationHelper registrationHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        return registrationHelper == null ? new RegistrationHelper(this) : registrationHelper;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            if (browser.equals(BrowserType.GOOGLECHROME)) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.get(properties.getProperty("web.baseUrl"));
        }
        return driver;
    }

//    public LoginPage loginPage() {
//        return loginPage == null ? new LoginPage(driver) : loginPage;
//    }
}
