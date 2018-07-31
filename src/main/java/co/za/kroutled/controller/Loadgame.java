package co.za.kroutled.controller;

import co.za.kroutled.model.artefacts.Armor;
import co.za.kroutled.model.artefacts.Helm;
import co.za.kroutled.model.artefacts.Weapon;
import co.za.kroutled.model.characters.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Loadgame {

    public Loadgame() {}

    public List<Hero> createHeros()
    {
        List<Hero> heros = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            String loadHero;
            while ((loadHero = br.readLine()) != null)
            {
                heros.add(parseHeroLine(loadHero));
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("whoa");
        }
        catch (IOException e)
        {
            System.out.println("whoa");
        }
        return heros;
    }

    public Hero parseHeroLine(String heroLine)
    {
        String  heroAtts[] = heroLine.split(",");
        String  name = heroAtts[0];
        String  type = heroAtts[1];
        @Min(value = 0, message = "Attack should be higher than 0")
        @Max(value = 200, message = "Attack cannot be higher than 200")
        int     att = Integer.parseInt(heroAtts[2]);
        int     def = Integer.parseInt(heroAtts[3]);
        int     hp = Integer.parseInt(heroAtts[4]);
        int     maxHp = Integer.parseInt(heroAtts[5]);
        int     xp = Integer.parseInt(heroAtts[6]);
        int     lvl = Integer.parseInt(heroAtts[7]);

        String artefacts[] = { heroAtts[8], heroAtts[9], heroAtts[10] };

        Hero hero = new Hero();
        switch(type)
        {
            case "Druid":
                hero = new Druid(name, att, def, hp, maxHp, xp, lvl - 1);
                break;
            case "Mage":
                hero = new Mage(name, att, def, hp, maxHp, xp, lvl - 1);
                break;
            case "Warrior":
                hero = new Warrior(name, att, def, hp, maxHp, xp, lvl - 1);
                break;
        }
        if (hero.getType() != null)
            setHeroArtefacts(artefacts, hero);
        return hero;
    }

    public void setHeroArtefacts(String artefacts[], Hero hero)
    {
        if (!artefacts[0].equals("null"))
        {
            String arr[] = artefacts[0].split("#");
            Helm helm = new Helm(arr[0], Integer.parseInt(arr[1]));
            hero.setHelm(helm);
        }
        if (!artefacts[1].equals("null"))
        {
            String arr[] = artefacts[1].split("#");
            Armor armor = new Armor(arr[0], Integer.parseInt(arr[1]));
            hero.setArmor(armor);
        }
        if (!artefacts[2].equals("null"))
        {
            String arr[] = artefacts[2].split("#");
            Weapon weapon = new Weapon(arr[0], Integer.parseInt(arr[1]));
            hero.setWeapon(weapon);
        }
    }
}
