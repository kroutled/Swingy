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

    public void setHeroPos()
    {
        hero.setXPos(mapX/2);
        hero.setYPos(mapY/2);
    }

    public boolean inMap()
    {
        if (hero.getXPos() <= 0 || hero.getXPos() > mapX)
            return false;
        else if (hero.getYPos() < 0 || hero.getYPos() > mapY)
            return false;
        return true;
    }

    public void enemyFarm()
    {
        for (int i = 0; i < (level * 3); i++)
        {
            Enemy enemy = new Enemy();
            Random rand = new Random();
            enemy.setXPos(rand.nextInt(mapX));
            enemy.setYPos(rand.nextInt(mapY));
            if (enemy.getXPos() != mapX/2 && enemy.getYPos() != mapY/2)
                enemies.add(enemy);
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
        for(Enemy enemy:enemies)
        {
            if (enemy.getXPos() == hero.getXPos() && enemy.getYPos() == hero.getYPos())
            {
                Battle fight = new Battle();
                if (fight.runFight(hero, enemy) == 1)
                {
                    enemies.remove(enemy);
                    break;
                }
                else
                {

                }
            }
        }
    }
}
