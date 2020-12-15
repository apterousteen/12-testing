package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class Tests {
    @Test(expected = NullPointerException.class)
    public void testNull(){
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testSign(){
        Integer.decode("%");
    }

    @Test(expected = NumberFormatException.class)
    public void testWord(){
        Integer.decode("word");
    }

    @Test(expected = NumberFormatException.class)
    public void testPositiveWithSpace(){
        Integer.decode("+ 100");
    }

    @Test(expected = NumberFormatException.class)
    public void testNegativeWithSpace(){
        Integer.decode("- 100");
    }

    @Test
    public void testPositive(){
        assertEquals(66, Integer.decode("+66").longValue());
    }

    @Test
    public void testNegative(){
        assertEquals(-66, Integer.decode("-66").longValue());
    }

    @Test
    public void testZero(){
        assertEquals(0,Integer.decode("0").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble(){
        Integer.decode("13.13");
    }

    @Test
    public void testInt(){
        assertEquals(10, Integer.decode("10").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void testMinus() {
        Integer.decode("1-5");
    }

    @Test(expected = NumberFormatException.class)
    public void testPlus() {
        Integer.decode("1+5");
    }

    @Test(expected = NumberFormatException.class)
    public void testSpaces() {
        Integer.decode("22 11");
    }

    @Test
    public void testIntMinValue(){
        assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648").longValue());
    }

    @Test
    public void testIntMaxValue(){
        assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647").longValue());
    }

    @Test
    public void testOctal(){
        assertEquals(63, Integer.decode("077").longValue());
    }

    @Test
    public void testHex(){
        assertEquals(187, Integer.decode("#BB"));
        assertEquals(750, Integer.decode("0x2EE"));
        assertEquals(13, Integer.decode("0Xd"));
    }
}

