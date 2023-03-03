package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

abstract public class Monster {
    private Integer hp;
    private Integer xp;
    Integer agility=0;
    Integer defense=0;
    Integer strength=0;
    Attack attack;
    private Integer maxHP;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.items = items;
        this.xp = xp;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer attackTarget(Monster target){
        int attacking = attack.attack(target);
        if(hp>=0){
            target.takeDamage(attacking);
            return attacking;
        }
        target.takeDamage(attacking);
        return 0;
    }
    boolean takeDamage(Integer damage){
        if(damage>0){
            hp-=damage;
            System.out.println("The creature was hit for "+ damage +" damage");
        }
        if(hp==0||hp<0){
            hp = 0;
            System.out.println("Oh no! the creature has perished");
        }
        if(hp>0){
            this.toString();
            return true;
        }
        return false;
    }
    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(Integer maxHP) {
        this.maxHP = maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStrength() {
        return strength;
    }

    public Attack getAttack() {
        return attack;
    }

    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(hp, monster.hp) && Objects.equals(xp, monster.xp) && Objects.equals(agility, monster.agility) && Objects.equals(defense, monster.defense) && Objects.equals(strength, monster.strength) && Objects.equals(attack, monster.attack) && Objects.equals(maxHP, monster.maxHP) && Objects.equals(items, monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, agility, defense, strength, attack, maxHP, items);
    }

    @Override
    public String toString() {
        return "hp="+hp+"/"+maxHP;
    }
}
