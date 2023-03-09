package dockerValidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class chromeTest1 {

	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		startDocker s = new startDocker();
		// Creating object for startdocker class to access any method in the class
		s.startFile();
	}
	
/*	@AfterTest
	public void logDelete() throws IOException, InterruptedException {
		DeleteOutput log = new DeleteOutput();
		// Creating object for startdocker class to access any method in the class
		log.deletelog();
	}
*/
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException {
		stopDocker x = new stopDocker();
		// Creating object for startdocker class to access any method in the class
		x.stopFile();
	}

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