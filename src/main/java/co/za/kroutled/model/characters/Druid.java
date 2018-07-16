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
}
