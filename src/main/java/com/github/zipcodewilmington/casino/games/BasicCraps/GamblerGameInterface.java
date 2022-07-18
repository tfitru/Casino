package com.github.zipcodewilmington.casino.games.BasicCraps;

import com.github.zipcodewilmington.casino.PlayerInterface;

public interface GamblerGameInterface {

    void add(PlayerInterface player);

    void remove(PlayerInterface player);

    void run();

    void setBet();



}
