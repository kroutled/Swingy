package co.za.kroutled.model.characters;

import  co.za.kroutled.model.artifacts.*;

public class Hero extends Character {

    protected int lvl = 0;
    protected int xp = 0;
    protected String name;

    private Armor armor = new Armor();
    private Weapon weapon = new Weapon();

    public Hero(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public int getXp()
    {
        return this.xp;
    }
}
