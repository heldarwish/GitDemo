package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.NAME,using = "email")
    public WebElement txtEmail;

    @FindBy(how = How.NAME,using = "password")
    public WebElement txtPassword;

    public  void Login(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }
}
