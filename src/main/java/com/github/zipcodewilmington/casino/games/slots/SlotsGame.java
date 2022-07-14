package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.LinkedList;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    public LinkedList<SlotsPlayer> slotPlayers = new LinkedList<>();
    @Override
    public void add(PlayerInterface player) {
        slotPlayers.add((SlotsPlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {
        slotPlayers.remove((SlotsPlayer) player);
    }

    @Override
    public void run() {
        slots();
        //do you want to play again?

    }

    public void slots() {
        for(PlayerInterface player : slotPlayers) {

            if (this.setBet() == 1) continue;
            else System.out.println("Get out of my casino");

            String result = getResult(Lever.PullLever());
            if (result == "bingo") win(player, 500);
            if (result == "bango") win(player, 100);
            if (result == "bongo") lose(player);
        }

    }

    public String getResult(int[] pulled) {
        if (pulled[0] == pulled[1] && pulled[0] == pulled[2]) return "bingo";
        else if (pulled[0] == pulled[1] || pulled[1] == pulled[2]) return "bango";
        else return "bongo";
    }

    public int setBet() {
        String input = console.getStringInput("Input $1 to play!");
        if (input.equals("1")) return 1;
        else return 0;
    }

    public void win(PlayerInterface player, int winnings) {
//        somehow need to also make this method update the account balance of the current player
//        remove(player);   dont do this
    }

    public void lose(PlayerInterface player) {
//        somehow need to also make this method update the account balance of the current player
//        remove(player);  dont do this
    }
}
