package firstCIautomationvinod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchBrowser {
		
			public static  WebDriver driver = null;
	
			@SuppressWarnings("deprecation")
			public WebDriver startBrowser(WebDriver launchdriver, String drivername) {
				
				driver = launchdriver;
				
				switch(drivername) {
					case "Chrome":
						System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						break;
						
					case "Firefox":
						System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
						DesiredCapabilities capabilities = DesiredCapabilities.firefox();
						capabilities.setCapability("marionette",true);
						driver = new FirefoxDriver(capabilities);
						driver.manage().window().maximize();
						break;
						
					case "Internet Explorer":
						System.setProperty("webdriver.ie.driver",".\\driver\\IEDriverServer.exe");
						driver = new InternetExplorerDriver();
						driver.manage().window().maximize();
						break;
						
					case "Opera":
						System.setProperty("webdriver.opera.driver", ".\\driver\\operadriver.exe");
						OperaOptions options = new OperaOptions();
				        options.setBinary("C:\\Users\\FALMS\\AppData\\Local\\Programs\\Opera\\64.0.3417.61_1\\opera.exe");
						driver = new OperaDriver(options);
						driver.manage().window().maximize();
						break;
						
					default:
						System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
						driver = new ChromeDriver();
						driver.manage().window().maximize();
						break;
				}
				
				
				return driver;
				
			}
			
			public  void implicitWait(WebDriver driverval,int seconds,TimeUnit time) {
				System.out.println("Time Wait " + seconds + " "+ time);
				driver = driverval;
				driver.manage().timeouts().implicitlyWait(seconds, time);
			}
			
			public void navigateto(WebDriver driverval,String url) {
				driver = driverval;
				driver.get(url);
			}
			
			public void closeDriver(WebDriver driverval) {
				driver = driverval;
				driver.close();
				
				try {
					Runtime.getRuntime().exec("taskkill /f /im opera.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

}
