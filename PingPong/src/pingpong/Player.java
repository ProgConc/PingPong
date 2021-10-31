/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

/**
 *
 * @author A
 */
public class Player {



    private final String text;



    private int turns = Game.MAX_TURNS;



    private Player nextPlayer;



    public Player(String text) {

        this.text = text;

    }



    public void play() {

        if (!gameFinished()) {

            System.out.println(text);

            turns--;

            nextPlayer.play();

        }

    }



    private boolean gameFinished() {

        return turns == 0;

    }



    public void setNextPlayer(Player nextPlayer) {

        this.nextPlayer = nextPlayer;

    }



}