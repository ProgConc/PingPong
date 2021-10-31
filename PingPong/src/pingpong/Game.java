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
public class Game {



    public static final int MAX_TURNS = 10;



    public static void main(String[] args) {



        Player player1 = new Player("ping");

        Player player2 = new Player("pong");



        player1.setNextPlayer(player2);

        player2.setNextPlayer(player1);



        System.out.println("Game starting...!");



        player1.setMustPlay(true);



        Thread thread2 = new Thread(player2);

        thread2.start();

        Thread thread1 = new Thread(player1);

        thread1.start();



        System.out.println("Game finished!");

    }



}