package co.za.kroutled.controller;

import co.za.kroutled.model.artefacts.*;
import co.za.kroutled.model.characters.Enemy;
import co.za.kroutled.model.characters.Hero;

import java.util.Random;
import java.util.Scanner;

public class Battle {

    public Battle () {}

    public int fightCheck(Hero hero, Enemy enemy)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fight or Run?: ");
        String  FoR = scan.nextLine();

        if (FoR.equalsIgnoreCase("fight"))
        {
            return 1;
        }
        else if (FoR.equalsIgnoreCase("run"))
        {
            return -1;
        }
        System.out.println("Theres no time for that!");
        return 0;
    }

     public int fight (Hero hero, Enemy enemy)
     {
         Utilities   utils = new Utilities();
         Random rand = new Random();

         String      moves[] = {"knock", "slam", "wallop", "attack", "poes klap"};
         while (hero.getHp() > 0 && enemy.getHp() > 0)
         {
             //run = enemy attacks first vs fight = you attack first
             int heroDmg = hero.getAttack() - enemy.getDefense();
             int enemyDmg = enemy.getAttack() - hero.getDefense();
             System.out.println("You " + moves[rand.nextInt(5)] + " the enemy " + enemy.getName() + " and deal " + heroDmg);
             enemy.takeDmg(heroDmg);
             utils.sleep(1000);
             if (enemy.getHp() == 0)
                 break;
             System.out.println("The enemy " + enemy.getName() + " " + moves[rand.nextInt(5)] + "s you! You have taken " + enemyDmg);
             hero.takeDmg(enemyDmg);
             utils.sleep(1000);
             System.out.println(hero.getName() + ":" + hero.getHp() + " VS " + enemy.getName() + ":" + enemy.getHp());
         }

         if (enemy.getHp() == 0)
         {
             int xpGained = (enemy.getMaxHp() * enemy.getAttack()) + 20;
             int     lvledUp = hero.setXp(xpGained);

             dropArtefact(hero);
             if (lvledUp == 1)
             {
                 System.out.println("You defeated the enemy and gained " + xpGained + "!");
                 System.out.println("Congratulations!!!! You have leveled up to level " + hero.getLvl());
                 return 1;
             }
             else
             {
                 System.out.println("You defeated the enemy and gained " + xpGained + "!");
                 return 0;
             }
         }
         return -1;
     }

     public int run ()
     {
         Random rand = new Random();
         int chance = rand.nextInt(100);

         if (chance >= 50)
         {
             System.out.println("You get away!");
             return 1;
         }
         else
             return -1;
     }

     public void dropArtefact (Hero hero)
     {
         Random rand = new Random();
         int    dropChance = rand.nextInt(10);
         if (dropChance > 1 && dropChance < 5)
         {
             Artefact[] artefacts = {new Weapon(hero.getLvl()), new Armor(hero.getLvl()), new Helm(hero.getLvl())};
             Artefact foundArtefact = artefacts[dropChance - 2];
             System.out.println("It appears that a " + foundArtefact.getName() + " has dropepd!");
             String boost = "";
             switch(foundArtefact.getType())
             {
                 case "helm":
                     boost = "hit points";
                     break;
                 case "armor":
                     boost = "defense";
                     break;
                 case "weapon":
                     boost = "attack";
                     break;
             }
             System.out.println("It adds " + foundArtefact.getBoost() + " " + boost);
             if (artefactCheck() == true)
             {
                 equipArtefact(hero, foundArtefact);
             }

         }

     }

     public boolean artefactCheck()
     {
         Scanner scan = new Scanner(System.in);
         System.out.println("Do you want to equip? y/n");
         String input =  scan.nextLine();
        if (input.equalsIgnoreCase("Y"))
            return true;
        else
            return false;
     }

     public void equipArtefact(Hero hero, Artefact artefact)
     {
         switch(artefact.getType())
         {
             case "helm":
                 hero.setHelm((Helm)artefact);
                 break;
             case "armor":
                 hero.setArmor((Armor)artefact);
                 break;
             case "weapon":
                 hero.setWeapon((Weapon)artefact);
                 break;
         }
     }
//         String equip;
//         Scanner scan = new Scanner(System.in);
//         Random rand = new Random();
//         Helm helm = new Helm();
//         Armor armor = new Armor();
//         Weapon weapon = new Weapon();
//
//         int dropChance = rand.nextInt(10);
//
//         if (dropChance >= 3) {
//             System.out.println("Wow 11the enemy dropped something!");
//             if (chance == 1) {
//                 //helm
//                 System.out.println("");
//                 System.out.println("It appears to be a helm, would you like to equip this helm?");
//                 equip = scan.nextLine();
//                 if (equip.equalsIgnoreCase("Yes")) {
//                     hero.setHelm(helm);
//                 }
//             }
//             if (chance == 2) {
//                 //armor
//                 System.out.println("It appears to be armor, would you like to equip this armor?");
//                 equip = scan.nextLine();
//                 if (equip.equalsIgnoreCase("Yes")) {
//                     hero.setArmor(armor);
//                 }
//             }
//             if (chance == 3) {
//                 //weapon
//                 System.out.println("It appears to be a weapon, would you like to equip this weapon?");
//                 equip = scan.nextLine();
//                 if (equip.equalsIgnoreCase("Yes")) {
//                     hero.setWeapon(weapon);
//                 }
//             }
//         }
//     }

}
