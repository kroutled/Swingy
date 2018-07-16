package co.za.kroutled.model.characters;

public class Warrior extends Hero {

    public Warrior()
    {
        super("Warrior");
    }

    public Warrior(String name)
    {
        super (name);
        this.type = "Warrior";
        this.attack += 5;
        this.defense += 10;

    }
}
