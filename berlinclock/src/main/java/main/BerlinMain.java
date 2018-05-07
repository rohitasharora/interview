package main;

import concrete.BerlinTimeConverter;

public class BerlinMain {

	public static void main(String[] args) {
		BerlinTimeConverter berlinTime = new BerlinTimeConverter();
		System.out.println(berlinTime.convertTime(args[0]));
		/*System.out.println("00:00:00" + "\n" +berlinTime.convertTime("00:00:00"));
		System.out.println("13:17:01" + "\n" +berlinTime.convertTime("13:17:01"));
		System.out.println("23:59:59" + "\n" +berlinTime.convertTime("23:59:59"));
		System.out.println("24:00:00" + "\n" +berlinTime.convertTime("24:00:00"));*/
	}

}
