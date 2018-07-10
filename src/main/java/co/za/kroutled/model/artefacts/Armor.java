package co.za.kroutled.model.artefacts;

import java.util.Random;

public class Armor extends Artefact{

    String armorNames[] = {"Fauld", "Plackard", "Corslet", "Cuirasse", "Brigandine"};
    Random rand = new Random();

    public Armor ()
    {
        super( 0);
        this.name = armorNames[rand.nextInt(5)];;
        boost = 0;
        this.type = "armor";
    }

    public Armor ( int level)
    {
        this.boost = rand.nextInt(10 * level);
        this.name = armorNames[rand.nextInt(5)];
        this.level = level;
        this.type = "armor";
    }
}
