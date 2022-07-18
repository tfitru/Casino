package testRoulette;

import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import com.github.zipcodewilmington.casino.games.roulette.RouletteBall;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RouletteGameTest {


    RouletteGame testRouletteGame;

    @Before
    public void setUp() {
        testRouletteGame = new RouletteGame();
    }

    @Test
    public void testNumberOne() {
        Random rand = new Random(1);
        int expected = rand.nextInt(37);
        int actual = 31;

        Assert.assertEquals(expected, actual);
    }
}