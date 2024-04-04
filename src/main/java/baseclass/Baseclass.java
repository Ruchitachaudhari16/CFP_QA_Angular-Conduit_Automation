package baseclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baseclass {

    public static WebDriver driver;

    public ExtentReports extentReports = new ExtentReports();
    public ExtentSparkReporter sparkReporter = new ExtentSparkReporter("outputFile\\ExtentReport.html");

    public static Properties properties;
    public Baseclass()
    {
    try {
        properties = new Properties();
        FileInputStream ip=new FileInputStream("C:\\Users\\www.abcom.in\\IdeaProjects\\AngularConduit\\src\\main\\java\\Config\\Config.properties");

        properties.load(ip);
    }
        catch (
    FileNotFoundException e)
    {
        e.printStackTrace();
    }
        catch (
    IOException e)
    {
        e.printStackTrace();
    }
}
public static void initialisation()
{
    String browsername=properties.getProperty("browser");
    if(browsername.equals("Chrome"))
    {
        driver=new ChromeDriver();
    } else if (browsername.equals("firefox"))
    {
        driver=new FirefoxDriver();
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();

    driver.get(properties.getProperty("url"));
}

}
