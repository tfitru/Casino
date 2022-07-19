package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame extends CasinoAccountManager implements GameInterface {
    public static int playerGuess;
    public static int randomNumber;
    Scanner playerObject = new Scanner(System.in);
    String playerName;
    private final IOConsole console = new IOConsole();


    Integer balance;
    List<PlayerInterface> gambler = new ArrayList<>();



    @Override
    public void add(PlayerInterface player) {
        player.getArcadeAccount();
        this.balance = player.getArcadeAccount().getBalance();
        gambler.add(player);

    }

    @Override
    public void remove(PlayerInterface player) {
        gambler.get(0).getArcadeAccount().setBalance(this.balance);
        Casino c = new Casino(player);
        c.run();

    }

    @Override
    public void run() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(11) + 2;
        System.out.println("Random number is a secret");

        int counter = 0;

        while (true) {
            int playerGuess = console.getIntegerInput("Pick a number between 2 and 12: \n" +
                    "press 0 to leave");
            if (playerGuess == randomNumber) {
                System.out.println("Congratulations! You win!");
                System.out.println("It took you " + counter + " tries");

            } else {
                System.out.println("Nope, guess again!");
                counter++;
            } if (playerGuess ==0){
                remove(gambler.get(0));
            }
        }
    }


    @Override
    public void bet() {

    }

    @Override
    public void continueGambling() {

    }

    @Override
    public void lose() {

    }

    @Override
    public void outcome() {

    }

    @Override
    public void bonus() {

    }

    @Override
    public void enterGame() {

    }

    @Override
    public void kickout() {

    }

    @Override
    public void account() {

    }

    @Override
    public void moneyCheck() {

    }

    @Override
    public void music() {

    }
}

