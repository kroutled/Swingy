package main.java.kroutled.controller;

import main.java.kroutled.model.Hero;
import java.util.Scanner;

public class Game {

    public static void main(String args[])
    {
        new Game();
    }

    public Game()
    {
        String name;
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to the world!");
        dos(1000);
        System.out.println("Please enter your name hero...");
        name = scan.nextLine();
        Hero myHero = new Hero(name);
        dos(800);
        System.out.println("So you're " + myHero.getName() + ", I wonder...will you be the one to save our world?");
        System.out.println("Now tell me " + myHero.getName() + );
    }

    public void dos(long time)
    {
        try
        {
         Thread.sleep(time);
        } catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}
