package co.za.kroutled.model.artefacts;

import javax.validation.constraints.NotNull;

public class Artefact {

    protected String    type;
    @NotNull(message = "Name cannot be null")
    protected String    name;
    protected int       boost;
    protected int       level;

    public Artefact ()
    {
        this.type = "Artefact";
        this.name = "Artefact";
        this.boost = 0;
        this.level = 0;
    }

    public Artefact (int level)
    {
        this.level = level;
    }

    public String getName()
    {
        return this.name;
    }

    public int getBoost()
    {
        return this.boost;
    }

    public String getType()
    {
        return this.type;
    }

}
