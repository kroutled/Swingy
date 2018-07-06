package co.za.kroutled.model.characters;

import java.util.Random;
import co.za.kroutled.model.Map;

public class Enemy extends Character {

    private String[] names = { "Goblin", "Orc", "Troll", "Drake", "Murloc" };

    public Enemy()
    {
        Random rand = new Random();
        String enemyType = names[rand.nextInt(5)];
        int enemyAttack = rand.nextInt(11) + 5;
        int enemyDefense = rand.nextInt(5) + 0;
        int enemyHP = rand.nextInt(50) + 23;
        this.name = enemyType;
        this.attack = enemyAttack;
        this.defense = enemyDefense;
        this.hitPoints = enemyHP;
        this.maxHp = enemyHP;
    }

    public void setEnemyPos(Map map)
    {
        Random rand = new Random();
        this.setXPos(rand.nextInt(map.mapX));
        this.setYPos(rand.nextInt(map.mapY));
    }

}
