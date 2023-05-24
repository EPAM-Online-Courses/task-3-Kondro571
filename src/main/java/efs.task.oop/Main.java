package efs.task.oop;

import java.util.Random;
public class Main {
    public static void main(String[] args) {

        Villager kashya = new Villager("Kashya", 30);
        Villager akara = new Villager("Akara", 40);
        Villager gheed = new Villager("Gheed", 50);
        Villager deckardCain = new Villager("Deckard Cain", 85);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        Villager[] villagers = {
                kashya,
                akara,
                gheed,
                deckardCain,
                warriv,
                flawia
        };

        for (Villager villager : villagers) {
            villager.sayHello();
        }
        villagers[1]=new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        villagers[3]=new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        System.out.println("----------------------------------------------------------------");
        for (Villager villager : villagers) {
            villager.sayHello();
        }


        Object objectDeckardCain = villagers[1];
        Object objectAkara = villagers[3];

        System.out.println("----------------------------------------------------------------");

        int n=villagers.length;
        int index = 0;
        Monsters monsters = new Monsters();

        while (monsters.monstersHealth>0 && cheakIfAlives(villagers)) {


            do{
                Random random = new Random();
                index=random.nextInt(n);
            } while (villagers[index].getHealth()<=0);

            if(monsters.andariel.getHealth()>0) {
                villagers[index].attack(monsters.andariel);
            }else {
                villagers[index].attack(monsters.blacksmith);
            }

            if(monsters.andariel.getHealth()>0) {
                monsters.andariel.attack(villagers[index]);
            }else {
                monsters.blacksmith.attack(villagers[index]);
            }

            System.out.println("Potwory posiadaja jeszcze " + monsters.monstersHealth + " punkty zycia ");
            System.out.println("Aktualnie walczacy osadnik to " + villagers[index].getName());


        }
        if(cheakIfAlives(villagers)){
            System.out.println("Obozowisko ocalone!");
        }else{
            System.out.println("Obozowisko nie ocalone!");
        }


        villagers[3] = (ExtraordinaryVillager) objectDeckardCain;
        villagers[3].sayHello();

        villagers[1] = (ExtraordinaryVillager) objectAkara;
        villagers[1].sayHello();



    }

    public static boolean cheakIfAlives(Villager[] villagers){
        for (Villager villager : villagers) {
            if(villager.getHealth()>0)
                return true;
        }
        return false;
    }
}
