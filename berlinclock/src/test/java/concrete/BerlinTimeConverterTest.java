package concrete;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BerlinTimeConverterTest {

	@Test
	public void testMidNight() {
		String output = 
				"Y\n" +
						"OOOO\n" +
						"OOOO\n" +
						"OOOOOOOOOOO\n" +
						"OOOO";

		assertEquals(output, new BerlinTimeConverter().convertTime("00:00:00"));
	}
	@Test
	public void testMidNightless1sec() {
		String output = 
				"O\n" +
						"RRRR\n" +
						"RRRO\n" +
						"YYRYYRYYRYY\n" +
						"YYYY";

		assertEquals(output, new BerlinTimeConverter().convertTime("23:59:59"));
	}
	@Test
	public void testMidAfternoon() {
		String output = 
				"O\n" +
						"RROO\n" +
						"RRRO\n" +
						"YYROOOOOOOO\n" +
						"YYOO";

		assertEquals(output, new BerlinTimeConverter().convertTime("13:17:01"));
	}
	@Test
	public void testMidNightless2hrs() {
		String output = 
				"Y\n" +
						"RRRR\n" +
						"RRRR\n" +
						"OOOOOOOOOOO\n" +
						"OOOO";

		assertEquals(output, new BerlinTimeConverter().convertTime("24:00:00"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullTimeFormat() {
		new BerlinTimeConverter().convertTime(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyTimeFormat() {
		new BerlinTimeConverter().convertTime("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat1() {
		new BerlinTimeConverter().convertTime("-24:10:10");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat2() {
		new BerlinTimeConverter().convertTime("24:-10:10");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat3() {

		new BerlinTimeConverter().convertTime("24:10:-10");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat4() {
		new BerlinTimeConverter().convertTime("240:10:10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat5() {
		new BerlinTimeConverter().convertTime("27:10:10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat6() {
		new BerlinTimeConverter().convertTime("24:100:10");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat7() {
		new BerlinTimeConverter().convertTime("24:10:100");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTimeFormat8() {
		new BerlinTimeConverter().convertTime("24:10");
	}

}
