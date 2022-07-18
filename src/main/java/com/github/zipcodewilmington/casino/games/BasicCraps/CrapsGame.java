package com.github.zipcodewilmington.casino.games.BasicCraps;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class CrapsGame extends RandomPlayerBots implements GamblerGameInterface{



    private final IOConsole console = new IOConsole(AnsiColor.GREEN);

    protected boolean win;

    Integer balance = 150;

    private List<PlayerInterface> gambler;

//    public static void main(String[] args) {
//        new CrapsGame().run();
//    }

    DiceGenerator diceGenerator = new DiceGenerator() {
        @Override
        public Integer diceRoll() {
            return super.diceRoll();
        }
    };

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

    public void run() {
        boolean quit = true;
        while (quit) {
            Integer playerBet = console.getIntegerInput("Enter your bet, minimum bet $500");
            // Ask the player for the bet and all the bots make there bets
            // Bets will match the players bet
            // Ask player to guess the number for dice sum
            // if the result is 7 or 11, shooter and other players who sided with shooter will win
                // Win method()
            // if the result is 2,3,12 shooter and other players in favour of shooter lose
                // Lose method()
            // A point is made if number other than ones mentioned above is rolled
                // ArrayList to hold the point roll
            // Dice rolls again and this time shooter has to match point number without rolling 7
            // if shooter roll matches the ArrayList value
            // Win method()
            // Shooter loses when he rolls a 7 before hitting the point
            // Lose method()
            // If point is rolled shooter wins
            Integer playerBet1 = console.getIntegerInput("Press 1 for Pass \n" +
                    "or 2 for Don't Pass");
            //If player chooses pass, choose the number value you think it will land on
            // if player is correct,
            //
            boolean playerBetUptake = true;

            if(playerBet>=500) {

            } else {
                while(playerBetUptake){
                    Integer playerBetUpdate = console.getIntegerInput("Bet needs to be higher than that G\n" +
                            "Whats your bet?");
                    if(playerBetUpdate>=500){
                        playerBetUptake=false;
                    }
                }
            }
            String playerChoice = console.getStringInput("Enter 1 to throw the dice?");
            if (playerChoice.equalsIgnoreCase("1")) {
                int point = this.diceGenerator.diceRoll();
                System.out.println(point);
                if (point == 7 || point == 11) {
                    win = true;
                    this.balance+=500;
                    System.out.println(balance);
                } else if (point == 2 || point == 3 || point == 12) {
                    win = false;
                } else {
                    int nextRoll = diceGenerator.diceRoll();
                    while (nextRoll != 7) {
                        if (nextRoll == point) {
                            win = true;
                        }
                        nextRoll = diceGenerator.diceRoll();
                    }
                    win = false;
                }
                System.out.println(win);
            } else if(playerChoice.equalsIgnoreCase("quit")){
                quit = false;
            }
        }
    }

    @Override
    public void setBet() {


    }

    public Integer poolBets(Integer balance, Integer balanceFromOthers) {

        return null;
    }


    public void win() {
        System.out.println("Player wins");
//        this.balance+=winnings;
    }





        // Need a die
        // Need to sum the  dice total
        // Need player input of being the pass
        // line(7 or 11) or lose by landing on
        // 2,3 or 12

        // Dealer takes all pass bets and
        // add them to craps table

        // Once a point is set on the craps' table
        // Craps players can bet on the dice
        // landing the point
        // landing on different numbers
        // or losing completely by landing on 7


        // Shooter starts the craps game
        // with first roll of the dice
        // known as the come out roll

        // Shooter rolls the dice until they
        // land a 7 or the point


        // If the dice land on 7 or 11, pass
        // line bettors with their wager
        // If the dice lands on 2,3 or 12
        // don't pass bettors win

        // Any other numbers the dice land
        // on establishes a point on the craps
        // table, and the game continues

        // if the shooter lands the point,
        // they remain as the shooter in
        // next craps game
        // if they roll a 7, shooter sevens
        // out and a new craps player
        // becomes the shooter






}
