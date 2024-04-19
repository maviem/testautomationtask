package stepdefinition;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.AddUserPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddUserStepDefinition {


    private ExtentReports extent;
    private ExtentTest test;
    @Given("user can successfully add a user on the table")
    public void user_can_successfully_add_a_user_on_the_table() {
        // Write code here that turns the phrase above into concrete actions

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        test = extent.createTest("Launch Browser");

        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        String url = "http://www.way2automation.com/angularjs-protractor/webtables/";
        driver.get(url);
        test.log(Status.INFO, "Browser launched");

        //validate that I am on the users list
        AddUserPage addUserPage = new AddUserPage(driver);
        addUserPage.clickAddUserButton(driver);
        addUserPage.enterAddUserFields(driver,"testFName","testLName","testUser"
                ,"testPassword","B", "Sales Team","testEmail@gmail.com","097273637");
        addUserPage.clickSaveButton(driver);

        driver.quit();

    }
    @Then("the user can successfully validate that the user is added on the table")
    public void the_user_can_successfully_validate_that_the_user_is_added_on_the_table() {
        // Write code here that turns the phrase above into concrete actions
        test.log(Status.INFO, "Browser closed");
        extent.flush();
    }




}
