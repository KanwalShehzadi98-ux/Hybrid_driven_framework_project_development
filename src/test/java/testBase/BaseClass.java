package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    Properties p;

    @Parameters({"browser","os"})
    @BeforeClass(groups= {"Sanity","Regression","Master"})
    public void setup(String br, String os) throws IOException {
    	
    	FileReader file = new FileReader("C:\\Users\\PMLS\\eclipse-workspace\\Project\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);
        
    	logger = LogManager.getLogger(this.getClass()); 
    	
        switch(br) {
        case "chrome": driver = new ChromeDriver(); break;
        case "edge": driver = new EdgeDriver(); break;
        case "firefox": driver = new FirefoxDriver(); break;
        default: System.out.println("Invalid Browser"); return;
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL2"));
    }
    
    public String captureScreen(String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        File destination = new File(destinationPath);
        FileUtils.copyFile(source, destination);
        return destinationPath;
    }

    @AfterClass(groups= {"Sanity","Regression","Master"})
    public void tearDown() {
        driver.quit();
    }
    
	public String randomStrings() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumbers() {
		String generatedNumbers = RandomStringUtils.randomNumeric(11);
		return generatedNumbers;
	}
	
	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumbers = RandomStringUtils.randomNumeric(3);
		return generatedString+"@"+generatedNumbers;
	}
}
