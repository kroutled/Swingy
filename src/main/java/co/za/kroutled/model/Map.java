package co.za.kroutled.model;

import co.za.kroutled.model.characters.Hero;

public class Map {

    public int  mapX;
    public int  mapY;


    private Hero hero;

    public Map (Hero hero)
    {
        this.hero = hero;
    }

    public void moveUp()
    {
        hero.heroY++;
    }

    public void moveDown()
    {
        hero.heroY--;
    }

    public void moveLeft()
    {
        hero.heroX--;
    }

    public void moveRight()
    {
        hero.heroX++;
    }


}
