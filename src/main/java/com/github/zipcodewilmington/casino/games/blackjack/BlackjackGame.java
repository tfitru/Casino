package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.card.Card;
import com.github.zipcodewilmington.casino.games.card.Hand;
import com.github.zipcodewilmington.casino.games.card.Rank;
import com.github.zipcodewilmington.casino.games.card.Shoe;
import com.github.zipcodewilmington.casino.games.card.deck.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.LinkedList;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.games.card.Suit.SPADE;

public class BlackjackGame extends Deck implements GameInterface {

    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_Blue = "\u001b[34m";
    private Hand dealersHand = new Hand();
    private Hand playerHand = new Hand();
    private Shoe shoe = new Shoe();
    private Boolean isRunning = false;
    private Boolean dealerDefaultWin = false;
    private Boolean dealersTurn = false;
    private Boolean stillPlaying = false;

    private final IOConsole console = new IOConsole(AnsiColor.AUTO);
    public BlackjackPlayer blackjackPlayer;
    private boolean dealerWin;
    private int balance = 0;


    public void add(PlayerInterface player) {
        this.blackjackPlayer = (BlackjackPlayer) player;
        player.getArcadeAccount();
        this.blackjackPlayer.casinoAccount.setBalance(player.getArcadeAccount().getBalance());
    }

    public void run(){
        this.initializeNewGame();
        while(isRunning){
            blackjackPlayer.setBet();
            this.dealHands();
            checkDealerWinDefault();
            this.playerTurn(); //<--- this would basically become 'player turn'
            this.checkDealer(); //<---  essentially becomes 'dealer turn'
            this.checkWinner();
            this.confirmNextHand();
        }
    }

//    public void  oldrun(){
//        this.initializeNewGame();
//        while (stillPlaying){
////            this.blackjackPlayer.setBet();
//            blackjackPlayer.setBet();
//            this.dealHands();
//            checkDealerWinDefault();
//            while(this.isRunning){
//                System.out.println(ANSI_YELLOW  + "Successfully started game");
////                blackjackPlayer.setBet();
//                this.advanceTurn();
////                checkDealerWinDefault();
//
//
////                this.advanceTurn();
//            }
//            this.checkWinner();
//            this.confirmNextHand();
//        }
//    }

    private void confirmNextHand(){
        Integer answer = this.console.getIntegerInput("1) Continue\n2) Leave");
        this.stillPlaying = answer == 1;
        this.isRunning = this.stillPlaying;
    }

    private void playerTurn(){
        Integer userInput = 0;
        while(userInput != 2 && this.isRunning){
            console.println(ANSI_Blue + "Player's Turn. Current Hand:");
            System.out.println(ANSI_Blue + this.playerHand.toString());
            System.out.println(ANSI_Blue + "Hand value: " + playerHand.getHandSum() + "\n");
            userInput = this.console.getIntegerInput("Please enter your choice\n1: Hit\n2: Stand");
            if(userInput == 1){
                this.playerHand.addCard(shoe.drawNext());
                System.out.println("Added card");

                this.busted();
            } else if (userInput == 2) {
                this.dealersTurn = true;
                console.println(ANSI_RED + "Dealers Turn. Current Hand:");
                System.out.println(ANSI_RED + this.dealersHand.toString());
                System.out.println(ANSI_RED + "Dealer has: " + this.dealersHand.getHandSum());
                this.checkDealer();
                System.out.println("-------End of round-----");

            }
        }
    }

////    private void advanceTurn() {
////
////        if(this.dealersTurn){
////
////            System.out.println(this.dealersHand.toString());
////            this.checkDealer();
////        } else {
////            //player's code
////            Integer userInput = 0;
////            while(userInput != 2 && this.isRunning){
////                console.println(ANSI_Blue + "Player's Turn. Current Hand:");
////                System.out.println(ANSI_Blue + this.playerHand.toString());
////                System.out.println(ANSI_Blue + "Hand value: " + playerHand.getHandSum() + "\n");
////                userInput = this.console.getIntegerInput("Please enter your choice\n1: Hit\n2: Stand");
////                if(userInput == 1){
////                    this.playerHand.addCard(shoe.drawNext());
////                    System.out.println("Added card");
////
////                    this.busted();
////                } else if (userInput == 2) {
//////                    System.out.println("_______Player = 2--------");
////                    this.dealersTurn = true;
////                    console.println(ANSI_RED + "Dealers Turn. Current Hand:");
////                    System.out.println(ANSI_RED + this.dealersHand.toString());
//////                    System.out.println("-----___display dealer hand__ just ran-----");
////                    System.out.println(ANSI_RED + "Dealer has: " + this.dealersHand.getHandSum());
////                    this.checkDealer();
////                    System.out.println("-------End of round-----");
////                    this.isRunning = false;
////                }
////            }
////        }
//
//        this.dealersTurn = !this.dealersTurn;
////        this.isRunning = !this.checkDealerWinDefault();
//    }



    public void initializeNewGame() {
        this.initializeHands();
        this.isRunning = true;
        this.stillPlaying = true;
//        this.isRunning = !this.checkDealerWinDefault();

    }

    private Boolean checkDealerWinDefault() {
        Boolean dealerDefaultWin = false;

        if(this.dealersHand.getCards().get(0).getRank().getRankName().equals("Ace")){
            dealerDefaultWin = this.dealersHand.getCards().get(1).getRank().getRankValue() == 10;
        }
        this.dealerDefaultWin = dealerDefaultWin;
        return dealerDefaultWin;
    }

    private void dealHands() {
        System.out.println("Hitting dealInitial Hands");
        this.playerHand.emptyHand();
        this.dealersHand.emptyHand();

        this.playerHand.addCard(shoe.drawNext());
        this.dealersHand.addCard(shoe.drawNext());
        this.playerHand.addCard(shoe.drawNext());
        this.dealersHand.addCard(shoe.drawNext());
//        this.dealersHand.getCards().get(1).setFaceUp(true);
    }

    public void initializeHands() {
        this.dealersHand = new Hand();
        this.playerHand = new Hand();
    }

    public void busted() {
        if (this.playerHand.getHandSum() > 21) {
            System.out.println("You went over 21, and lost your bet of...-----players current bet---- ");
            System.out.println("You now have...-----acoount balance------");
            System.out.println(this.playerHand.toString());
        }
    }


    public String printEndingMessage() {
        return "Game Over";
    }

    public void blackjack(){
    }

    public void checkWinner(){
        int winner;
        if(this.dealerDefaultWin) {
            System.out.println(ANSI_Blue + this.playerHand.toString());
            System.out.println(ANSI_RED + this.dealersHand.toString());
            //Pay the player and tell them
            System.out.println("Dealer won by 1 default");
            this.loseMoney(blackjackPlayer.currentBet);
        } else if(playerHand.getHandSum() > dealersHand.getHandSum() && playerHand.getHandSum() <= 21){
            System.out.println( "Player1 wins");
            this.winMoney(blackjackPlayer.currentBet);
        } else if (playerHand.getHandSum() == dealersHand.getHandSum()){
            System.out.println("tie");
            // player keeps his current bet
            //no money is deducted from players account
        } else if (dealersHand.getHandSum() > playerHand.getHandSum() && dealersHand.getHandSum() <= 21) {
            System.out.println("Dealer wins");
            this.loseMoney(blackjackPlayer.currentBet);
        }

    }

    public void checkDealer() {
        Boolean check = true;
        while (check) {
            if (dealersHand.getHandSum() < 17) {
                System.out.println(ANSI_RED + "------HAND IS LESS THAN 17-------\n");
                System.out.println(ANSI_RED + "dealer must hit");
                dealersHand.addCard(shoe.drawNext());
                System.out.println(dealersHand.toString());
            } else if (dealersHand.getHandSum() <= 21 && dealersHand.getHandSum() >= 17 && dealersHand.getHandSum() > playerHand.getHandSum()) {
//                this.loseMoney(blackjackPlayer.currentBet);
                System.out.println(ANSI_RED + "Dealer has " + dealersHand.getHandSum());
                check = false;
            } else if (dealersHand.getHandSum() == playerHand.getHandSum()) {
                System.out.println("Tie");
                check = false;
            } else if (dealersHand.getHandSum() > 21) {
                System.out.println(ANSI_RED + " Dealer busted!!");
//                this.winMoney(blackjackPlayer.currentBet);
                check = false;
            }
        }
    }

    public void loseMoney(Integer bet) {
        this.blackjackPlayer.casinoAccount.setBalance(this.blackjackPlayer.casinoAccount.getBalance() - bet);
    }

    public void winMoney(Integer winnings){
        this.blackjackPlayer.casinoAccount.setBalance(this.blackjackPlayer.casinoAccount.getBalance() + winnings);
    }




    public void win(PlayerInterface player, int winnings){
//        if(playerHand.getHandSum() < dealersHand.getHandSum())

    }
    //       //collect player winnings
//        //add to account
//    }
    public void losings(PlayerInterface player, int losings){

    }
    //collect losings
    //deduct from account


    public Shoe getShoe() {
        return null;

    }




//



    public String toString() {
        return null;
    }

}