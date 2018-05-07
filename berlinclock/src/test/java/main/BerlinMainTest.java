package main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class BerlinMainTest {

	private final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outStream));
    }
    
    @Test
    public void testMain(){
    	String[] input = {"00:00:00"};
    	String output = 
    			"Y\n" +
    			"OOOO\n" +
    			"OOOO\n" +
    			"OOOOOOOOOOO\n" +
    			"OOOO\r\n";
    	BerlinMain.main(input);
    	assertEquals(output, outStream.toString());
    }
}
