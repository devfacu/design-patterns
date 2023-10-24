package main.facudev.org.factorymethodrebuilt.entity;

public abstract class EnemyShip {
    protected String name;
    protected double amtDamage;

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public double getDamage() { return this.amtDamage; }
    public void setDamage(double damage) { this.amtDamage = damage; }

    public void followHeroShip(){
        System.out.println(getName() + " is following the hero");
    };
    public void displayEnemyShip() {
        System.out.println(getName() + " is on the screen");
    };
    public void enemyShipShoots() {
        System.out.println(getName() + " attacks and does " + getDamage() + " points of damage");
    };
}
