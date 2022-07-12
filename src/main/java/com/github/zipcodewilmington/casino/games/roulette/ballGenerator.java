package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;
public class ballGenerator extends rouletteBall {
    public rouletteBall generator(){

        rouletteBall results = new rouletteBall();

        Random random = new Random();
        int ballNumber = random.nextInt(36);
        results.setNumber(ballNumber);
        results.setColor(colorResult(ballNumber));
        results.setEven(evenOrOdd(ballNumber));
        return results;
    }

    public String colorResult(int numLandedOn){
        String color;
        if(numLandedOn == 0)
            color = ("green" + numLandedOn);
        else if (numLandedOn % 2 == 0)
            color = ("black" + numLandedOn);
        else
            color = ("red" + numLandedOn);
        return color;
    }

    private boolean evenOrOdd(int numLandedOn){
        boolean even = false;
        if(numLandedOn == 0)
            even = true;
        else if(numLandedOn % 2 == 0)
            even = true;
        else
            even = false;
        return even;
    }
}