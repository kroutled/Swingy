package co.za.kroutled.model;

import co.za.kroutled.model.characters.Hero;

public class Map {

    public int  level = 1;
    public int  mapX = (level-1)*5+10-(level%2);
    public int  mapY = mapX;


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
}
