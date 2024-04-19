import common.AddUserPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddUserTest {

    @Test
    public void validateThatUserIsAdded()
    {
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        String url = "http://www.way2automation.com/angularjs-protractor/webtables/";
        driver.get(url);

        //validate that I am on the users list
        AddUserPage addUserPage = new AddUserPage(driver);
        addUserPage.clickAddUserButton(driver);
        addUserPage.enterAddUserFields(driver,"testFName","testLName","testUser"
                ,"testPassword","B", "Sales Team","testEmail@gmail.com","097273637");
        addUserPage.clickSaveButton(driver);

        driver.quit();

    }


}
