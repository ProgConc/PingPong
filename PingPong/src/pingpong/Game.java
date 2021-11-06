/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author A
 */

public class Game {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Player player1 = new Player("ping", lock);
        Player player2 = new Player("pong", lock);
        player1.setNextPlayer(player2);
        player2.setNextPlayer(player1);

        System.out.println("Game starting...!");

        player1.setPlay(true);
        ExecutorService executor = Executors.newFixedThreadPool(2);



executor.execute(player1);

executor.execute(player2);



sleep(2);



executor.shutdownNow();



try {

    executor.awaitTermination(5, TimeUnit.SECONDS);

} catch (InterruptedException e) {

    System.out.println("Main thread interrupted while waiting for players to finish");

}



System.out.println("Game finished!");
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}