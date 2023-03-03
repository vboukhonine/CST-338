/*
Title: StormTrooper.java
Abstract: This file extends Trooper and instantiates the march function it inherits from trooper.
It contains some basic info on a StormTrooper and I also modify the MarchModifier
Author: Vera Boukhonine
Date: 03/12/2022
* */



public class StormTrooper extends Trooper {
    private String name = "";
    private static int soldierCount = 0;

    StormTrooper(String unit, int number) {
        super(unit, number);
        this.name = name;
        this.soldierCount = soldierCount;
        soldierCount++;
        setTrooperKind("StormTrooper");
        setMarchModifier(1.10);
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
        return "("+getUnit()+getNumber()+": )"+"a "+getTrooperKind();
    }
}
