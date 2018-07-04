package co.za.kroutled.model.characters;

public class Character {

    protected int       attack = 0;
    protected int       defense = 0;
    protected int       hitPoints = 0;
    protected int       maxHp = 100;

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
