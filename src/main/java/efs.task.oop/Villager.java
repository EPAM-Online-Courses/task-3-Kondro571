package efs.task.oop;

class Villager implements Fighter{
    protected  String name;
    protected  int age;
    protected int health = 100;

    public Villager(String name, int age) {
        this.name = name;
        this.age = age;
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
        return (100 - age * 0.5) / 10;
    }

    @Override
    public void attack(Fighter victim) {

            victim.takeHit((int) (100 - age * 0.5) / 10);

    }

    @Override
    public void takeHit(int damage) {
            health -= damage;
            if (health <= 0) {
                health=0;
            }

    }

}


