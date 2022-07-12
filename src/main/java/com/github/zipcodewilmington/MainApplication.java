package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.roulette.ballGenerator;

public class MainApplication {
    public static void main(String[] args) {

        ballGenerator x = new ballGenerator();

       x.colorResult(6);
       System.out.println(x.colorResult(6));
    }
}
