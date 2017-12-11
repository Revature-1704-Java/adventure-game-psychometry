package com.raveture;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
/**
 * RoomScenarioTest
 */
public class RoomScenarioTest {
    private static RoomScenario test;
    private static int hpChange=2, newLoc=1;
    private static String desc="test1", conseq="test2"; 
    @Before
    public void Constructor(){
        test=new RoomScenario(desc, conseq, hpChange, newLoc);
    }
    @Test
    public void testChangeHp() {
        assertEquals(test.deltaHP(5), 5+hpChange);
    }
    @Test
    public void testChangeLoc(){
        assertEquals(test.deltaLoc(),newLoc);
    }

}

