package co.za.kroutled.Utilities;

import co.za.kroutled.model.characters.Hero;

import java.io.*;

public class Writer {

    public static PrintWriter writer = null;

    public void saveHero(Hero hero) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {

            fw = new FileWriter("/goinfre/kroutled/Desktop/Swingy/test.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(hero.getName() + "," + hero.getType() + "," + hero.getAttack() + "," + hero.getDefense() + "," + hero.getHp() + "," + hero.getXp() + "," + hero.getLvl());
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found exception ");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("File specification error");
        }
        catch (Exception e)
        {
            System.out.println("Unrecognised symbols in file");
            e.printStackTrace();
        }
    }
}
