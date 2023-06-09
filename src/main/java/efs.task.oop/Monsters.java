package efs.task.oop;


public class Monsters {
    static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }
        @Override
        public void takeHit(int damage) {

            health -= damage;
            if (health <= 0) {
                damage+=health;
                health=0;
            }
            monstersHealth-=damage;
        }

    };

    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }
        @Override
        public void takeHit(int damage) {
            health -= (damage+5);
            if (health <= 0) {
                damage+=health;
                health=0;
            }
            monstersHealth-=(damage+5);
        }
    };
    
    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

   
}

