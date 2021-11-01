/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author A
 */
public class Player implements Runnable {



    private final String text;
    private final Lock lock;
    private final Condition myTurn;
    private Condition nextTurn;
    private Player nextPlayer;
    private volatile boolean play = false;



    public Player(String text,Lock lock) {
        this.text = text;
        this.lock = lock;
        this.myTurn = lock.newCondition();
    }

    @Override
    public void run() {
        while(!Thread.interrupted()) {
            lock.lock();
            try {
                while (!play)
                    myTurn.awaitUninterruptibly();
                System.out.println(text);
                this.play = false;
                nextPlayer.play = true;
                nextTurn.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
        this.nextTurn = nextPlayer.myTurn;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }
}