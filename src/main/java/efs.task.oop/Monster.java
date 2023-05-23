abstract class Monster implements Fighter {
    private int health;
    private int damage;
    private boolean isAlive = true;
    protected Monster(int health, int damage) {
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
        if (isAlive()) {
            victim.takeHit(damage);
        }
    }
    @Override
    public void takeHit(int damage) {
        if (isAlive()) {
            health -= damage;
            if (health <= 0) {
                isAlive = false;
                health=0;
            }
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}