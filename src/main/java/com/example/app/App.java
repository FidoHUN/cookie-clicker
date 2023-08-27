package com.example.app;

public class App 
{
    public static void main( String[] args )
    {
        Cookie cookie = new Cookie();
        Powerup powerup = new Powerup();
        UI ui = new UI();
        ui.drawTitleScreen();
        ui.drawGameScreen(cookie, powerup);
        ui.showTitleScreen();
    }
}
