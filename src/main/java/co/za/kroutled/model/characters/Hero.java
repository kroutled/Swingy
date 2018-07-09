package co.za.kroutled.model.characters;

import  co.za.kroutled.model.artefacts.*;

public class Hero extends Character {

    private int  lvl;
    private int  xp = 0;
    public int neededXP;

    private Armor armor = new Armor();
    private Weapon weapon = new Weapon();

    public Hero(String name)
    {
        super (name, 20, 3, 100, 100);
        this.lvl = 1;
        this.xp = 0;
        this.neededXP = (int) (this.lvl * 1000 + (Math.pow(this.lvl - 1 , 2) * 450));
    }

    public Hero(String name, int attack, int defense, int hitPoints, int maxHp, int lvl, int xp)
    {
        super(name,attack, defense, hitPoints, maxHp);
        this.lvl = lvl;
        this.lvl = xp;
        this.neededXP = (int) (this.lvl * 1000 + (Math.pow(this.lvl - 1 , 2) * 450));
    }

    public int getLvl()
    {
        return this.lvl;
    }

    public int getXp()
    {
        return this.xp;
    }

    public int setXp(int val)
    {
        System.out.println(this.neededXP);
        this.xp += val;
        if (this.xp >= this.neededXP)
        {
            lvlUp(1);
            this.xp -= this.neededXP;
            return 1;
        }
        return 0;
    }

    public void     lvlUp(int lvl)
    {
        this.lvl += lvl;
        //include growth stats

    }
}
