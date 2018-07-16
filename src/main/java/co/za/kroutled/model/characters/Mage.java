package co.za.kroutled.model.characters;

public class Mage extends Hero{

    public Mage()
    {
        super("Mage");
    }

    public Mage(String name)
    {
        super(name);
        this.type = "Mage";
        this.attack += 12;
        this.defense += 2;
    }
}
