package com.company;

/**
 * Created by liaokai on 16/1/21.
 */
public class Hero {
    // attributes
    public String firstName;
    public double health;
    public double attDmg;
    public double defence;
    public int shieldNum;
    public boolean isBoss;
    public double crit;

    // constructors
    public Hero(String firstName, double health, double attDmg, double defence, int shieldNum, double crit) {
        this.firstName = firstName;
        this.health = health;
        this.attDmg = attDmg;
        this.defence = defence;
        this.shieldNum = shieldNum;
        this.isBoss = false;
        this.crit = crit;
    }

    // methods
    public void attcak(Hero defender) {
        double attDmgThisTime = this.getDmg(defender);
        defender.getHurt(attDmgThisTime);
        System.out.print(this.firstName + " attacked " + defender.firstName + " by " + attDmgThisTime);
        System.out.println(". Now " + defender.firstName + "'s health is " + defender.health);
    }

    public void attackEachOther(Hero enemy) {
        this.attcak(enemy);
        enemy.attcak(this);
    }

    //helpers
    public void becomeBoss() {
        this.isBoss = true;
    }

    private void getHurt(double dmg) {
        this.health -= dmg;
    }

    private double getDmg(Hero denfender) {
        double result;
        if (denfender.shieldNum > 0) { // if defender has shield
            result = 0;
            denfender.shieldNum--;
        } else {
            if (this.isBoss && this.health < 100) { // if this is BOss and this health is below 100
                result = this.attDmg * (1 + this.crit) * 2 - denfender.defence;
            } else {
                result = this.attDmg * (1 + this.crit) - denfender.defence;
            }
        }
        return result;
    }
}

