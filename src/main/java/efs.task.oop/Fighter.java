package efs.task.oop

interface Fighter {
    void attack(Fighter victim);
    void takeHit(int damage);
    boolean isAlive();
}
