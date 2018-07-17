package co.za.kroutled.model.artefacts;

import java.util.Random;

public class Helm extends Artefact {

    String helmNames[] = {"Bascinet", "Armet", "Sallet", "Barbute", "Templar Helm"};
    Random rand = new Random();

    public Helm ()
    {
        super( 0);
        this.name = helmNames[rand.nextInt(5)];
        boost = 0;
        this.type = "helm";
    }

    public Helm (int level)
    {
        this.boost = rand.nextInt(10 * level);
        this.name = helmNames[rand.nextInt(5)];
        this.level = level;
        this.type = "helm";
    }

    public Helm (String name, int boost)
    {
        this.name = name;
        this.boost = boost;
    }
}
