package co.za.kroutled.controller;

import co.za.kroutled.model.characters.*;
import co.za.kroutled.view.Window;
import java.util.Scanner;
import java.io.*;

public class Game {

    public static void main(String args[]) throws Exception
    {
        try
        {
            if (args.length > 2)
            {
                System.out.println("Nahh");
            }
            else {
                String temp = args[0];
                String filename = args[1];
                System.out.println(temp);
                new Game(temp, filename);

            }
        }catch (Exception e)
        {
            System.out.println("No arguments passed");
        }
    }

    public Game(String args, String filename)
    {
        String name;
        String gameType;
        Scanner scan = new Scanner(System.in);


        //System.out.println("Console or Gui");
        //gameType = scan.nextLine();
        //System.out.println(gameType);
        System.out.println("Hello: " + filename);

        if (args.equalsIgnoreCase("Console")) {
            System.out.println("Welcome to the world!");
            dos(1000);
            System.out.println("Please enter your name hero...");
            name = scan.nextLine();
            Hero myHero = new Hero(name);
            dos(800);
            System.out.println("So you're " + myHero.getName() + ", I wonder...will you be the one to save our world?");
            System.out.println("Now tell me " + myHero.getName() + ", do you have any skills");
        }
        else if (args.equalsIgnoreCase("Gui")) {
            Window win = new Window();
            win.createWindow();
        }
        else
            System.out.println("Did you enter Gui or Console?");
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
