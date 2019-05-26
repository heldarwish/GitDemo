package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base){
        this.base = base;
    }

    @Before
    public void InitializeTest()
    {
        //Firefox
        //System.setProperty("webdriver.gecko.bin", "/usr/local/bin/geckodriver");
        //base.Driver = new FirefoxDriver();

        //Chrome
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        base.Driver = new ChromeDriver();
    }

    @After
    public void TearDownTest()  {
       base.Driver.close();
    }
}
