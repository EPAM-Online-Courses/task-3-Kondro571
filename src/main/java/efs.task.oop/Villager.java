Package efs.task.oop

class Villager implements Fighter{
    private String name;
    private int age;
    private int health = 100;
    private final double damage;
    private boolean isAlive = true;
    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
        this.damage = (100 - age * 0.5) / 10;
    }

    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + name + " and I'm " + age + " years old");
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getAge() {
        return age;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public void attack(Fighter victim) {
        if (isAlive()) {
            victim.takeHit((int) damage);
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


