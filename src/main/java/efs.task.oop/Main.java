package efs.task.oop;

import java.util.Random;
public class Main {
    public static void main(String[] args) {
 
        Villager[] villagers = {
                new Villager("Kashya", 30),
                new Villager("Akara", 40),
                new Villager("Gheed", 50),
                new Villager("Deckard Cain", 85),
                new Villager("Warriv", 35),
                new Villager("Flawia", 25)
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

        Object objectAkara = villagers[1];
        Object objectDeckardCain = villagers[3];


        System.out.println("----------------------------------------------------------------");

        int n=villagers.length;
        int index = 0;
        Monsters monsters = new Monsters();

        while (monsters.getMonstersHealth()>0 && cheakIfAlives(villagers)) {


            do{
                Random random = new Random();
                index=random.nextInt(n);
            } while (villagers[index].getHealth()<=0);

            if(monsters.getAndariel().getHealth()>0) {
                villagers[index].attack(monsters.getAndariel());
            }else {
                villagers[index].attack(monsters.getBlacksmith());
            }

            if(monsters.getAndariel().getHealth()>0) {
                monsters.getAndariel().attack(villagers[index]);
            }else {
                monsters.getBlacksmith().attack(villagers[index]);
            }

            System.out.println("Potwory posiadaja jeszcze " + monsters.getMonstersHealth() + " punkty zycia ");
            System.out.println("Aktualnie walczacy osadnik to " + villagers[index].getName());


        }
        if(cheakIfAlives(villagers)){
            System.out.println("Obozowisko ocalone!");
        }else{
            System.out.println("Obozowisko nie ocalone!");
        }



        for (Villager villager : villagers) {
            if (villager instanceof ExtraordinaryVillager) {
                ExtraordinaryVillager extraordinaryVillager = (ExtraordinaryVillager) villager;
                extraordinaryVillager.sayHello();
            }
        }

    }

    public static boolean cheakIfAlives(Villager[] villagers){
        for (Villager villager : villagers) {
            if(villager.getHealth()>0)
                return true;
        }
        return false;
    }
}

