package dockerValidation;

import java.util.Calendar;

public class timeing {
	public static void main(String[] args) throws InterruptedException {

		Calendar cal = Calendar.getInstance();// 2:44 15th second
		cal.add(Calendar.SECOND, 5);// 2:44 45seconds
		long stopnow = cal.getTimeInMillis();
		Thread.sleep(3000);
//	System.out.println(cal);
//	System.out.println(stopnow);

		while (System.currentTimeMillis() < stopnow) {
			System.out.println("BNIUUIU");
		}

	}
}
