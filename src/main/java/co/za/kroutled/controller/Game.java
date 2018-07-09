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
        }
        catch (Exception e)
        {
            System.out.println("No arguments have been passed");
        }
    }

    public Game(String args, String filename)
    {
        String  name;
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
                map.setHeroPos();
                map.enemyFarm();
                map.callEnemy();
                utils.sleep(1000);
                System.out.println("So you're " + myHero.getName() + ", I wonder...will you be the one to save our world?");

                while (move(map, scan) != -1)
                {
                    map.checkCollision(myHero);
                    map.callEnemy();
                    System.out.printf("hx:%d, y:%d\n", myHero.getXPos(), myHero.getYPos());
                    if (myHero.getHp() == 0)
                    {
                        System.out.println("You've Died :(");
                        break;
                    }
                    if (map.inMap() == false)
                    {
                        break;
                    }
                        //map.newLevel();
                }
        }
        else if (args.equalsIgnoreCase("Gui")) {
            Window win = new Window();
            win.createWindow();
        }
        else
            System.out.println("Did you enter Gui or Cli?");
    }

    public int move( Map map , Scanner scan)
    {
        Hero myHero = map.getHero();
        System.out.println("You can go: ");
        System.out.println("NORTH: 'w'");
        System.out.println("SOUTH: 's'");
        System.out.println("EAST: 'd'");
        System.out.println("WEST: 'a'");
        System.out.println("EXIT: exit");

        String input = scan.nextLine();
        switch (input)
        {
            case "w":
                map.moveUp();
                break;
            case "s":
                map.moveDown();
                break;
            case "a":
                map.moveLeft();
                break;
            case "d":
                map.moveRight();
                break;
            case "stat":
                System.out.println("Name: " + myHero.getName());
                System.out.println("Health: " + myHero.getHp() + "/" + myHero.getMaxHp());
                System.out.println("Level: " + myHero.getLvl());
                System.out.println("XP: " + myHero.getXp() + "/" + myHero.neededXP);
                System.out.println("Attack: " + myHero.getAttack());
                System.out.println("Defense: " + myHero.getDefense());
                break;
            case "exit":
                return - 1;
            default:
                System.out.println("Invalid input");
        }
        return 0;
    }
}
