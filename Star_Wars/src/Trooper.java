import java.util.*;
/*
Title: Trooper.java
Abstract: This file creates an abstract class of Trooper whose functionality is then extended later.
It contains on abstract method march() which is instantiated in its child classes. This class setups up the guideline
for what a troopers like StormTrooper and RebelTrooper contain.
Author: Vera Boukhonine
Date: 03/12/2022
* */
abstract public class Trooper {
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier = 1.10;

    Trooper() {
        this("AA", 0);
    }

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        marchSpeed = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        if (t == null) {
            return;
        } else if (!units.containsKey(t.getUnit())) {
            List<Trooper> trooper = new ArrayList<>();
            trooper.add(t);
            units.put(t.getUnit(), trooper);
            return;
        } else {
            units.get(t.getUnit()).add(t);
        }
    }

    public abstract double march(double marchSpeed);

    public boolean attack(Trooper target, int roll) {
        if (target == null) {
            return false;
        }
        System.out.println(this.toString() + " is attacking " + target.toString());
        System.out.println(this.toString() + " rolled a " + roll);
        if (this.equals(target) || roll == 1) {
            System.out.println(this.toString() + " is targeting itself");
            System.out.println(this.toString() + " rolled a " + roll + " and hurt itself in the confusion");
            return true;
        } else if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("rolled a " + roll + " against the rebel scum.");
                if (roll > 10 && roll % 2 == 0) {
                    return true;
                }
            } else if (target instanceof StormTrooper) {
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable Collateral Damage!");
                if (roll > 10 || roll % 2 == 0) {
                    return true;
                }
            }
        } else if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target instanceof StormTrooper) {
                System.out.println("rolled a " + roll + " against the imperial scum.");
                if (roll > 5 || roll % 2 != 0) {
                    return true;
                }
            } else {
                System.out.println("Rebels target an innocent bystander");
                if (roll >= 18 && roll % 2 == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getUnit() {return unit;}

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {return number;}

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    @Override
    public String toString() {
        return "Trooper{" +
                "unit='" + unit + '\'' +
                ", number=" + number +
                ", trooperKind='" + trooperKind + '\'' +
                ", marchSpeed=" + marchSpeed +
                ", marchModifier=" + marchModifier +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(trooper.marchSpeed, marchSpeed) == 0 && Double.compare(trooper.marchModifier, marchModifier) == 0 && unit.equals(trooper.unit) && trooperKind.equals(trooper.trooperKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }
}
