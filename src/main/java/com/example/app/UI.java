package com.example.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class UI
{
    private JFrame window = new JFrame();
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    private JPanel gameTitlePanel = new JPanel();
    private JLabel gameTitleLabel = new JLabel("COOKIE-CLICKER");
    private JPanel gameTitleButtons = new JPanel();
    private JButton newGameButton = new JButton("NEW GAME");
    private JButton loadGameButton = new JButton("LOAD GAME");
    private JButton LeaderboardButton = new JButton("LEADERBOARD");
    private JButton exitButton = new JButton("EXIT");
    private JPanel cookiePanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    private JPanel powerupPanel = new JPanel();
    private JPanel descriptionPanel = new JPanel();
    private ImageIcon cookieImage = new ImageIcon("src/res/cookie.png");
    private JButton cookieButton = new JButton();
    private JLabel scoreLabel = new JLabel("Cookies: 0");
    private JButton firstPowerup = new JButton("Friend (10 left)");
    private JButton secondPowerup = new JButton("Employee (10 left)");
    private JButton thirdPowerup = new JButton("Cookie Machine (10 left)");
    private JButton fourthPowerup = new JButton("Factory (10 left)");
    private JTextArea descriptionText = new JTextArea();

    public void drawTitleScreen(){
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.setResizable(false);
        
        gameTitlePanel.setBounds(100, 100, 600, 500);
        gameTitlePanel.setBackground(Color.white);
        gameTitleLabel.setBackground(Color.black);
        gameTitleLabel.setFont(titleFont);
        gameTitlePanel.add(gameTitleLabel);

        gameTitleButtons.setBounds(300, 400, 200, 100);
        gameTitleButtons.setBackground(Color.white);
        gameTitleButtons.setLayout(new GridLayout(4, 1));
        window.add(gameTitleButtons);

        newGameButton.setBackground(Color.white);
        newGameButton.setForeground(Color.black);
        newGameButton.setFont(normalFont);
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showGameScreen();
            }
            
        });

        loadGameButton.setBackground(Color.white);
        loadGameButton.setForeground(Color.black);
        loadGameButton.setFont(normalFont);
        loadGameButton.setFocusPainted(false);

        LeaderboardButton.setBackground(Color.white);
        LeaderboardButton.setForeground(Color.black);
        LeaderboardButton.setFont(normalFont);
        LeaderboardButton.setFocusPainted(false);

        exitButton.setBackground(Color.white);
        exitButton.setForeground(Color.black);
        exitButton.setFont(normalFont);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });

        gameTitleButtons.add(newGameButton);
        gameTitleButtons.add(loadGameButton);
        gameTitleButtons.add(LeaderboardButton);
        gameTitleButtons.add(exitButton);
        window.add(gameTitlePanel);

        window.setVisible(true);
    }

    public void drawGameScreen(final Cookie cookie, final Powerup powerup){
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(null);
        window.setResizable(false);

        cookiePanel.setBounds(100, 220, 200, 200);
        cookiePanel.setBackground(Color.white);
        window.add(cookiePanel);

        cookieButton.setBackground(Color.white);
        cookieButton.setFocusPainted(false);
        cookieButton.setBorder(null);
        cookieButton.setIcon(cookieImage);
        cookiePanel.add(cookieButton);
        cookieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cookie.setCount(cookie.getCount()+1);
                scoreLabel.setText("Cookies:" + cookie.getCount());
            }
        });

        scorePanel.setBounds(100, 100, 200, 100);
        scorePanel.setBackground(Color.white);
        scorePanel.setLayout(new GridLayout(2, 1));
        window.add(scorePanel);

        powerupPanel.setBounds(500, 170, 250, 250);
        powerupPanel.setBackground(Color.white);
        window.add(powerupPanel);

        firstPowerup.setFocusPainted(false);
        powerupPanel.add(firstPowerup);
        firstPowerup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookie.getCount() >= 10 && powerup.getFirstPowerupCounter() < 10){
                    cookie.setCount(cookie.getCount()-10);
                    scoreLabel.setText("Cookies:" + cookie.getCount());
                    powerup.setPerSecond(powerup.getPerSecond()+0.1);
                    powerup.setFirstPowerupCounter(powerup.getFirstPowerupCounter()+1);
                    firstPowerup.setText("Friend (" + (10-powerup.getFirstPowerupCounter()) + " left)");
                    powerup.setTimer(cookie, scoreLabel);
                }
            }
        });

        firstPowerup.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                descriptionText.setText("Clicks for you every 10 seconds.\nCost: 10 cookies.");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                descriptionText.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}
        });

        secondPowerup.setFocusPainted(false);
        powerupPanel.add(secondPowerup);
        secondPowerup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookie.getCount() >= 100 && powerup.getSecondPowerupCounter() < 10){
                    cookie.setCount(cookie.getCount()-100);
                    scoreLabel.setText("Cookies:" + cookie.getCount());
                    powerup.setPerSecond(powerup.getPerSecond()+1.0);
                    powerup.setSecondPowerupCounter(powerup.getSecondPowerupCounter()+1);
                    secondPowerup.setText("Employee (" + (10-powerup.getSecondPowerupCounter()) + " left)");
                    powerup.setTimer(cookie, scoreLabel);
                }
            }
        });

        secondPowerup.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                descriptionText.setText("Clicks for you every second\nCost: 100 cookies");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                descriptionText.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}
        });

        thirdPowerup.setFocusPainted(false);
        powerupPanel.add(thirdPowerup);
        thirdPowerup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookie.getCount()>=1000 && powerup.getThirdPowerupCounter() < 10){
                    cookie.setCount(cookie.getCount()-1000);
                    scoreLabel.setText("Cookies:" + cookie.getCount());
                    powerup.setPerSecond(powerup.getPerSecond()+10.0);
                    powerup.setThirdPowerupCounter(powerup.getThirdPowerupCounter()+1);
                    thirdPowerup.setText("Cookie Machine (" + (10-powerup.getThirdPowerupCounter()) + " left)");
                    powerup.setTimer(cookie, scoreLabel);
                }
            }
        });
        
        thirdPowerup.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                descriptionText.setText("Clicks for you 10 times every second\nCost: 1000 cookies");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                descriptionText.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}
        });

        fourthPowerup.setFocusPainted(false);
        powerupPanel.add(fourthPowerup);
        fourthPowerup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookie.getCount()>=10000 && powerup.getFourthPowerupCounter() < 10){
                    cookie.setCount(cookie.getCount()-10000);
                    scoreLabel.setText("Cookies:" + cookie.getCount());
                    powerup.setPerSecond(powerup.getPerSecond()+50.0);
                    powerup.setFourthPowerupCounter(powerup.getFourthPowerupCounter()+1);
                    fourthPowerup.setText("Factory (" + (10-powerup.getFourthPowerupCounter()) + " left)");
                    powerup.setTimer(cookie, scoreLabel);
                }
            }
        });

        fourthPowerup.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {
                descriptionText.setText("Clicks for you 50 times every second.\nCost: 10000 cookies.");
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                descriptionText.setText(null);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {}

            @Override
            public void mouseReleased(MouseEvent arg0) {}
        });

        scoreLabel.setBackground(Color.white);
        scorePanel.add(scoreLabel);

        descriptionPanel.setBounds(500, 70, 250, 150);
        descriptionPanel.setBackground(Color.white);
        window.add(descriptionPanel);

        descriptionText.setBounds(500, 70, 250, 150);
        descriptionText.setForeground(Color.black);
        descriptionText.setBackground(Color.white);
        descriptionText.setLineWrap(true);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setEditable(false);
        descriptionPanel.add(descriptionText);

        window.setVisible(true);

    }

    public void showTitleScreen(){
        gameTitlePanel.setVisible(true);
        gameTitleButtons.setVisible(true); 

        cookiePanel.setVisible(false);
        scorePanel.setVisible(false);
        powerupPanel.setVisible(false);
        descriptionPanel.setVisible(false);
    }

    public void showGameScreen(){
        cookiePanel.setVisible(true);
        scorePanel.setVisible(true);
        powerupPanel.setVisible(true);
        descriptionPanel.setVisible(true);

        gameTitlePanel.setVisible(false);
        gameTitleButtons.setVisible(false); 
    }
}
