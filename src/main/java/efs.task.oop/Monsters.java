package efs.task.oop;

public class Monsters {
    static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

    };

    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(5 + getDamage());
        }
    };
    Monster getAndariel(){
        return andariel;
    }

    Monster getBlacksmith(){
        return blacksmith;
    }
    static int monstersHealth = andariel.getHealth() + blacksmith.getHealth();

    int getMonstersHealth(){
        monstersHealth = andariel.getHealth() + blacksmith.getHealth();
        return  monstersHealth;
    }
}
