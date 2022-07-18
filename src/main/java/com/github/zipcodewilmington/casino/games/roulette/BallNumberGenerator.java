package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
public  class BallNumberGenerator extends RouletteBall {


    BallNumberGenerator(int number, String color, boolean even) {
        super(number, color, even);
    }

    public BallNumberGenerator() {
        super();
    }

    public RouletteBall generator() {

        RouletteBall results = new RouletteBall();

        Random random = new Random();
        int ballNumber = random.nextInt(38);
//        if (ballNumber == 37){ //37 --> '00'
//            String zer00 = "00";
//            int ball37 = Integer.parseInt(zer00);
//        }
        results.setNumber(ballNumber);
        results.setColor(colorResult(ballNumber));
        results.setEven(evenOrOdd(ballNumber));
        return results;
    }

    public String colorResult(int numLandedOn) {
        String color;
        if (numLandedOn == 0)
            color = ("Green " + numLandedOn + "\n");
        else if (numLandedOn == 37) //37 --> '00'
            color = ("Green 00");
        else if (numLandedOn % 2 == 0)
            color = ("Black " + numLandedOn + "\n");
        else
            color = ("Red " + numLandedOn + "\n");
        return color;
    }

    public boolean evenOrOdd(int numLandedOn) {
        boolean even = false;
        if (numLandedOn == 0)
            even = true;
        else if (numLandedOn == 37) //37 --> '00'
            even = true;
        else if (numLandedOn % 2 == 0)
            even = true;
        else
            even = false;
        return even;
    }

}