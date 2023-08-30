package com.example.app;

public class App 
{
    public static void main( String[] args )
    {
        UI ui = new UI();

        ui.drawTitleScreen();
        ui.drawInputScreen();
        ui.drawGameScreen();
        
        ui.showTitleScreen();
    }
}
