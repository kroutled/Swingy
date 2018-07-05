package co.za.kroutled.controller;

import co.za.kroutled.model.Map;
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
                System.out.println("You have entered too many arguments");
            }
            else {
                String temp = args[0];
                String filename = args[1];
                System.out.println(temp);
                new Game(temp, filename);

            }
        }catch (Exception e)
        {
            System.out.println("No arguments have been passed");
        }
    }

    public Game(String args, String filename)
    {
        String  name;
        String  input;
        int     run = 1;

        Scanner     scan = new Scanner(System.in);
        Utilities   utils = new Utilities();
        Enemy       myEnemy = new Enemy();

        if (args.equalsIgnoreCase("Cli")) {
                System.out.println("Welcome to the world!");
                utils.sleep(1000);
                System.out.println("Please enter your name hero...");
                name = scan.nextLine();
                Hero myHero = new Hero(name);
                Map map = new Map(myHero);
                utils.sleep(1000);
                System.out.println("So you're " + myHero.getName() + ", I wonder...will you be the one to save our world?");

                runFight(myHero, myEnemy);

                while (run == 1) {

                    System.out.println("You can go: ");
                    System.out.println("NORTH: 'w'");
                    System.out.println("SOUTH: 's'");
                    System.out.println("EAST: 'd'");
                    System.out.println("WEST: 'a'");
                    System.out.println("EXIT: exit");

                    input = scan.nextLine();
                    switch (input)
                    {
                        case "w":
                            map.moveUp();
                            System.out.println(myHero.getY());
                            break;
                        case "s":
                            map.moveDown();
                            System.out.println(myHero.getY());
                            break;
                        case "a":
                            map.moveLeft();
                            System.out.println(myHero.getX());
                            break;
                        case "d":
                            map.moveRight();
                            System.out.println(myHero.getX());
                            break;
                        case "exit":
                            run = 0;
                            break;
                    }
                }

        }
        else if (args.equalsIgnoreCase("Gui")) {
            Window win = new Window();
            win.createWindow();
        }
        else
            System.out.println("Did you enter Gui or Cli?");
    }

    public void runFight(Hero hero, Enemy enemy)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fight or Run?: ");
        String  FoR = scan.nextLine();

        switch (FoR)
        {
            case "fight" :
                new Battle(hero, enemy);
                break;
            case "run" :
                System.out.print("You've run away!");
                break;
        }
    }

}
