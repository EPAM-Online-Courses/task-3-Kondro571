package efs.task.oop

class ExtraordinaryVillager extends Villager {
    public enum Skill {
        IDENTIFY("I will identify items for you at no charge."),
        SHELTER("I can offer you poor shelter.");

        private String description;

        Skill(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private Skill skill;

    public ExtraordinaryVillager(String name, int age, Skill skill) {
        super(name, age);
        this.skill = skill;
    }

    @Override
    public void sayHello() {
        System.out.println("Greetings traveler... I'm " + getName() + " and I'm " + getAge() + " years old. " + skill.getDescription());
    }

    @Override
    public void attack(Fighter victim) {
        // Nie zadaje żadnych obrażeń
    }

    @Override
    public void takeHit(int damage) {
        // Ginie od jednego ciosu
        super.takeHit(Integer.MAX_VALUE);
    }
}
