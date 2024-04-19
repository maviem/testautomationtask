package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class AddUserPage {

    @FindBy(xpath = "//table//button[contains(text(),'Add')]")
    private WebElement btnAddUser;

    @FindBy(xpath = "//table//button[contains(text(),'Add')]")
    private WebElement tableofUsers;

    @FindBy(xpath = "//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::select")
    private WebElement selectRole;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[1]")
    private WebElement txtFirstName;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[2]")
    private WebElement txtLastName;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[3]")
    private WebElement txtUsername;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[4]")
    private WebElement txtPassword;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[5]")
    private WebElement radioButtonCompanyA;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[6]")
    private WebElement radioButtonCompanyB;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[7]")
    private WebElement txtEmail;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::input)[8]")
    private WebElement txtCellPhone;

    @FindBy(xpath = "(//form[@name='smartTableValidForm']//td[contains(text(),'First Name')]/following::button)[2]")
    private WebElement btnSaveButton;

    public AddUserPage(WebDriver _driver)
    {
        PageFactory.initElements(_driver,this);
    }

    public void clickAddUserButton(WebDriver  driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddUser));
        btnAddUser.click();
    }

    public void clickSaveButton(WebDriver  driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSaveButton));
        btnSaveButton.click();
    }

    public void enterAddUserFields(WebDriver  driver, String firstName, String lastName, String username, String password,
                                   String customer, String role, String email, String cellPhone)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
        Random rand  =  new Random();
        int randomNumber  = rand.nextInt(1000);
        txtUsername.sendKeys(username + randomNumber);
        txtPassword.sendKeys(password);
        if(customer.contains("A"))
        {
            radioButtonCompanyA.click();
        }
        else
        {
            radioButtonCompanyB.click();
        }

        selectRole.click();
        Select select = new Select(selectRole);
        select.getOptions().get(1).click();


        txtEmail.sendKeys(email);
        txtCellPhone.sendKeys(cellPhone);

    }

}
