package Steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base){
        this.base = base;
    }


    @Given("^I navigate to the Login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("I navigate to the Login page ");
        base.Driver.navigate().to("https://creds-webapi-qa.azurewebsites.net/admin");
        System.out.println("testestesennnnnnn ");
        System.out.println("YYYYYY ");
        System.out.println("XXXXXX ");
        System.out.println("zzzzzz YYYYYYY ");


        System.out.println("zzzzzz rttttt ");
        System.out.println("zzzzzz rtttttfff ");
        System.out.println("zzzzzz rttttt ");
    }

    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        //Create an array list
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.Driver);

        for (User user: users){
            page.Login(user.email,user.password);
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        base.Driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div[2]/footer/button")).click();

        System.out.println("I click login button");
    }

    @And("^I click on Sign Out button$")
    public void iClickOnSignOutButton() throws Throwable {

        base.Driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        base.Driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/div/div[3]/nav/div/div[2]/div[1]/ul/li[17]/a")).click();

        //GrabScrenShot
        GrabScrenShot(base.Driver);
    }

    @Then("^I should see the Login page Again$")
    public void iShouldSeeTheLoginPageAgain() throws Throwable {

        base.Driver.manage().timeouts().implicitlyWait(30000, TimeUnit.SECONDS);

        WebElement emailTxtbox;

        WebDriverWait wait = new WebDriverWait(base.Driver,30);
        emailTxtbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailTxtbox.sendKeys("Test");

        // base.Driver.close();

    }


    public class User
    {
        public String email;
        public String password;

        public User(String eMail, String passWord){
            email = eMail;
            password = passWord;
        }
    }

    public static void GrabScrenShot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        org.openqa.selenium.io.FileHandler.copy(screenshotFile, new File("/Users/Hiba/Desktop/screenshot.png"));
    }

    public static boolean exist(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public static void DragandDrop(WebDriver driver, WebElement srcelement, WebElement dstElement){
        Actions action = new Actions(driver);
        action.dragAndDrop(srcelement,dstElement).perform();
    }
}