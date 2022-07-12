package com.github.zipcodewilmington.casino.games.roulette;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class rouletteBallTest {

    private rouletteBall testRouletteBall;

    @Before
    public void setUp(){
        testRouletteBall = new rouletteBall();
    }

    @Test
    public void testNumberOne(){
        //Given
        int expected = 0;
        //When
        testRouletteBall.setNumber(expected);
        //Then
        Assert.assertEquals(expected, testRouletteBall.getNumber());
    }
    @Test
    public void testNumberTwo(){
        //Given
        int expected = 36;
        //When
        testRouletteBall.setNumber(expected);
        //Then
        Assert.assertEquals(expected, testRouletteBall.getNumber());
    }
    @Test
    public void testColorOne(){
        //Given
        String expected = "red";
        //When
        testRouletteBall.setColor(expected);
        //Then
        Assert.assertEquals(expected, testRouletteBall.getColor());
    }
    @Test
    public void testColorTwo(){
        //Given
        String expected = "black";
        //When
        testRouletteBall.setColor(expected);
        //Then
        Assert.assertEquals(expected, testRouletteBall.getColor());
    }
    @Test
    public void testColorThree(){
        //Given
        String expected = "green";
        //When
        testRouletteBall.setColor(expected);
        //Then
        Assert.assertEquals(expected, testRouletteBall.getColor());
    }
    @Test
    public void testEven(){
        //Given
        boolean expected = true;
        //When
        testRouletteBall.isEven();
        //Then
        Assert.assertTrue(expected);
    }
    @Test
    public void testFalse(){
        //Given
        boolean expected = false;
        //When
        testRouletteBall.isEven();
        //Then
        Assert.assertFalse(expected);
    }
}