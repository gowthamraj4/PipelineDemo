package dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class startDocker {
	@Test
	public void startFile() throws IOException, InterruptedException // method
	{
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat"); // Invoking Chrome edge Firefox selenium hub nodes
		String file = "output.txt";

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 55);
		long StopNow = cal.getTimeInMillis();
		Thread.sleep(3000); //Mast provide to give some time to create the deleted log file 

		/*
		 * Calendar cal = Calendar.getInstance(); long startTime =
		 * cal.getTimeInMillis(); long currentTime =startTime;
		 * while(currentTime<startTime+10000){
		 */

		while (System.currentTimeMillis() < StopNow)
//------>	
		{
			if (flag) {
				break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine = reader.readLine();

			while (currentLine != null && !flag) 
			{
				if (currentLine.contains("Node has been added"))
				{
					System.out.println("L i n e   F o u n d . . .");
					flag = true;
					break;
					// use the break inside the "if" and it will break out of the "while".
					// You can't break out of if statement until the if is inside a loop.
				}
				currentLine = reader.readLine(); // Updated file read again
			}
			reader.close();
		}
//<------
		// Before that I Placed this statement In the above block
		// Due to that the statement become false instead of true
		Assert.assertTrue(flag);//docker is up and running
		runtime.exec("cmd /c start scale.bat");// Working extra 4 chrome nodes 
		//To make sure all the Instance are booted up ready for testing wait for 5 seconds
		//depands on number of nodes to bootUP the waiting time is also increased 
		Thread.sleep(15000); // Still the first value has scope to this statement
	}
}