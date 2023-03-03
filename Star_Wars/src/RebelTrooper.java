/*
Title: RebelTrooper.java
Abstract: This file extends Trooper and instantiates the march function it inherits from trooper.
It contains some basic info on a RebelTrooper and I also modify the MarchModifier
Author: Vera Boukhonine
Date: 03/12/2022
* */

public class RebelTrooper extends Trooper {
    private String name = "Rebel";
    private static int soldierCount = 0;

    RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        this.name = name;
        soldierCount++;
        setTrooperKind("pilot");
        setMarchModifier(0.75);
    }

    @Override
    public double march(double duration) {
        return marchSpeed * marchModifier * duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public void setSoldierCount(int soldierCount) {
        this.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return name+"("+getUnit()+getNumber()+": )" +" a "+getTrooperKind();
    }
}
