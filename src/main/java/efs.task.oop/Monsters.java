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
                health=0;
            }
             monstersHealth-=(damage+5);
          }
    };
    Monster getAndariel(){
        return andariel;
    }

    Monster getBlacksmith(){
        return blacksmith;
    }
    public static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    int getMonstersHealth(){
        return  monstersHealth;
    }
}
