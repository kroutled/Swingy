package co.za.kroutled.controller;

import co.za.kroutled.model.characters.Enemy;
import co.za.kroutled.model.characters.Hero;

import java.util.Random;

public class Battle {

    public Battle (Hero hero, Enemy enemy) {

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
            System.out.println("The enemy " + enemy.getName() + " " + moves[rand.nextInt(5)] + "s you! You have taken " + enemyDmg);
            hero.takeDmg(enemyDmg);
            utils.sleep(1000);
            System.out.println(hero.getName() + ":" + hero.getHp() + " VS " + enemy.getName() + ":" + enemy.getHp());
        }

        if (enemy.getHp() == 0)
        {
            int     lvledUp = hero.setXp(350);
            if (lvledUp == 1)
                System.out.println("You defeated the enemy and leveled up!");
            else
                System.out.println("You defeated the enemy and gained 350xp!");
        }
    }
}
