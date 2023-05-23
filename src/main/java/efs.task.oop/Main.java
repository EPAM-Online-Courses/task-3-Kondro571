import java.util.Random;
public class Main {
    public static void main(String[] args) {
 /*

        Villager kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

    Villager deckardCain = new Villager("Deckard Cain", 85);
        Villager akara = new Villager("Akara", 40);
        ExtraordinaryVillager extraordinaryDeckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        ExtraordinaryVillager extraordinaryAkara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);

        deckardCain.sayHello();
        akara.sayHello();
        extraordinaryDeckardCain.sayHello();
        extraordinaryAkara.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
        Object objectExtraordinaryDeckardCain = extraordinaryDeckardCain;
        Object objectExtraordinaryAkara = extraordinaryAkara;

        System.out.println("Can objectDeckardCain call ExtraordinaryVillager methods? " + (objectDeckardCain instanceof ExtraordinaryVillager));
        System.out.println("Can objectAkara call ExtraordinaryVillager methods? " + (objectAkara instanceof ExtraordinaryVillager));
        System.out.println("Can objectExtraordinaryDeckardCain call ExtraordinaryVillager methods? " + (objectExtraordinaryDeckardCain instanceof ExtraordinaryVillager));
        System.out.println("Can objectExtraordinaryAkara call ExtraordinaryVillager methods? " + (objectExtraordinaryAkara instanceof ExtraordinaryVillager));
    
        */

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
            } while (!villagers[index].isAlive());

            if(monsters.getAndariel().isAlive()) {
                villagers[index].attack(monsters.getAndariel());
            }else {
                villagers[index].attack(monsters.getBlacksmith());
            }

            if(monsters.getAndariel().isAlive()) {
                monsters.getAndariel().attack(villagers[index]);
            }else {
                monsters.getBlacksmith().attack(villagers[index]);
            }

            System.out.println("Potwory posiadają jeszcze " + monsters.getMonstersHealth() + " punkty życia ");
            System.out.println("Aktualnie walczący osadnik to " + villagers[index].getName());


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
            if(villager.isAlive())
                return true;
        }
        return false;
    }
}

