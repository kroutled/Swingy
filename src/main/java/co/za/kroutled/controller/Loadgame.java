package co.za.kroutled.controller;

import co.za.kroutled.model.artefacts.Armor;
import co.za.kroutled.model.artefacts.Helm;
import co.za.kroutled.model.artefacts.Weapon;
import co.za.kroutled.model.characters.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loadgame {

    public Loadgame() {}

    public List<Hero> createHeros()
    {
        List<Hero> heros = new ArrayList<>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("/goinfre/kroutled/Desktop/Swingy/test.txt"));
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
        int     att = Integer.parseInt(heroAtts[2]);
        int     def = Integer.parseInt(heroAtts[3]);
        int     hp = Integer.parseInt(heroAtts[4]);
        int     xp = Integer.parseInt(heroAtts[5]);
        int     lvl = Integer.parseInt(heroAtts[6]);

        String artefacts[] = { heroAtts[7], heroAtts[8], heroAtts[9] };

        Hero hero = new Hero();
        switch(type)
        {
            case "Druid":
                hero = new Druid(name, att, def, hp, xp, lvl);
                break;
            case "Mage":
                hero = new Mage(name, att, def, hp, xp, lvl);
                break;
            case "Warrior":
                hero = new Warrior(name, att, def, hp, xp, lvl);
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
