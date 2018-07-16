package co.za.kroutled.controller;

import co.za.kroutled.model.Map;
import co.za.kroutled.model.characters.*;
import co.za.kroutled.view.Window;
import co.za.kroutled.Utilities.*;

import java.util.List;
import java.util.Scanner;

public class Game {

    Print       utils = new Print();

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
        Reader reader = new Reader();
        String  name;
        int     type;

        Scanner     scan = new Scanner(System.in);
        Hero myHero = new Hero();

        if (args.equalsIgnoreCase("Cli")) {
                System.out.println("Welcome to the world!");
                utils.sleep(1000);
                System.out.println("Please enter your name hero...");
                name = scan.nextLine();
                utils.printClasses();
                type = scan.nextInt();
                scan = new Scanner(System.in);
                myHero = classSelect(type, name);
                Map map = new Map(myHero);
                map.newLevel(myHero);
                utils.sleep(600);
                System.out.println("So you're " + myHero.getName() + " the " + myHero.getType() +", I wonder...will you be the one to save our world?");

                while (move(map, scan) != -1)
                {
                    System.out.printf("Position x:%d, y:%d\n", myHero.getXPos(), myHero.getYPos());
                    map.checkCollision(myHero);

                    if (myHero.getHp() == 0)
                    {
                        System.out.println("You've Died :(");
                        break;
                    }
                    if (map.inMap() == false)
                    {
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

    public int move( Map map , Scanner scan)
    {
        Hero myHero = map.getHero();
        utils.printDirections();

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
                utils.printStats(myHero);
                break;
            case "hint":
                map.hint();
                break;
            case "exit":
                return - 1;
            default:
                System.out.println("Invalid input");
        }
        return 0;
    }

    public Hero classSelect(int type, String name)
    {
        switch (type) {
            case 1 :
                return new Druid(name);
            case 2:
                return new Mage(name);
            case 3:
                return new Warrior(name);
        }
        return new Hero(name);
    }
}
