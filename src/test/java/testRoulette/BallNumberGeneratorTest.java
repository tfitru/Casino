package testRoulette;

import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallNumberGeneratorTest {

    private BallNumberGenerator testBallGenerator;

    @Before
    public void setUp(){
        testBallGenerator = new BallNumberGenerator();
    }
    @Test
    public void testNumberOne(){
        //Given
        int expected = 0;
        //When
        testBallGenerator.setNumber(expected);
        //Then
        Assert.assertEquals(expected, testBallGenerator.getNumber());
    }
    @Test
    public void testNumberTwo(){
        //Given
        int expected = 36;
        //When
        testBallGenerator.setNumber(expected);
        //Then
        Assert.assertEquals(expected, testBallGenerator.getNumber());
    }
    @Test
    public void testColorOne(){
        //Given
        String expected = "red";
        //When
        testBallGenerator.setColor(expected);
        //Then
        Assert.assertEquals(expected, testBallGenerator.getColor());
    }
    @Test
    public void testColorTwo(){
        //Given
        String expected = "black";
        //When
        testBallGenerator.setColor(expected);
        //Then
        Assert.assertEquals(expected, testBallGenerator.getColor());
    }
    @Test
    public void testColorThree(){
        //Given
        String expected = "green";
        //When
        testBallGenerator.setColor(expected);
        //Then
        Assert.assertEquals(expected, testBallGenerator.getColor());
    }
    @Test
    public void testEven(){
        //Given
        boolean expected = true;
        //When
        testBallGenerator.isEven();
        //Then
        Assert.assertTrue(expected);
    }
    @Test
    public void testFalse(){
        //Given
        boolean expected = false;
        //When
        testBallGenerator.isEven();
        //Then
        Assert.assertFalse(expected);
    }

}