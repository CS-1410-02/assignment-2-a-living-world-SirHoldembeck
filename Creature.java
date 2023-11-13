
import java.util.ArrayList;
import java.util.List;

public class Creature {
    private String name;
    private double replicationChance;
    double deathChance;

    public Creature(String name, double replicationChance, double deathChance) {
        this.name = name;
        this.replicationChance = replicationChance;
        this.deathChance = deathChance;
    }

    public void die() {
        System.out.println(name + " has died.");
    }

    public Creature reproduce() {
        if (Math.random() < replicationChance) {
            System.out.println(name + " has reproduced.");
            return new Creature(Names.generateRandomName(), replicationChance, deathChance);
        } else {
            System.out.println(name + " has failed to reproduce.");
            return null;
        }
    }
}

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
