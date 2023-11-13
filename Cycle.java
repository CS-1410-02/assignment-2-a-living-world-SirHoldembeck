public class Cycle {
    public static void main(String[] args) {
        World world = new World();

        // Simulate 10 days
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println("Day "+ (i+1));
            System.out.println("--------------");
            world.createCreature();
            world.spawnFood();
            world.simulateDay();
        }
    }
}
