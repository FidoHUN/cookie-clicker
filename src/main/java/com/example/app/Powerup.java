package com.example.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Powerup{
    private double perSecond;
    private int firstPowerupCounter;
    private int secondPowerupCounter;
    private int thirdPowerupCounter;
    private int fourthPowerupCounter;

    public Powerup(){
        perSecond = 0.0;
        firstPowerupCounter = 0;
        secondPowerupCounter = 0;
        thirdPowerupCounter = 0;
        fourthPowerupCounter = 0;
    }

    public double getPerSecond() {
        return perSecond;
    }

    public int getFirstPowerupCounter() {
        return firstPowerupCounter;
    }

    public int getSecondPowerupCounter() {
        return secondPowerupCounter;
    }

    public int getThirdPowerupCounter() {
        return thirdPowerupCounter;
    }

    public int getFourthPowerupCounter() {
        return fourthPowerupCounter;
    }

    public void setPerSecond(final double perSecond) {
        this.perSecond = perSecond;
    }

    public void setFirstPowerupCounter(int firstPowerupCounter) {
        this.firstPowerupCounter = firstPowerupCounter;
    }

    public void setSecondPowerupCounter(int secondPowerupCounter) {
        this.secondPowerupCounter = secondPowerupCounter;
    }

    public void setThirdPowerupCounter(int thirdPowerupCounter) {
        this.thirdPowerupCounter = thirdPowerupCounter;
    }

    public void setFourthPowerupCounter(int fourthPowerupCounter) {
        this.fourthPowerupCounter = fourthPowerupCounter;
    }

    public void setTimer(final Cookie cookie, final JLabel scoreLabel){
        int value = (int) Math.round(1/perSecond*1000);
        System.out.println(value);
        System.out.println(perSecond);
        final Timer timer = new Timer(value, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cookie.setCount(cookie.getCount()+1);
                scoreLabel.setText("Cookies " + cookie.getCount());
            }

        });
        timer.start();
    }

}
