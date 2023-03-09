package dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromStandaloneTest {
	@Test
	public void case1() throws MalformedURLException {

		URL url = new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("browserName", "chrome");
		RemoteWebDriver driver = new RemoteWebDriver(url, cap);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());

	}
}