package dockerValidation;

import java.io.File;

import org.testng.annotations.Test;

public class DeleteOutput {
	@Test
	public void deletelog() {
		File file = new File("output.txt"); // File class returns boolean value that's why we have if condition
		if (file.delete()) {
			System.out.println("File deleted successfully");
		}

	}
}