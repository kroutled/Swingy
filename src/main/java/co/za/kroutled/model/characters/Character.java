package co.za.kroutled.model.characters;

public class Character {

    public              String name;
    protected int       attack;
    protected int       defense;
    protected int       hitPoints;
    protected int       maxHp;


    public Character(){}

    public Character(String name, int attack, int defense, int hitPoints, int maxHp) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.maxHp = maxHp;
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

    public String getName()
    {
        return this.name;
    }

    public void     setHp(int val)
    {
        this.hitPoints = val;
    }

    public void     takeDmg(int val)
    {
        this.hitPoints -= val;
        if (this.hitPoints < 0)
            this.hitPoints = 0;
    }
}
