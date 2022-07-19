package com.github.zipcodewilmington.casino.games.PracticeGamesAndPlayerClasses;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.roulette.BallNumberGenerator;
import com.github.zipcodewilmington.casino.games.roulette.RouletteBall;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RouletteGamePractice extends BallNumberGenerator implements GameInterface {

    private Integer balance;
    private List<PlayerInterface> gambler = new ArrayList<>();

        @Override
        public void add(PlayerInterface player) {
            this.balance = player.getArcadeAccount().getBalance();
            System.out.println("Your balance is " + this.balance);
            gambler.add(player);

        }

        @Override
        public void remove(PlayerInterface player) {
            Casino c = new Casino(player);
            c.run();

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

    Scanner input = new Scanner(System.in);
    int bet;
    int betOption;

    int selectNumber;

    int money = 1000;
    int roundCounter = 1;


    private final IOConsole console = new IOConsole(AnsiColor.RED);

    public LinkedList<RoulettePlayer> roulettePlayers = new LinkedList<>();


    @Override
    public void run() /*throws NumberFormatException*/ {

        printSummary();


        while (balance > 0) {

            bet = console.getIntegerInput("Please input the amount you desire to bet.");

            betOption = console.getIntegerInput("Please select bet option");

            if(bet == 0 && betOption != 0) {
                bet = console.getIntegerInput("INVALID! Please input the amount you desire to bet.");
                betOption = console.getIntegerInput("Please select bet option");
            }
//            if (bet == 38){
//
//            }

            if(betOption == 5){
                selectNumber = console.getIntegerInput("Please select a number 00 or 0 - 36");
            }

            RouletteBall ball;
            ball = this.generator();
            winningMethod(bet, ball, selectNumber);
            printHelp();

            console.print("Results: " + ball.getColor());

            console.print("Your bank account: " + balance + "\n");
            roundCounter++;

            console.print("Rounds: " + roundCounter + "\n");

            if (balance <= 0)
                break;
            if(bet == 0 && betOption != 0)
                break;
        }

    }


    public void printSummary() {
        System.out.println("Welcome to Roulette!");
        System.out.println("Below is the pay out of your desired option.");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Bet              | Payout          | Probability   |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [1]Red           | 1 : 1           | ~47.6%        |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [2]Black         | 1 : 1           | ~47.3%        |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [3]Odd           | 1 : 1           | ~47.3%        |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [4]Even          | 1 : 1           | ~47.3%        |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [5]Single number | 35 : 1          | ~2.6%         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [6]First Twelve  | 2 : 1           | ~31.5         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [7]Second Twelve | 2 : 1           | ~31.5         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [8]Third Twelve  | 2 : 1           | ~31.5         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [9]  No. 1 - 18  | 1 : 1           | ~31.5         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [10] No. 19 - 36 | 1 : 1           | ~31.5         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| [0] Insert 0 [help] for further assistance         |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("                                                      ");
        System.out.println("Please decide how much you want to bet and chose bet. ");
        System.out.println("                                                      ");
    }

    public void printHelp() {
        if (betOption == 0 && bet == 0) {
            System.out.println("Here is the help desk.");
            System.out.println("Below is the pay out of your desired option.");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| Bet              | Payout          | Probability   |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [1]Red           | 1 : 1           | ~47.6%        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [2]Black         | 1 : 1           | ~47.3%        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [3]Odd           | 1 : 1           | ~47.3%        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [4]Even          | 1 : 1           | ~47.3%        |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [5]Single number | 35 : 1          | ~2.6%         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [6]First Twelve  | 2 : 1           | ~31.5         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [7]Second Twelve | 2 : 1           | ~31.5         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [8]Third Twelve  | 2 : 1           | ~31.5         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [9]  No. 1 - 18  | 1 : 1           | ~31.5         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [10] No. 19 - 36 | 1 : 1           | ~31.5         |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("| [0] Type 0 [ for help] in both inputs              |");
            System.out.println("+----------------------------------------------------+");
            System.out.println("                                                      ");
            System.out.println("Please decide how much you want to bet and chose bet. ");
            System.out.println("                                                      ");
        }
    }

    public void winningMethod(int bet, RouletteBall ball, int selectNumber) {

        //Bet is red and receive a 1 : 1 payout.
        if (betOption == 1 && ball.getNumber() % 2 != 0) this.money+=bet;
            //Bet is black and receive a 1 : 1 payout.
        else if (betOption == 2 && ball.getNumber() % 2 == 0) this.money+=bet;
            //Bet is odd and receive a 1 : 1 payout.
        else if (betOption == 3 && ball.getNumber() % 2 != 0) this.money+=bet;
            //Bet is even and receive a 1 : 1 payout.
        else if (betOption == 4 && ball.getNumber() % 2 == 0) this.money+=bet;
            //Bet is Single Number and receive a 35 : 1 payout.
        else if (betOption == 5 && ball.getNumber() == selectNumber) money += bet * 35;
            //Bet is First Twelve and receive a 2 : 1 payout.
        else if (betOption == 6 && ball.getNumber() >= 1 && ball.getNumber() <= 12) money += bet * 2;
            //Bet is Second Twelve and receive a 2 : 1 payout.
        else if (betOption == 7 && ball.getNumber() >= 13 && ball.getNumber() <= 24) money += bet * 2;
            //Bet is Third Twelve and receive a 2 : 1 payout.
        else if (betOption == 8 && ball.getNumber() >= 25 && ball.getNumber() <= 36) money += bet * 2;
            //Bet is No. 1 - 18 and receive a 1 : 1 payout.
        else if (betOption == 9 && ball.getNumber() >= 1 && ball.getNumber() <= 18) money += bet;
            //Bet is No. 19 - 36 and receive a 1 : 1 payout.
        else if (betOption == 10 && ball.getNumber() >= 19 && ball.getNumber() <= 36) money += bet;
            //Lose bet
        else money -= bet;
    }
}
