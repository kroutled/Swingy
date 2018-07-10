package co.za.kroutled.model.artefacts;

import java.util.Random;

public class Weapon extends Artefact{

    String weaponNames[] = {"Axe", "Sword", "Mace", "Great Sword", "Lance"};
    Random rand = new Random();

    public Weapon ()
    {
        super( 0);
        this.name = weaponNames[rand.nextInt(5)];
        boost = 0;
        this.type = "weapon";
    }

    public Weapon (int level)
    {
        this.level = level;
        this.name = weaponNames[rand.nextInt(5)];
        this.boost = rand.nextInt(10 * level);
        this.type = "weapon";
    }
}
