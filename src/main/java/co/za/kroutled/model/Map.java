package co.za.kroutled.model;

import co.za.kroutled.controller.Battle;
import co.za.kroutled.model.characters.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {

    public int  level = 1;
    public int  mapX = (level-1)*5+10-(level%2);
    public int  mapY = mapX;
    List<Enemy> enemies  = new ArrayList<>();

    private static int enemyCount = 0;
    private Hero hero;

    public Map (Hero hero)
    {
        this.hero = hero;
    }

    public void moveUp()
    {
        hero.setYPos(hero.getYPos() - 1);
    }

    public void moveDown()
    {
        hero.setYPos(hero.getYPos() + 1 );
    }

    public void moveLeft()
    {
        hero.setXPos(hero.getXPos() - 1);
    }

    public void moveRight()
    {
        hero.setXPos(hero.getXPos() + 1);
    }

    public Hero getHero()
    {
        return this.hero;
    }

    public void setHeroPos()
    {
        hero.setXPos(mapX/2);
        hero.setYPos(mapY/2);
    }

    public boolean inMap()
    {
        if (hero.getXPos() < 0 || hero.getXPos() > mapX)
            return false;
        else if (hero.getYPos() < 0 || hero.getYPos() > mapY)
            return false;
        return true;
    }

    public void enemyFarm()
    {
        Random rand = new Random();
        while (enemyCount < level * 3)
        {
            Enemy enemy = new Enemy();

            enemy.setXPos(rand.nextInt(mapX));
            enemy.setYPos(rand.nextInt(mapY));
            if (enemy.getXPos() != hero.getXPos() && enemy.getYPos() != hero.getYPos()) {
                System.out.println("Enemy spawned");
                enemies.add(enemy);
                enemyCount ++;
            }
            else
                enemyFarm();
        }
    }

    public void callEnemy()
    {
        for (Enemy enemy:enemies)
        {
            System.out.println(enemy.getName());
            System.out.println(enemy.getXPos());
            System.out.println(enemy.getYPos());
        }
    }

    public void checkCollision(Hero hero)
    {
        Enemy foundEnemy = null;
        for(Enemy enemy: enemies)
        {
            if (enemy.getXPos() == hero.getXPos() && enemy.getYPos() == hero.getYPos())
            {
                foundEnemy = enemy;
            }
        }
        if (foundEnemy != null) {
            Battle fight = new Battle();
            int fightCheck = fight.fightCheck(hero, foundEnemy);
            while (fightCheck == 0)
            {
                fightCheck = fight.fightCheck(hero, foundEnemy);
            }

            if (fightCheck == 1)
            {
                int fightResult = fight.fight(hero, foundEnemy);
                if (fightResult == 1) {
                    enemies.remove(foundEnemy);
                }
            }
        }

    }

//    public void newLevel(Hero hero)
//    {
//        this.level++;
//
//        hero.setXPos();
//        hero.setYPos();
//    }
}
