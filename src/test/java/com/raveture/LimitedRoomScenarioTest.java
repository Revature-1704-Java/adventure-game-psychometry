package com.raveture;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * RoomScenarioTest
 */
public class LimitedRoomScenarioTest {
    private static LimitedRoomScenario test;
    private static int hpChange=2, newLoc=1, limit=2;
    private static String desc="test1", conseq="test2", lconseq="test3"; 
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Before
    public void Constructor(){
        test=new LimitedRoomScenario(desc, conseq, lconseq, hpChange, newLoc, limit);
    }
    @Test
    public void testChangeHpLimitOver0() {
        assertEquals(test.deltaHP(5), 5+hpChange);
    }
    @Test
    public void testChangeLocLimitOver0(){
        assertEquals(test.deltaLoc(),newLoc);
    }
    @Test
    public void testGetType(){
        assertEquals(test.getType(),"limited");
    }
    @Test
    public void testToString(){
        assertEquals("2,1", test.toString());
    }
    @Test
    public void testgetLimit(){
        assertEquals(test.getLimit(), 2);
    }
    @Test
    public void testLimitDecrement(){
        test.decrementLimit();
        assertEquals(test.getLimit(), 1);
    }
    @Test
    public void testChangeHpLimitReached() {
        test.decrementLimit();
        test.decrementLimit();
        assertEquals(test.deltaHP(5), 5);
    }
}

