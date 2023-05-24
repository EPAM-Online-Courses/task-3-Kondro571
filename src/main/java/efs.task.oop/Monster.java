package efs.task.oop;

abstract class Monster implements Fighter {
    protected int health;
    protected int damage;
    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void attack(Fighter victim) {

            victim.takeHit(damage);

    }
    @Override
    public void takeHit(int damage) {

            health -= damage;
            if (health <= 0) {
                health=0;
            }

    }


}
