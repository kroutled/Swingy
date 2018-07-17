package co.za.kroutled.model.characters;

public class Druid extends Hero{

    public Druid()
    {
        super("Druid");
    }

    public Druid(String name)
    {
        super (name);
        this.type = "Druid";
        this.attack += 3;
        this.defense += 8;
        this.hitPoints += 20;
        this.maxHp += 20;

    }

    public Druid(String name, int att, int def, int hp, int xp, int lvl)
    {
        this.setName(name);
        this.type = "Druid";
        this.setAttack(att);
        this.setDefense(def);
        this.setHp(hp);
        this.setlvl(lvl);
        this.setXp(xp);
    }
}
