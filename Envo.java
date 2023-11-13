import java.util.ArrayList;
import java.util.List;

class World {
    private List<Creature> creatures = new ArrayList<>();
    
    public void createCreature() {
        String randomName = Names.generateRandomName();
        double replicationChance = Math.random();
        double deathChance = Math.random();
        Creature newCreature = new Creature(randomName, replicationChance, deathChance);
        creatures.add(newCreature);
        System.out.println("A new creature, " + randomName + ", has been created.");
    }

    public void spawnFood() {
        System.out.println("Food has spawned in the world.");
    }

    public void simulateDay() {
        for (Creature creature : creatures) {
            if (Math.random() < creature.deathChance) {
                creature.die();
            } else {
                Creature offspring = creature.reproduce();
                if (offspring != null) {
                    creatures.add(offspring);
                }
            }
        }
    }
}