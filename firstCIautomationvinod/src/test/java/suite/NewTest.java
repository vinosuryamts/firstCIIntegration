package suite;

import org.testng.annotations.Test;

import firstCIautomationvinod.LaunchBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class NewTest {
	WebDriver launchdriver=null;
	
  @Test(dataProvider = "dp1")
  public void f(Integer n, String s,String site) {
	  LaunchBrowser lb = new LaunchBrowser();
	  launchdriver = lb.startBrowser(launchdriver, s);
	  lb.implicitWait(launchdriver,15,TimeUnit.SECONDS);
	  lb.navigateto(launchdriver,site);
	  lb.closeDriver(launchdriver);
  }

  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { 1, "Firefox" ,"https://amazon.com"},
      new Object[] { 2, "Chrome","https://flipkart.com" },
      new Object[] { 2, "Opera","https://google.com" },
    };
  }
}
