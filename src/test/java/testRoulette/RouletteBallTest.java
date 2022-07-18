package testRoulette;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import com.github.zipcodewilmington.casino.games.roulette.RouletteBall;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class RouletteBallTest {
    private RouletteBall testRouletteBall;

    @Before
    public void setUp(){
        testRouletteBall = new RouletteBall();
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