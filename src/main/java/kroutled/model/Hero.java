package main.java.kroutled.model;

public class Hero {

    protected String    name;
    protected int       lvl = 0;
    protected int       xp = 0;
    protected int       attack = 0;
    protected int       defense = 0;
    protected int       hitPoints = 0;
    protected int       maxHp = 100;

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

    public int  getAttack()
    {
        return this.attack;
    }

    public int  getDefense()
    {
        return this.defense;
    }

    public int  getHp()
    {
        return this.hitPoints;
    }

    public int  getMaxHp()
    {
        return this.maxHp;
    }


}
